package com.fushuang.assassinnews.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.fushuang.assassinnews.R;
import com.fushuang.assassinnews.adapter.ZhyBaseRecycleAdapter.CommonAdapter;
import com.fushuang.assassinnews.adapter.ZhyBaseRecycleAdapter.base.ViewHolder;
import com.fushuang.assassinnews.component.ImageLoader;
import com.fushuang.assassinnews.model.GankItemBean;

import java.util.List;

/**
 * Created by fushuang on 2017/4/28.
 */

public class GeekFuliAdapter extends CommonAdapter<GankItemBean> {

    private final List<GankItemBean> mList;

    public GeekFuliAdapter(Context context, int layoutId, List<GankItemBean> datas) {
        super(context, layoutId, datas);
        mList = datas;
    }

    @Override
    protected void convert(ViewHolder holder, GankItemBean gankItemBean, int position) {
        ImageLoader.load(mContext,gankItemBean.getUrl(),(ImageView) holder.getView(R.id.iv_cover));
    }

}
