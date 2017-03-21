package com.fushuang.assassinnews.presenter;

import com.fushuang.assassinnews.View.ZhihuDailyView;
import com.fushuang.assassinnews.http.RetrofitHelper;
import com.fushuang.assassinnews.model.DailyListBean;

import javax.inject.Inject;

import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by fushuang on 2017/3/20.
 */

public class ZhihuDailyPresenter extends RxPresenter<ZhihuDailyView> {

    private  RetrofitHelper mRetrofitHelper;

    @Inject

    public ZhihuDailyPresenter(RetrofitHelper retrofitHelper) {
        mRetrofitHelper = retrofitHelper;
        
    }
    
    public void getDailyData(){
        mRetrofitHelper.getDailyList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<DailyListBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(DailyListBean dailyListBean) {
                mView.showContent(dailyListBean);
            }
        });

    }
}
