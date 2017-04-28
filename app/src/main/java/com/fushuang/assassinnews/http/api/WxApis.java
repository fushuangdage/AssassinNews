package com.fushuang.assassinnews.http.api;

import com.fushuang.assassinnews.model.WxHotBean;


import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by fushuang on 2017/4/24.
 */

public interface WxApis {
    String HOST = "http://api.tianapi.com/";

    @GET("wxnew")
    Observable<WxHotBean> getWXHot(@Query("key") String key, @Query("num") int num, @Query("page") int page);
}
