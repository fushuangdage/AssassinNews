package com.fushuang.assassinnews.di.module;

import com.fushuang.assassinnews.View.fragment.GeekFuliFragment;
import com.fushuang.assassinnews.View.fragment.WXFragment;
import com.fushuang.assassinnews.View.fragment.ZhihuMainFragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by fushuang on 2017/3/10.
 */
@Module
public class PageModule {
    @Singleton
    @Provides
    ZhihuMainFragment provideZhihuMain() {
        return new ZhihuMainFragment();
    }

    @Singleton
    @Provides
    WXFragment provideWX(){return new WXFragment();}


    @Singleton
    @Provides
    GeekFuliFragment provideFuli(){
        return new GeekFuliFragment();
    }

}
