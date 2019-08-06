package com.shaoyuan.core.Interfaces;

import android.content.Context;

import com.shaoyuan.model.dierbanBean.CoachBean;

/**
 * Created by gzl on 2019/8/6 14:34
 * title：教练列表
 */
public interface CoachInterface {
    interface view{
        Context getContext();
        void initView();

        void initData();

        void initCoach(CoachBean coachBean);

    }

    interface presenter{
        void initCoach();
    }
}
