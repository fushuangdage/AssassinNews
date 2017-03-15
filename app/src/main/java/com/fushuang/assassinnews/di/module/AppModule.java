package com.fushuang.assassinnews.di.module;

import com.fushuang.assassinnews.App;
import com.fushuang.assassinnews.http.RetrofitHelper;
import com.fushuang.assassinnews.http.api.ZhihuApis;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by fushuang on 2017/3/10.
 */
@Module
public class AppModule {
  private final App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    App provideApplicationContext(){
        return application;
    }

    @Provides
    @Singleton
    RetrofitHelper provideRetrofitHelper(ZhihuApis zhihuApis){
            return new RetrofitHelper(zhihuApis);
    }


}
