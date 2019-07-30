package com.shaoyuan.api;

import android.util.Log;

/**
 * Created by gzl on 2019/7/29 11:31
 * title：
 */
public class L {

    public static boolean isPrint = true;

    public static void d(String msg) {
        if (isPrint) {

            //Logger.d(msg);
        }
    }

    public static void e(String msg) {
        if (isPrint){
            //Logger.e(msg);
        }

    }


    public static void ii(String msg) {
        if (isPrint)
            Log.d("tag", msg);
    }

    public static void dd(String msg) {
        if (isPrint)
            Log.d("tag", msg);
    }

    public static void ee(String msg) {
        if (isPrint)
            Log.d("tag", msg);
    }
}
