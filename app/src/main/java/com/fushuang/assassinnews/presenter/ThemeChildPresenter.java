package com.fushuang.assassinnews.presenter;

import com.fushuang.assassinnews.View.ThemeChildView;
import com.fushuang.assassinnews.http.RetrofitHelper;
import com.fushuang.assassinnews.model.ThemeChildListBean;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by fushuang on 2017/3/27.
 */

public class ThemeChildPresenter extends RxPresenter<ThemeChildView> {
    RetrofitHelper mRetrofitHelper;

    @Inject
    public ThemeChildPresenter(RetrofitHelper retrofitHelper) {
        mRetrofitHelper = retrofitHelper;
    }

    public void getThemeChildData(int id){
        mRetrofitHelper.getThemeChildList(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ThemeChildListBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ThemeChildListBean themeChildListBean) {
                mView.showContent(themeChildListBean);
            }
        });
    }
}
