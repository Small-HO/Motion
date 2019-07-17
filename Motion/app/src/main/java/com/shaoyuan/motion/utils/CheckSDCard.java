package com.shaoyuan.motion.utils;

import android.os.Environment;

/**
 * Created by small-ho on 2019-01-08 13:09
 * title：检查设备是否存在sdcard
 */
public class CheckSDCard {

    public static boolean hasSdcard(){
        String state = Environment.getExternalStorageState();
        return state.equals(Environment.MEDIA_MOUNTED);
    }
}
