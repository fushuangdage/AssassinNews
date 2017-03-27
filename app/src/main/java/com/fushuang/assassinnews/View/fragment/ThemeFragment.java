package com.fushuang.assassinnews.View.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fushuang.assassinnews.R;
import com.fushuang.assassinnews.View.ThemeView;
import com.fushuang.assassinnews.View.activity.ZhihuThemeActivity;
import com.fushuang.assassinnews.adapter.ZhihuThemeAdapter;
import com.fushuang.assassinnews.adapter.ZhyBaseRecycleAdapter.MultiItemTypeAdapter;
import com.fushuang.assassinnews.model.ThemeListBean;
import com.fushuang.assassinnews.presenter.ThemePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThemeFragment extends BaseFragment<ThemePresenter> implements ThemeView, SwipeRefreshLayout.OnRefreshListener, MultiItemTypeAdapter.OnItemClickListener {


    @BindView(R.id.rv_theme_list)
    RecyclerView mRecyclerView;
    @BindView(R.id.swf_theme)
    SwipeRefreshLayout mSwipeRefreshLayout;
    List<ThemeListBean.OthersBean> mList=new ArrayList<>();
    private ZhihuThemeAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_theme;
    }

    @Override
    protected void initEventAndData() {
        mPresenter.getThemeData();
        mPresenter.attachView(this);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        mAdapter = new ZhihuThemeAdapter(getActivity(), R.layout.theme_item, mList);
        mAdapter.setOnItemClickListener(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void showContent(ThemeListBean themeListBean) {
        mSwipeRefreshLayout.setRefreshing(false);
        mList.clear();
        mList.addAll(themeListBean.getOthers());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRefresh() {
        mPresenter.getThemeData();
    }

    @Override
    public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
        int id = mList.get(position).getId();
        Intent intent = new Intent(getActivity(), ZhihuThemeActivity.class);
        intent.putExtra("id",id);
        startActivity(intent);
    }

    @Override
    public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
        return false;
    }

}
