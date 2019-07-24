package com.shaoyuan.core.Interfaces;

import android.content.Context;

import com.shaoyuan.model.dataModel.WorkModel;

/**
 * Created by small-ho on 2019/7/23 17:27
 * title：添加工作核心接口
 */
public interface WorkInterface {
    interface view {
        Context getContext();

        void initView();
        void initData();

        String getSearchText(); //  获取输入内容

        void initClassItem(WorkModel model);
        void initContextItem(WorkModel model);

        void showLog(String log);
    }

    interface presenter {
        void initClassItem();
        void initContextItem();
    }
}
