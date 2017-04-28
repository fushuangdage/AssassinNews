package com.fushuang.assassinnews.presenter;

import com.fushuang.assassinnews.View.GeekFuliView;
import com.fushuang.assassinnews.http.RetrofitHelper;
import com.fushuang.assassinnews.model.GankItemBean;
import com.fushuang.assassinnews.model.GeekFuliBean;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by fushuang on 2017/3/30.
 */

public class GeekFuliPresenter extends RxPresenter<GeekFuliView> {

    RetrofitHelper mRetrofitHelper;

    public int currentPage = 0;

    @Inject
    public GeekFuliPresenter(RetrofitHelper retrofitHelper) {
        mRetrofitHelper = retrofitHelper;
    }

    public void getGirlsData() {
        Observable<GeekFuliBean> observable = mRetrofitHelper.getGankGirl(20, currentPage);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GeekFuliBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(GeekFuliBean geekFuliBean) {
                        mView.showContent(geekFuliBean);
                    }
                });
    }


}
