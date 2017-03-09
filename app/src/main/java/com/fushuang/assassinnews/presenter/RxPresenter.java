package com.fushuang.assassinnews.presenter;

import com.fushuang.assassinnews.View.BaseView;
import com.fushuang.assassinnews.component.RxBus;

import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by fushuang on 2017/3/9.
 */

public abstract class RxPresenter<T extends BaseView> implements BasePresenter<T> {
    protected T mView;
    protected CompositeSubscription mCompositeSubscription;
    protected void  unSubscribe(){
        if (mCompositeSubscription!=null){
            mCompositeSubscription.unsubscribe();
        }
    }
    protected void addSubscribe(Subscription subscription){
        if (mCompositeSubscription!=null){
            mCompositeSubscription.add(subscription);
        }
    }

    protected <U> void addRxBusSubscribe(Class<U> eventType, Action1<U> act) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(RxBus.getDefault().toDefaultObservable(eventType, act));
    }

    @Override
    public void attachView(T view) {
        mView=view;
    }

    @Override
    public void detachView() {
        mView=null;
        unSubscribe();
    }
}
