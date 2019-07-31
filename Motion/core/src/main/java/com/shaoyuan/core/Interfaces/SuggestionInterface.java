package com.shaoyuan.core.Interfaces;

import android.content.Context;

import com.shaoyuan.model.personalBean.FeedbackBean;

/**
 * Created by small-ho on 2019/7/18 11:05
 * title：意见反馈
 */
public interface SuggestionInterface {
    interface view {
        Context getContext();

        void initView();

        void initFeedback(FeedbackBean feedbackBean);

        String getText();

        void showLog(String log);
    }

    interface presenter {
        void submit();
    }
}
