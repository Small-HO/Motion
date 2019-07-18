package com.shaoyuan.core.Interfaces;

import android.content.Context;

/**
 * Created by small-ho on 2019/7/18 17:24
 * title：消耗摄入核心接口
 */
public interface IntakeInterface {
    interface view {
        Context getContext();

        void initView();
        void initData();
    }
    interface presenter {

    }
}
