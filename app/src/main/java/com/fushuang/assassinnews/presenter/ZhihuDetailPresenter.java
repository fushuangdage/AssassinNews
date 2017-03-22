package com.fushuang.assassinnews.presenter;

import com.fushuang.assassinnews.View.ZhihuDetailView;
import com.fushuang.assassinnews.http.RetrofitHelper;
import com.fushuang.assassinnews.model.ZhihuDetailBean;

import javax.inject.Inject;

import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by fushuang on 2017/3/22.
 */

public class ZhihuDetailPresenter extends RxPresenter<ZhihuDetailView>{

    private  RetrofitHelper mRetrofitHelper;

    @Inject
    public ZhihuDetailPresenter(RetrofitHelper retrofitHelper) {
        mRetrofitHelper = retrofitHelper;
    }

    public void getDetail(int id){
        mRetrofitHelper.getDailyDetail(id)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ZhihuDetailBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ZhihuDetailBean zhihuDetailBean) {
                        mView.showContent(zhihuDetailBean);
                    }
                });
    }




}
