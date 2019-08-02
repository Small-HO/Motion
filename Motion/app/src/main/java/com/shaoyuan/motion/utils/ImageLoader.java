package com.shaoyuan.motion.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by small-ho on 2019/7/31 16:59
 * title：图片加载器
 */
public class ImageLoader {
    /** 圆角 */
    public static void displayImage(Context context, String url, ImageView imageView) {
        RequestOptions options = RequestOptions.bitmapTransform(new RoundedCorners(15));
        Glide.with(context)
                .load(url)
                .apply(options)
                .into(imageView);
    }
    /** 正常 */
    public static void image(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .into(imageView);
    }

}
