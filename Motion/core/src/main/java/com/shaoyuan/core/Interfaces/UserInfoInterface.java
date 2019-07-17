package com.shaoyuan.core.Interfaces;

import android.content.Context;

import com.shaoyuan.model.dataModel.UserInfoModel;

/**
 * Created by small-ho on 2019/7/16 15:10
 * title：用户信息接口
 */
public interface UserInfoInterface {
    interface view {
        Context getContext();

        void initView();
        void initData();

        void initUserDatas(UserInfoModel model);

        String getName();
        String getSex();
        String getBirthday();
        String getStature();
        String getWeight();

        void showLog(String log);
    }
    interface presenter {
        void initUserDatas();
        void saveUserDatas();
    }
}
