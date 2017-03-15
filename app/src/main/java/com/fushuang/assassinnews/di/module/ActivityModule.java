package com.fushuang.assassinnews.di.module;

import android.app.Activity;

import com.fushuang.assassinnews.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by fushuang on 2017/3/14.
 */
@Module
public class ActivityModule {
    private Activity mActivity;
    public ActivityModule(Activity activity){
        mActivity=activity;
    }
    @Provides
    @ActivityScope
    public Activity provideActivity(){
        return mActivity;
    }

}
