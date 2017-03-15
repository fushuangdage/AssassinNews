package com.fushuang.assassinnews.di.component;

import com.fushuang.assassinnews.App;
import com.fushuang.assassinnews.View.fragment.ZhihuMainFragment;
import com.fushuang.assassinnews.di.module.AppModule;
import com.fushuang.assassinnews.di.module.HttpModule;
import com.fushuang.assassinnews.di.module.PageModule;
import com.fushuang.assassinnews.http.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by fushuang on 2017/3/10.
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class, PageModule.class})
public interface AppComponent {
    App getContext();

    RetrofitHelper retrofitHelper();

    ZhihuMainFragment zhihuMainFragment();

}
