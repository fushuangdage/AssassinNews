package com.fushuang.assassinnews.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.List;


/**
 * Created by fushuang on 2017/3/30.
 */

public class GeekPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> mList;
    private final String[] mTitle;

    public GeekPagerAdapter(FragmentManager fm, List<Fragment> list,String[] title) {
        super(fm);
        mList = list;
        mTitle=title;
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
        return super.getPageTitle(position);
    }


}
