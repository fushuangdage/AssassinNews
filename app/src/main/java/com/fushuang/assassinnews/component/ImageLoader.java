package com.fushuang.assassinnews.component;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by fushuang on 2017/3/9.
 */

public class ImageLoader {
    public static void load(Context context, String url, ImageView iv){
        Glide.with(context).load(url).crossFade().diskCacheStrategy(DiskCacheStrategy.RESULT).into(iv);
    }
    public static void load(Activity activity, String url, ImageView iv){
        Glide.with(activity).load(url).crossFade().diskCacheStrategy(DiskCacheStrategy.RESULT).into(iv);
    }
}
