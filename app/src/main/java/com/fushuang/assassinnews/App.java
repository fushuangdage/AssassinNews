package com.fushuang.assassinnews;

import android.app.Application;

import com.fushuang.assassinnews.di.component.AppComponent;
import com.fushuang.assassinnews.di.module.AppModule;
import com.fushuang.assassinnews.di.module.HttpModule;
import com.fushuang.assassinnews.di.module.PageModule;

/**
 * Created by fushuang on 2017/3/10.
 */

public class App extends Application {
    public static App instance;
    public static AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
    }

    public static App getInstance() {
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
