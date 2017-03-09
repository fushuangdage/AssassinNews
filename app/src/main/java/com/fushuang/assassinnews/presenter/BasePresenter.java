package com.fushuang.assassinnews.presenter;

import com.fushuang.assassinnews.View.BaseView;

/**
 * Created by fushuang on 2017/3/9.
 */

public interface BasePresenter <T extends BaseView> {

    void attachView(T view);
    void detachView();
}
