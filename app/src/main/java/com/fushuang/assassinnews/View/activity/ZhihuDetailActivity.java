package com.fushuang.assassinnews.View.activity;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.fushuang.assassinnews.R;
import com.fushuang.assassinnews.View.ZhihuDetailView;
import com.fushuang.assassinnews.component.ImageLoader;
import com.fushuang.assassinnews.model.ZhihuDetailBean;
import com.fushuang.assassinnews.presenter.ZhihuDetailPresenter;
import com.fushuang.assassinnews.utils.HtmlUtil;

import butterknife.BindView;

public class ZhihuDetailActivity extends BaseActivity<ZhihuDetailPresenter> implements ZhihuDetailView{

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.wv_daily)
    WebView mWebView;
    @BindView(R.id.clp_toolbar)
    CollapsingToolbarLayout clp_toolBar;
    @BindView(R.id.iv_cover)
    ImageView cover;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_zhihu_detail;
    }

    @Override
    protected void init() {
        int id = getIntent().getIntExtra("id", 0);
        mPresenter.getDetail(id);
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void showContent(ZhihuDetailBean zhihuDetailBean) {

        String htmlData = HtmlUtil.createHtmlData(zhihuDetailBean.getBody(),zhihuDetailBean.getCss(),zhihuDetailBean.getJs());
        mWebView.loadData(htmlData, HtmlUtil.MIME_TYPE, HtmlUtil.ENCODING);
        clp_toolBar.setTitle(zhihuDetailBean.getTitle());
        ImageLoader.load(this,zhihuDetailBean.getImage(),cover);
    }

}
