package com.fushuang.assassinnews.di.module;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.fushuang.assassinnews.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by fushuang on 2017/3/14.
 */
@Module
public class FragmentModule {
    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    public Activity provideActivity() {
        return fragment.getActivity();
    }
}
