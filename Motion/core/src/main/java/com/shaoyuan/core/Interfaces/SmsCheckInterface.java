package com.shaoyuan.core.Interfaces;

import android.content.Context;

/**
 * Created by small-ho on 2019/7/18 14:13
 * title：短信验证核心接口
 */
public interface SmsCheckInterface {
    interface view {
        Context getContext();

        void initView();
        void initData();
    }

    interface presenter {

    }
}
