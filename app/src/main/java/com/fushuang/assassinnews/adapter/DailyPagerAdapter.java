package com.fushuang.assassinnews.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fushuang.assassinnews.R;
import com.fushuang.assassinnews.component.ImageLoader;
import com.fushuang.assassinnews.model.DailyListBean;

import java.util.List;

/**
 * Created by fushuang on 2017/3/21.
 */

public class DailyPagerAdapter extends PagerAdapter {

    private List<DailyListBean.TopStoriesBean> mList;
    private Context mContext;

    public DailyPagerAdapter(List<DailyListBean.TopStoriesBean> list, Context context) {
        mList = list;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.daily_top_pager_item, container, false);
        DailyListBean.TopStoriesBean bean = mList.get(position);
        ImageView imageView = (ImageView) view.findViewById(R.id.pager_item_iv);
        TextView textView = (TextView) view.findViewById(R.id.pager_item_tv);
        ImageLoader.load(mContext,bean.getImage(),imageView);
        textView.setText(bean.getTitle());
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       container.removeView(((View) object));
    }
}
