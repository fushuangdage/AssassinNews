package com.fushuang.assassinnews.presenter;

import com.fushuang.assassinnews.View.WxView;
import com.fushuang.assassinnews.http.RetrofitHelper;
import com.fushuang.assassinnews.model.WXItemBean;
import com.fushuang.assassinnews.model.WxHotBean;
import com.fushuang.assassinnews.utils.RxUtil;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by fushuang on 2017/4/21.
 */

public class WxPresenter extends RxPresenter<WxView> {
    private int currentPage=0;
    private RetrofitHelper mRetrofitHelper;

    @Inject
    public WxPresenter(RetrofitHelper retrofitHelper) {
        mRetrofitHelper = retrofitHelper;
    }

    public void getWxHotList(){
        currentPage=0;
        mRetrofitHelper.getWxList(20,currentPage).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<WxHotBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(WxHotBean wxHotBean) {
                        mView.showWxHotList(wxHotBean);
                    }
                });

    }
}
