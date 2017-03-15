package com.fushuang.assassinnews.View.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fushuang.assassinnews.R;
import com.fushuang.assassinnews.View.activity.BaseActivity;
import com.fushuang.assassinnews.View.fragment.BaseFragment;

public class MainActivity extends BaseActivity {


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {

    }

    @Override
    public void showError(String msg) {

    }
}
