package com.fushuang.assassinnews.http;

import com.fushuang.assassinnews.http.api.ZhihuApis;
import com.fushuang.assassinnews.model.DailyBeforeListBean;
import com.fushuang.assassinnews.model.DailyListBean;

import rx.Observable;

/**
 * Created by fushuang on 2017/3/10.
 */

public class RetrofitHelper {

    public ZhihuApis mZhihuApiService;

    public RetrofitHelper(ZhihuApis zhihuApis) {
        mZhihuApiService = zhihuApis;
    }

    public Observable<DailyListBean> getDailyList(){
        return mZhihuApiService.getDailyList();
    }

    public Observable<DailyBeforeListBean> getDailyBeforeList(String data){
       return mZhihuApiService.getDailyBeforeList(data);
    }
}
