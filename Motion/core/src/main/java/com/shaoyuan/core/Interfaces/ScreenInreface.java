package com.shaoyuan.core.Interfaces;

import android.content.Context;

import com.shaoyuan.model.personalBean.PhysicalListBean;

/**
 * Created by small-ho on 2019/7/29 9:31
 * title：健康体检核心
 */
public interface ScreenInreface {

    interface view {
        Context getContext();

        void initView();
        void initData();

        void initScreenDatas(PhysicalListBean model);

        void toScreenPage();
        void toPlasticPage();           //  体检详情

        void showLog(String log);
    }

    interface presenter {
        void initScreenDatas();
    }

}
