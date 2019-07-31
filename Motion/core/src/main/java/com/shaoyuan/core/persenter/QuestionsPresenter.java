package com.shaoyuan.core.persenter;

import com.shaoyuan.core.Interfaces.QuestionsInterface;
import com.shaoyuan.core.action.AppAction;
import com.shaoyuan.core.actionImpl.AppActionImpl;
import com.shaoyuan.model.dataModel.QuestionModel;
import com.shaoyuan.net.HttpCallback;

import java.util.Map;

/**
 * Created by small-ho on 2019/7/17 17:18
 * title：常见问题核心逻辑
 */
public class QuestionsPresenter implements QuestionsInterface.presenter {
    private QuestionsInterface.view view;
    private AppAction action;

    public QuestionsPresenter(QuestionsInterface.view view) {
        this.view = view;
        action = new AppActionImpl(view.getContext());
    }

    @Override
    public void initQuestionDatas() {
        /*action.questions(params(), new HttpCallback<QuestionModel>() {
            @Override
            public void onSuccess(QuestionModel model) {
                view.showLog("常见问题数据：" + model.toString());
                view.initQuestionDatas(model);      //  显示常见问题数据
            }

            @Override
            public void onFailure(String e) {

            }
        });*/
    }

    private Map<String, Object> params() {
        return null;
    }
}
