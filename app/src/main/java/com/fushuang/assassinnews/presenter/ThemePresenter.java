package com.fushuang.assassinnews.presenter;

import com.fushuang.assassinnews.View.ThemeView;
import com.fushuang.assassinnews.http.RetrofitHelper;
import com.fushuang.assassinnews.model.ThemeListBean;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by fushuang on 2017/3/27.
 */

public class ThemePresenter extends RxPresenter<ThemeView> {
    RetrofitHelper mRetrofitHelper;

    @Inject
    public ThemePresenter(RetrofitHelper retrofitHelper) {
        mRetrofitHelper = retrofitHelper;
    }

    public void getThemeData(){
        mRetrofitHelper.getThemeList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ThemeListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(ThemeListBean themeListBean) {
                        mView.showContent(themeListBean);
                    }
                });
    }
}
