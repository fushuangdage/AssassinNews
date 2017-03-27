package com.fushuang.assassinnews.View.activity;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.fushuang.assassinnews.R;
import com.fushuang.assassinnews.View.ThemeChildView;
import com.fushuang.assassinnews.adapter.DailyListAdapter;
import com.fushuang.assassinnews.component.ImageLoader;
import com.fushuang.assassinnews.model.StoriesBean;
import com.fushuang.assassinnews.model.ThemeChildListBean;
import com.fushuang.assassinnews.presenter.ThemeChildPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ZhihuThemeActivity extends BaseActivity<ThemeChildPresenter> implements ThemeChildView {


    @BindView(R.id.recycle_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.toolbar_cover)
    ImageView mImageView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tv_toolbar_desc)
    TextView tv_desc;
    @BindView(R.id.cls_toolBar)
    CollapsingToolbarLayout mToolbarLayout;
    private List<StoriesBean> mStories=new ArrayList<>();
    private DailyListAdapter mAdapter;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_zhihu_theme;
    }

    @Override
    protected void init() {
        setToolBar(mToolbar,"题目题目");
        mPresenter.attachView(this);
        int id = getIntent().getIntExtra("id", 0);
        mPresenter.getThemeChildData(id);
        mAdapter = new DailyListAdapter(this, R.layout.item_daily_zhihu, mStories);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void showContent(ThemeChildListBean themeChildListBean) {
        ImageLoader.load(this,themeChildListBean.getBackground(),mImageView);
        mToolbarLayout.setTitle(themeChildListBean.getName());
        tv_desc.setText(themeChildListBean.getDescription());
        mStories.clear();
        mStories.addAll(themeChildListBean.getStories());
        mAdapter.notifyDataSetChanged();
    }

}
