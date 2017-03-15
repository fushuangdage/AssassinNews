package com.fushuang.assassinnews.presenter;

import android.Manifest;


import com.fushuang.assassinnews.View.MainView;
import com.fushuang.assassinnews.http.RetrofitHelper;


import javax.inject.Inject;

/**
 * Created by codeest on 16/8/9.
 */

public class MainPresenter extends RxPresenter<MainView>{

    private RetrofitHelper mRetrofitHelper;

    @Inject
    public MainPresenter(RetrofitHelper mRetrofitHelper) {
        this.mRetrofitHelper = mRetrofitHelper;
    }


}
