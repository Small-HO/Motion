package com.shaoyuan.core.Interfaces;

import android.content.Context;

import com.shaoyuan.model.dataInfo.QuestionInfo;

/**
 * Created by small-ho on 2019/7/17 17:15
 * title：常见问题核心接口
 */
public interface QuestionsInterface {
    interface view {
        Context getContext();

        void initView();
        
        void initQuestionDatas(QuestionInfo info);
    }

    interface presenter{
        void initQuestionDatas();
    }
}
