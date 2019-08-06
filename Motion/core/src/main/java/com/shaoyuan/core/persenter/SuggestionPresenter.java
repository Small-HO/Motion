package com.shaoyuan.core.persenter;

import com.shaoyuan.core.Interfaces.SuggestionInterface;
import com.shaoyuan.core.action.AppAction;
import com.shaoyuan.core.actionImpl.AppActionImpl;
import com.shaoyuan.model.BaseModel;
import com.shaoyuan.model.personalBean.FeedbackBean;
import com.shaoyuan.net.HttpCallback;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by small-ho on 2019/7/18 13:11
 * title：意见反馈
 */
public class SuggestionPresenter implements SuggestionInterface.presenter {
    private SuggestionInterface.view view;
    private AppAction action;

    public SuggestionPresenter(SuggestionInterface.view view) {
        this.view = view;
        action = new AppActionImpl(view.getContext());
    }

    @Override
    public void submit() {
        action.feedback(params(), new HttpCallback<FeedbackBean>() {
            @Override
            public void onFailure(String e) {
                super.onFailure(e);
            }

            @Override
            public void onSuccesss(FeedbackBean result) {
                view.showLog(result.toString());
                view.initFeedback(result);
            }

            @Override
            public void onFailures(String erro) {

            }
        });
    }

    private Map<String, Object> params() {
        Map<String,Object> map=new HashMap<>();
        map.put("method","feedback");
        map.put("userid","1544672478830248356");
        map.put("feedres",view.getText());
        return map;
    }
}
