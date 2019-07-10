package com.shaoyuan.motion.utils;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by small-ho on 2019/7/10 10:44
 * title：自定义轮播缩放特效
 */
public class MyScalePageTransformer implements ViewPager.PageTransformer {

    public static final float MAX_SCALE = 1.0f;
    public static final float MIN_SCALE = 0.5f;

    @Override
    public void transformPage(@NonNull View page, float position) {
        if (position < - 1) {
            position = -1;
        }else if (position > 1){
            position = 1;
        }

        float tempScale = position < 0 ? 1 + position : 1 - position;
        float slope = (MAX_SCALE - MIN_SCALE)/1;
        float scaleValue = MIN_SCALE + tempScale * slope;

        page.setScaleX(scaleValue);
        page.setScaleY(scaleValue);

        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT){
            page.getParent().requestLayout();
        }
    }
}
