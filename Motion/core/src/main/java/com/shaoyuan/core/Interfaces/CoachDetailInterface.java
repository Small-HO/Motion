package com.shaoyuan.core.Interfaces;

import android.content.Context;

import com.shaoyuan.model.dierbanBean.CoachDetailBean;

/**
 * Created by gzl on 2019/8/6 10:16
 * title：
 */
public interface CoachDetailInterface {
    interface view {
        Context getContext();
        void initView();

        void initData();
        void initCoachDetail(CoachDetailBean model);

        String getAreaid();

        void showLog(String log);
    }

    interface presenter {
        void initCoachDetail();
    }
}
