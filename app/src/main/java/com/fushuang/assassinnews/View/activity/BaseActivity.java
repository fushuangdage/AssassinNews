package com.fushuang.assassinnews.View.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.fushuang.assassinnews.App;
import com.fushuang.assassinnews.Constants;
import com.fushuang.assassinnews.View.BaseView;
import com.fushuang.assassinnews.di.component.ActivityComponent;
import com.fushuang.assassinnews.di.component.DaggerActivityComponent;
import com.fushuang.assassinnews.di.module.ActivityModule;
import com.fushuang.assassinnews.presenter.BasePresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by fushuang on 2017/3/9.
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView {

    @Inject
    protected T mPresenter;
    protected Context mContext;
    protected Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        mUnbinder=ButterKnife.bind(this);
        mContext=this;
        initInject();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        init();
    }


    protected void setToolBar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
            }
        });
    }

    protected ActivityComponent getActivityComponent(){
        return  DaggerActivityComponent.builder()
                .appComponent(App.getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }

    protected abstract void initInject();
    protected abstract int getLayout();
    protected abstract void init();

    public ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    /**
     * 加载多个根Fragment
     */
    void loadMultipleRootTransaction(FragmentManager fragmentManager, int containerId, int showPosition, Fragment... tos) {
        FragmentTransaction ft = fragmentManager.beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        for (int i = 0; i < tos.length; i++) {
            Fragment to = tos[i];
            String toName = to.getClass().getName();
            ft.add(containerId, to, toName);
            if (i != showPosition) {
                ft.hide(to);
            }
        }
        ft.commit();
    }


}
