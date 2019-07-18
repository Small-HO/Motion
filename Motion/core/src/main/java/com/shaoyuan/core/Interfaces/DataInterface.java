package com.shaoyuan.core.Interfaces;

import android.content.Context;

/**
 * Created by small-ho on 2019/7/18 17:17
 * title：数据页面Fragment接口
 */
public interface DataInterface {
    interface view {
        Context getContext();

        void toIntakePage();
    }
}
