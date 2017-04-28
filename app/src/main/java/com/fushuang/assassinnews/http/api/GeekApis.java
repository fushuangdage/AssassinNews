package com.fushuang.assassinnews.http.api;

import com.fushuang.assassinnews.model.GankItemBean;
import com.fushuang.assassinnews.model.GeekFuliBean;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by fushuang on 2017/3/30.
 */

public interface GeekApis {

    String HOST = "http://gank.io/api/";


    /**
     * 妹纸列表
     */
    @GET("data/福利/{num}/{page}")
    Observable<GeekFuliBean> getGirlList(@Path("num") int num, @Path("page") int page);
}
