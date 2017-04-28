package com.fushuang.assassinnews.View.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.fushuang.assassinnews.R;
import com.fushuang.assassinnews.View.MainView;
import com.fushuang.assassinnews.View.fragment.GeekFuliFragment;
import com.fushuang.assassinnews.View.fragment.WXFragment;
import com.fushuang.assassinnews.View.fragment.ZhihuMainFragment;
import com.fushuang.assassinnews.presenter.MainPresenter;

import javax.inject.Inject;

import butterknife.BindView;


public class MainActivity extends BaseActivity<MainPresenter> implements MainView, NavigationView.OnNavigationItemSelectedListener {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.navigationView)
    NavigationView mNavigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    @BindView(R.id.main_content)
    FrameLayout mContainer;

    @Inject
    ZhihuMainFragment mZhihuFragment;

    @Inject
    WXFragment mWXFragment;


    @Inject
    GeekFuliFragment mFuliFragment;

    private Fragment oldFragment;
    private Fragment newFragment;


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
        setToolBar(mToolbar, "知乎日报");
        mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,mToolbar, R.string.open,R.string.close);
        mDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mNavigationView.setNavigationItemSelectedListener(this);

        loadMultipleRootTransaction(getSupportFragmentManager(),R.id.main_content,0,mZhihuFragment,mWXFragment,mFuliFragment);
        oldFragment=mZhihuFragment;
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        mPresenter.showExitMsg("真的要退出了么?");
    }

    @Override
    public void showExitDialog(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        switch (item.getItemId()) {
            case R.id.drawer_zhihu:

                ft.hide(oldFragment).show(mZhihuFragment);
                ft.commit();
                oldFragment=mZhihuFragment;
                break;
            case R.id.drawer_weixin:
                ft.hide(oldFragment).show(mWXFragment);
                ft.commit();
                oldFragment=mWXFragment;
                break;
            case R.id.drawer_gank:
                ft.hide(oldFragment).show(mFuliFragment);
                ft.commit();
                oldFragment=mFuliFragment;
                break;
            case R.id.drawer_xitu:

                break;
            case R.id.drawer_v2ex:
                //大师即时通讯
                Intent intent = new Intent(this, IMActivity.class);
                startActivity(intent);
                break;
            case R.id.drawer_collection:

                break;
            case R.id.drawer_setting:

                break;
        }
        return true;
    }
}
