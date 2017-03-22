package com.fushuang.assassinnews.http.api;

import com.fushuang.assassinnews.model.DailyBeforeListBean;
import com.fushuang.assassinnews.model.DailyListBean;
import com.fushuang.assassinnews.model.ZhihuDetailBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by fushuang on 2017/3/10.
 */

public interface ZhihuApis {

    String HOST = "http://news-at.zhihu.com/api/4/";

    /**
     * 最新日报
     */
    @GET("news/latest")
    Observable<DailyListBean> getDailyList();


    /**
     * 往期日报
     */
    @GET("news/before/{date}")
    Observable<DailyBeforeListBean> getDailyBeforeList(@Path("date") String date);

    /**
     * 日报详情
     */
    @GET("news/{id}")
    Observable<ZhihuDetailBean> getDetailInfo(@Path("id") int id);
}
