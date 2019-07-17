package com.shaoyuan.core.Interfaces;

import android.content.Context;

/**
 * Created by small-ho on 2019/7/17 13:55
 * title：头像核心接口类
 */
public interface HeaderInterface {
    interface view {
        Context getContext();

        void initView();
        void initData();
    }

    interface presenter {

    }
}
