package com.shaoyuan.core.Interfaces;

import android.content.Context;

import com.shaoyuan.model.dataModel.DataReportModel;

/**
 * Created by small-ho on 2019/7/20 10:20
 * title：分析报告消耗fragment核心接口
 */
public interface ConsumeInterface {
    interface view {
        Context getContext();

        void initConsumeDatas(DataReportModel model);

        void showLog(String log);
    }

    interface presenter {
        void initConsumeDatas();
    }
}
