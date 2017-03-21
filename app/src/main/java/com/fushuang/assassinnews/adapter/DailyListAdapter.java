package com.fushuang.assassinnews.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fushuang.assassinnews.R;
import com.fushuang.assassinnews.adapter.ZhyBaseRecycleAdapter.CommonAdapter;
import com.fushuang.assassinnews.adapter.ZhyBaseRecycleAdapter.base.ViewHolder;
import com.fushuang.assassinnews.component.ImageLoader;
import com.fushuang.assassinnews.model.DailyListBean;

import java.util.List;

/**
 * Created by fushuang on 2017/3/20.
 */

public class DailyListAdapter extends CommonAdapter<DailyListBean.StoriesBean> {


    public DailyListAdapter(Context context, int layoutId, List<DailyListBean.StoriesBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder holder, DailyListBean.StoriesBean storiesBean, int position) {
        ImageView icon = holder.getView(R.id.iv_daily);
        TextView view = holder.getView(R.id.tv_content);
        ImageLoader.load(mContext,storiesBean.getImages().get(0),icon);
        view.setText(storiesBean.getTitle());
    }
}
