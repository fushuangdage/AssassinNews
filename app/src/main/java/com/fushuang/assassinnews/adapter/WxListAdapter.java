package com.fushuang.assassinnews.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.fushuang.assassinnews.R;
import com.fushuang.assassinnews.adapter.ZhyBaseRecycleAdapter.CommonAdapter;
import com.fushuang.assassinnews.adapter.ZhyBaseRecycleAdapter.base.ViewHolder;
import com.fushuang.assassinnews.component.ImageLoader;
import com.fushuang.assassinnews.model.WXItemBean;

import java.util.List;

/**
 * Created by fushuang on 2017/4/26.
 */

public class WxListAdapter extends CommonAdapter<WXItemBean> {

    private final Context mContext;

    public WxListAdapter(Context context, int layoutId, List<WXItemBean> datas) {
        super(context, layoutId, datas);
        mContext = context;
    }

    @Override
    protected void convert(ViewHolder holder, WXItemBean wxItemBean, int position) {
        ImageLoader.load(mContext,wxItemBean.getPicUrl(),(ImageView) holder.getView(R.id.iv_cover));
        ((TextView) holder.getView(R.id.tv_title)).setText(wxItemBean.getTitle());
        ((TextView) holder.getView(R.id.tv_date)).setText(wxItemBean.getCtime());
    }
}
