package com.fushuang.assassinnews.View.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fushuang.assassinnews.R;
import com.fushuang.assassinnews.View.ZhihuDailyView;
import com.fushuang.assassinnews.View.activity.ZhihuDetailActivity;
import com.fushuang.assassinnews.adapter.DailyListAdapter;
import com.fushuang.assassinnews.adapter.DailyPagerAdapter;
import com.fushuang.assassinnews.adapter.ZhyBaseRecycleAdapter.MultiItemTypeAdapter;
import com.fushuang.assassinnews.adapter.ZhyBaseRecycleAdapter.wrapper.HeaderAndFooterWrapper;
import com.fushuang.assassinnews.http.RetrofitHelper;
import com.fushuang.assassinnews.model.DailyListBean;
import com.fushuang.assassinnews.presenter.RxPresenter;
import com.fushuang.assassinnews.presenter.ZhihuDailyPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhihuDailyFragment extends BaseFragment<ZhihuDailyPresenter> implements ZhihuDailyView, SwipeRefreshLayout.OnRefreshListener, MultiItemTypeAdapter.OnItemClickListener {


    @BindView(R.id.fbt_daily)
    FloatingActionButton mFBtn;
    @BindView(R.id.rv_daily_list)
    RecyclerView mRecyclerView;
    @BindView(R.id.sr_zhihu_daily)
    SwipeRefreshLayout mRefreshLayout;

    List<DailyListBean.StoriesBean> mList=new ArrayList<>();

    List<DailyListBean.TopStoriesBean> mPagerList=new ArrayList<>();

    private DailyListAdapter mAdapter;
    private HeaderAndFooterWrapper<DailyListBean.StoriesBean> mWrapper;
    private DailyPagerAdapter mPagerAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zhihu_daily;
    }

    @Override
    protected void initEventAndData() {
        mRefreshLayout.setOnRefreshListener(this);
        mPresenter.attachView(this);
        mPresenter.getDailyData();
        mAdapter = new DailyListAdapter(mContext, R.layout.item_daily_zhihu, mList);
        mAdapter.setOnItemClickListener(this);
        mWrapper = new HeaderAndFooterWrapper<DailyListBean.StoriesBean>(mAdapter);
        View top = LayoutInflater.from(mContext).inflate(R.layout.daily_top_view, null, false);
        ViewPager viewPager = (ViewPager) top.findViewById(R.id.daily_top_vp);
        mPagerAdapter = new DailyPagerAdapter(mPagerList, mContext);
        viewPager.setAdapter(mPagerAdapter);
        mWrapper.addHeaderView(top);
        mRecyclerView.setAdapter(mWrapper);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void showContent(DailyListBean dailyListBean) {
        mRefreshLayout.setRefreshing(false);
        mList.clear();
        mList.addAll(dailyListBean.getStories());
        mAdapter.notifyDataSetChanged();

        mPagerList.clear();
        mPagerList.addAll(dailyListBean.getTop_stories());
        mPagerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRefresh() {
        mPresenter.getDailyData();
    }

    @Override
    public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
        Intent intent = new Intent(mContext, ZhihuDetailActivity.class);
        int id = mList.get(position).getId();
        intent.putExtra("id",id);
        startActivity(intent);
    }

    @Override
    public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
        return false;
    }
}
