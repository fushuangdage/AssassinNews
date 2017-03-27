package com.fushuang.assassinnews.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fushuang.assassinnews.R;
import com.fushuang.assassinnews.adapter.ZhyBaseRecycleAdapter.CommonAdapter;
import com.fushuang.assassinnews.adapter.ZhyBaseRecycleAdapter.base.ViewHolder;
import com.fushuang.assassinnews.component.ImageLoader;
import com.fushuang.assassinnews.model.ThemeListBean;

import java.util.List;

/**
 * Created by fushuang on 2017/3/27.
 */

public class ZhihuThemeAdapter extends CommonAdapter<ThemeListBean.OthersBean>{

    private final Context mContext;
    private final List<ThemeListBean.OthersBean> mDatas;

    public ZhihuThemeAdapter(Context context, int layoutId, List<ThemeListBean.OthersBean> datas) {
        super(context, layoutId, datas);
        mContext = context;
        mDatas = datas;
    }

    @Override
    protected void convert(ViewHolder holder, ThemeListBean.OthersBean themeListBean, int position) {
        ImageView image = holder.getView(R.id.iv_theme_item);
        TextView text = holder.getView(R.id.tv_theme_item);
        ImageLoader.load(mContext,themeListBean.getThumbnail(),image);
        text.setText(themeListBean.getName());
    }

}
