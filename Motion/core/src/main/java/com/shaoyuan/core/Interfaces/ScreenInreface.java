package com.shaoyuan.core.Interfaces;

import android.content.Context;

import com.shaoyuan.model.dataModel.ScreenModel;

/**
 * Created by small-ho on 2019/7/29 9:31
 * title：健康体检核心
 */
public interface ScreenInreface {

    interface view {
        Context getContext();

        void initView();
        void initData();

        void initScreenDatas(ScreenModel model);

        void toScreenPage();

        void showLog(String log);
    }

    interface presenter {
        void initScreenDatas();
    }

}
