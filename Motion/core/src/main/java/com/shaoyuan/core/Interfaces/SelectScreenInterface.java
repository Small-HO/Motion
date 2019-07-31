package com.shaoyuan.core.Interfaces;

import android.content.Context;

import com.shaoyuan.model.dataModel.IllnessModel;

/**
 * Created by small-ho on 2019/7/29 15:47
 * title：选择体检项目核心接口
 */
public interface SelectScreenInterface {
    interface view {
        Context getContext();

        void initView();
        void initData();

        void initCrowdData(IllnessModel model);
        void initIllnessData(IllnessModel model);

        void showLog(String log);
    }

    interface presenter {
        void initCrowdData();
        void initIllnessData();
    }
}
