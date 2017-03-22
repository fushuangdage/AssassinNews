package com.fushuang.assassinnews.di.component;

import android.app.Activity;

import com.fushuang.assassinnews.View.activity.MainActivity;
import com.fushuang.assassinnews.View.activity.ZhihuDetailActivity;
import com.fushuang.assassinnews.di.module.ActivityModule;
import com.fushuang.assassinnews.di.scope.ActivityScope;

import dagger.Component;

/**
 * Created by fushuang on 2017/3/14.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity getActivity();

    void inject(MainActivity mainActivity);

    void inject(ZhihuDetailActivity zhihuDetailActivity);
}
