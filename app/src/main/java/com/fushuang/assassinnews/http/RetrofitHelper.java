package com.fushuang.assassinnews.http;

import com.fushuang.assassinnews.Constants;
import com.fushuang.assassinnews.http.api.GeekApis;
import com.fushuang.assassinnews.http.api.WxApis;
import com.fushuang.assassinnews.http.api.ZhihuApis;
import com.fushuang.assassinnews.model.DailyBeforeListBean;
import com.fushuang.assassinnews.model.DailyListBean;
import com.fushuang.assassinnews.model.GankItemBean;
import com.fushuang.assassinnews.model.GeekFuliBean;
import com.fushuang.assassinnews.model.ThemeChildListBean;
import com.fushuang.assassinnews.model.ThemeListBean;
import com.fushuang.assassinnews.model.WXItemBean;
import com.fushuang.assassinnews.model.WxHotBean;
import com.fushuang.assassinnews.model.ZhihuDetailBean;
import com.fushuang.assassinnews.presenter.WXHttpResponse;

import java.util.List;

import rx.Observable;

/**
 * Created by fushuang on 2017/3/10.
 */

public class RetrofitHelper {

    public ZhihuApis mZhihuApiService;
    public GeekApis mGeekService;
    public WxApis mWxService;


    public RetrofitHelper(ZhihuApis zhihuApis,GeekApis geekApis,WxApis wxApis) {
        mZhihuApiService = zhihuApis;
        mGeekService=geekApis;
        mWxService=wxApis;
    }



    public Observable<DailyListBean> getDailyList(){
        return mZhihuApiService.getDailyList();
    }

    public Observable<DailyBeforeListBean> getDailyBeforeList(String data){
       return mZhihuApiService.getDailyBeforeList(data);
    }

    public Observable<ZhihuDetailBean> getDailyDetail(int id){
       return mZhihuApiService.getDetailInfo(id);
    }

    public Observable<ThemeListBean> getThemeList(){
        return mZhihuApiService.getThemeList();
    }


    public Observable<ThemeChildListBean> getThemeChildList(int id){
        return mZhihuApiService.getThemeChildList(id);
    }

    public Observable<GeekFuliBean> getGankGirl(int num, int pager){
        return mGeekService.getGirlList(num,pager);
    }

    public Observable<WxHotBean> getWxList(int num, int pager){
        return mWxService.getWXHot(Constants.WXKEY,num,pager);
    }
}
