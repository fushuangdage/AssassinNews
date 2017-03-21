package com.fushuang.assassinnews.View.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fushuang.assassinnews.App;
import com.fushuang.assassinnews.View.BaseView;
import com.fushuang.assassinnews.di.component.DaggerFragmentComponent;
import com.fushuang.assassinnews.di.component.FragmentComponent;
import com.fushuang.assassinnews.di.module.FragmentModule;
import com.fushuang.assassinnews.presenter.BasePresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Mvp Fragment 基类
 * Created by fushuang on 2017/3/14.
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements BaseView{

    @Inject
    protected T mPresenter;
    protected Context mContext;
    private View mView;
    private Unbinder mUnbinder;

    @Override
    public void onAttach(Context context) {
        mContext=context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(getLayoutId(), null);
        mUnbinder = ButterKnife.bind(this, mView);
        initInject();
        initEventAndData();
        return mView;
    }

    protected FragmentComponent getFragmentComponent(){
        return DaggerFragmentComponent.builder()
                .appComponent(App.getAppComponent())
                .fragmentModule(getFragmentModule())
                .build();
    }

    protected FragmentModule getFragmentModule(){
        return new FragmentModule(this);
    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    protected abstract int getLayoutId();
    protected abstract void initEventAndData();
    protected abstract void initInject();


}
