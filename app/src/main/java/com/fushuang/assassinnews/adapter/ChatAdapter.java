package com.fushuang.assassinnews.adapter;

import android.content.Context;
import android.widget.TextView;

import com.fushuang.assassinnews.R;
import com.fushuang.assassinnews.adapter.ZhyBaseRecycleAdapter.MultiItemTypeAdapter;
import com.fushuang.assassinnews.adapter.ZhyBaseRecycleAdapter.base.ItemViewDelegate;
import com.fushuang.assassinnews.adapter.ZhyBaseRecycleAdapter.base.ViewHolder;
import com.fushuang.assassinnews.model.ImMsg;

import java.util.List;

/**
 * Created by fushuang on 2017/3/29.
 */

public class ChatAdapter extends MultiItemTypeAdapter<ImMsg> {

    public ChatAdapter(Context context, List<ImMsg> datas) {
        super(context, datas);
    }

    public static class MsgComeItemDelagate implements ItemViewDelegate<ImMsg>{

        @Override
        public int getItemViewLayoutId() {
            return R.layout.item_chat;
        }

        @Override
        public boolean isForViewType(ImMsg item, int position) {
            String from = item.getFrom();
            return from==null;
        }

        @Override
        public void convert(ViewHolder holder, ImMsg message, int position) {
            ((TextView) holder.getView(R.id.content)).setText(message.getContent());
        }
    }

    public static class MsgInItemDelagate implements ItemViewDelegate<ImMsg>{

        @Override
        public int getItemViewLayoutId() {
            return R.layout.item_chat2;
        }

        @Override
        public boolean isForViewType(ImMsg item, int position) {
            String from = item.getFrom();
            return from!=null;
        }

        @Override
        public void convert(ViewHolder holder, ImMsg message, int position) {
            ((TextView) holder.getView(R.id.content)).setText(message.getContent());
        }
    }

}
