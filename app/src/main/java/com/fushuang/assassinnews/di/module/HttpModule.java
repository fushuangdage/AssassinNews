package com.fushuang.assassinnews.di.module;

import com.fushuang.assassinnews.Constants;
import com.fushuang.assassinnews.di.qualifier.GeekUrl;
import com.fushuang.assassinnews.di.qualifier.WxUrl;
import com.fushuang.assassinnews.di.qualifier.ZhihuUrl;
import com.fushuang.assassinnews.http.RetrofitHelper;
import com.fushuang.assassinnews.http.api.GeekApis;
import com.fushuang.assassinnews.http.api.WxApis;
import com.fushuang.assassinnews.http.api.ZhihuApis;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fushuang on 2017/3/10.
 */
@Module
public class HttpModule {

    @Singleton
    @Provides
    Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    @Singleton
    @Provides
    OkHttpClient.Builder provideOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }

    @Singleton
    @Provides
    OkHttpClient provideClient(OkHttpClient.Builder builder){
        File cacheFile = new File(Constants.PATH_CACHE);
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
        Interceptor cacheIntercepter = new Interceptor(){

            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                request = request.newBuilder().cacheControl(CacheControl.FORCE_NETWORK).build();
                Response response = chain.proceed(request);
                int maxAge = 0;
                // 有网络时, 不缓存, 最大保存时长为0
                response.newBuilder()
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .removeHeader("Pragma")
                        .build();
                return response;
            }
        };
        builder.addNetworkInterceptor(cacheIntercepter);
        builder.addInterceptor(cacheIntercepter);
        builder.cache(cache);
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(true);

        return builder.build();
    }

    @Singleton
    @Provides
    @ZhihuUrl
    Retrofit provideZhihuRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, ZhihuApis.HOST);
    }

    @Singleton
    @Provides
    @GeekUrl
    Retrofit provideGeekRetrofit(Retrofit.Builder builder,OkHttpClient client){
        return createRetrofit(builder,client,GeekApis.HOST);
    }

    @Singleton
    @Provides
    @WxUrl
    Retrofit provideWxRetrofit(Retrofit.Builder builder,OkHttpClient client){
        return createRetrofit(builder,client,WxApis.HOST);
    }

    @Singleton
    @Provides
    ZhihuApis provideZhihuService(@ZhihuUrl Retrofit retrofit){
        return retrofit.create(ZhihuApis.class);
    }


    @Singleton
    @Provides
    WxApis provideWxServices(@WxUrl Retrofit retrofit){
        return retrofit.create(WxApis.class);
    }

    @Singleton
    @Provides
    GeekApis provideGeekServices(@GeekUrl Retrofit retrofit){
        return retrofit.create(GeekApis.class);
    }

    private Retrofit createRetrofit(Retrofit.Builder builder, OkHttpClient client, String host) {
        return builder
                .baseUrl(host)
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


}
