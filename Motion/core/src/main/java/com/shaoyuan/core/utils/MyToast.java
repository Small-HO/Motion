package com.shaoyuan.core.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by small-ho on 2019-01-04 13:28
 * title：自定义Toast
 */
public class MyToast {
    private static Toast toast;

    public static void showToast(Context context, String content){
        if (toast == null){
            toast = Toast.makeText(context,content, Toast.LENGTH_SHORT);
        }else {
            toast.setText(content);
        }
        toast.show();
    }

}
