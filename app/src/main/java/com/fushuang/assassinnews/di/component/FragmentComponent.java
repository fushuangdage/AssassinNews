package com.fushuang.assassinnews.di.component;

import android.app.Activity;

import com.fushuang.assassinnews.View.fragment.ZhihuDailyFragment;
import com.fushuang.assassinnews.di.module.FragmentModule;
import com.fushuang.assassinnews.di.scope.FragmentScope;

import dagger.Component;

/**
 * Created by fushuang on 2017/3/14.
 */
@FragmentScope
@Component(dependencies = AppComponent.class,modules = FragmentModule.class)
public interface FragmentComponent {
    Activity getActivity();

    void inject(ZhihuDailyFragment dailyFragment);

}
