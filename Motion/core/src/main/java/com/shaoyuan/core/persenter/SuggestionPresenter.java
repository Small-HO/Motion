package com.shaoyuan.core.persenter;

import com.shaoyuan.core.Interfaces.SuggestionInterface;
import com.shaoyuan.core.action.AppAction;
import com.shaoyuan.core.actionImpl.AppActionImpl;
import com.shaoyuan.model.BaseModel;
import com.shaoyuan.net.HttpCallback;

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
        action.suggestionSubmit(params(), new HttpCallback<BaseModel>() {
            @Override
            public void onSuccess(BaseModel baseModel) {
                view.showLog("提交意见反馈：" + baseModel.toString());
            }

            @Override
            public void onFailure(String e) {

            }
        });
    }

    private Map<String, Object> params() {
        return null;
    }
}
