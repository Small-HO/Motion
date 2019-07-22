package com.shaoyuan.core.Interfaces;

import android.content.Context;

/**
 * Created by small-ho on 2019/7/22 16:02
 * title：消耗Activity页面核心接口
 */
public interface ExpendInterface {
    interface view {
        Context getContext();

        void toWorkPage();
    }

    interface presenter {

    }
}
