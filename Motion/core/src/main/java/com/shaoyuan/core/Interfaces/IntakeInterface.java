package com.shaoyuan.core.Interfaces;

import android.content.Context;

import com.shaoyuan.model.dataModel.CountcontodayModel;

/**
 * Created by small-ho on 2019/7/18 17:24
 * title：消耗摄入核心接口
 */
public interface IntakeInterface {
    interface view {
        Context getContext();

        void initView();
        void initData();

        void initCountcontodyData(CountcontodayModel model);

        void toAnalysisPage();
        void toConsumePage();
        void toDietPage();

        void showLog(String log);
    }
    interface presenter {
        void initCountcontodyData();
    }
}
