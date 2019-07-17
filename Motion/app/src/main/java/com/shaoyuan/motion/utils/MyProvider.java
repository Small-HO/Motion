package com.shaoyuan.motion.utils;

import android.content.Context;

/**
 * Created by small-ho on 2019-01-04 13:45
 * title：用于解决provider冲突的util
 */
public class MyProvider {
    public static String getFileProviderName(Context context){
        return context.getPackageName()+".provider";
    }
}
