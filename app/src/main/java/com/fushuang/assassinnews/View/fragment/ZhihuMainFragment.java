package com.fushuang.assassinnews.View.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fushuang.assassinnews.R;
import com.fushuang.assassinnews.adapter.ZhihuFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhihuMainFragment extends BaseFragment {


    @BindView(R.id.tl_zhihu_fragment)
    TabLayout mTabLayout;
    @BindView(R.id.vp_zhihu_fragment)
    ViewPager mViewPager;

    String[] titles = {"日报", "主题", "专栏", "热门"};
    List<Fragment> mList=new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zhihu_main;
    }

    @Override
    protected void initEventAndData() {
        mList.clear();
        mList.add(new ZhihuDailyFragment());
        mList.add(new ThemeFragment());
        mList.add(new ZhihuDailyFragment());
        mList.add(new ThemeFragment());

        ZhihuFragmentAdapter adapter = new ZhihuFragmentAdapter(getActivity().getSupportFragmentManager(), mList,titles);

        mViewPager.setAdapter(adapter);

        mTabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    protected void initInject() {

    }

    @Override
    public void showError(String msg) {

    }
}
