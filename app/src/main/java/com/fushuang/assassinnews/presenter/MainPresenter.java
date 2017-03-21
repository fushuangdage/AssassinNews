package com.fushuang.assassinnews.presenter;



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

    public void showExitMsg(String msg){
       mView.showExitDialog(msg);  //强行使用一波的我主持人,哈哈
    }

}
