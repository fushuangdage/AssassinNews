package com.fushuang.assassinnews.View.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fushuang.assassinnews.R;
import com.fushuang.assassinnews.adapter.GeekPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class GeekMainFragment extends Fragment {


    @BindView(R.id.tb_geek)
    TabLayout mTabLayout;
    @BindView(R.id.vp_geek)
    ViewPager mViewPager;

    List<Fragment> mFragments=new ArrayList<>();
    String[] titles={"ANDROID","福利","IOS","前端"};
    private GeekPagerAdapter mGeekPagerAdapter;


    public GeekMainFragment() {


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_geek_main, container, false);
        ButterKnife.bind(this,view);

        mFragments.add(new GeekFuliFragment());
        mFragments.add(new GeekFuliFragment());
        mFragments.add(new GeekFuliFragment());
        mFragments.add(new GeekFuliFragment());

        mGeekPagerAdapter = new GeekPagerAdapter(getFragmentManager(), mFragments, titles);

        mViewPager.setAdapter(mGeekPagerAdapter);
        return view;
    }

}
