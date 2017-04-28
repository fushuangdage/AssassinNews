package com.fushuang.assassinnews.View.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fushuang.assassinnews.R;
import com.fushuang.assassinnews.View.WxView;
import com.fushuang.assassinnews.adapter.WxListAdapter;
import com.fushuang.assassinnews.adapter.ZhyBaseRecycleAdapter.MultiItemTypeAdapter;
import com.fushuang.assassinnews.model.WXItemBean;
import com.fushuang.assassinnews.model.WxHotBean;
import com.fushuang.assassinnews.presenter.WxPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class WXFragment extends BaseFragment<WxPresenter> implements WxView, MultiItemTypeAdapter.OnItemClickListener {

    @BindView(R.id.recycle_view)
    RecyclerView mRecyclerView;

    private List<WXItemBean> mNewslist=new ArrayList<>();
    private WxListAdapter mWxListAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wx;
    }

    @Override
    protected void initEventAndData() {
        mPresenter.attachView(this);
        mPresenter.getWxHotList();
        mWxListAdapter = new WxListAdapter(getContext(), R.layout.item_wx_chat, mNewslist);
        mRecyclerView.setFocusable(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mWxListAdapter);
        mWxListAdapter.setOnItemClickListener(this);
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public void showError(String msg) {

    }


    @Override
    public void showWxHotList(WxHotBean wxItemBeen) {
        mNewslist.clear();
        mNewslist.addAll(wxItemBeen.getNewslist());
        mWxListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
        Toast.makeText(mContext,position+"",Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
        return false;
    }
}
