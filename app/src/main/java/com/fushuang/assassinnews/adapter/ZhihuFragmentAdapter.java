package com.fushuang.assassinnews.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by fushuang on 2017/3/20.
 */

public class ZhihuFragmentAdapter extends FragmentPagerAdapter {

    private final String[] mTitle;
    private List<Fragment> mList;

    public ZhihuFragmentAdapter(FragmentManager fm,List<Fragment> list,String[] title) {
        super(fm);
        mList=list;
        mTitle = title;
    }


    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle[position];
    }

}
