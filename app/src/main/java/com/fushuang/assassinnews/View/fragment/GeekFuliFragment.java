package com.fushuang.assassinnews.View.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.fushuang.assassinnews.R;
import com.fushuang.assassinnews.View.GeekFuliView;
import com.fushuang.assassinnews.adapter.GeekFuliAdapter;
import com.fushuang.assassinnews.model.GankItemBean;
import com.fushuang.assassinnews.model.GeekFuliBean;
import com.fushuang.assassinnews.presenter.GeekFuliPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class GeekFuliFragment extends BaseFragment<GeekFuliPresenter> implements GeekFuliView {


    @BindView(R.id.rv_geek)
    RecyclerView mRecyclerView;

    List<GankItemBean> mList=new ArrayList();
    private GeekFuliAdapter mAdapter;
    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_geek_fuli;
    }

    @Override
    protected void initEventAndData() {
        mPresenter.attachView(this);
        mAdapter = new GeekFuliAdapter(mContext, R.layout.item_girl, mList);
        mPresenter.getGirlsData();
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mStaggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        //fix issue #52 https://github.com/codeestX/GeekNews/issues/52
        mStaggeredGridLayoutManager.setItemPrefetchEnabled(false);
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);
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
    public void showContent(GeekFuliBean list) {
        mList.clear();
        mList.addAll(list.getResults());
        mAdapter.notifyDataSetChanged();
    }



}
