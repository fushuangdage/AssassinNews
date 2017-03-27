package com.fushuang.assassinnews;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;


import com.fushuang.assassinnews.di.component.AppComponent;
import com.fushuang.assassinnews.di.component.DaggerAppComponent;
import com.fushuang.assassinnews.di.module.AppModule;
import com.fushuang.assassinnews.di.module.HttpModule;
import com.fushuang.assassinnews.di.module.PageModule;

/**
 * Created by fushuang on 2017/3/10.
 */

public class App extends Application {
    public static App instance;
    public static AppComponent appComponent;

    static {
        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_NO);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
    }

    public static synchronized App getInstance() {
        return instance;
    }

    public static AppComponent getAppComponent(){
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(instance))
                    .httpModule(new HttpModule())
                    .pageModule(new PageModule())
                    .build();
        }
        return appComponent;
    }

}
