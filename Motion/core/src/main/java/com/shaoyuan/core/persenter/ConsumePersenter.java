package com.shaoyuan.core.persenter;

import com.shaoyuan.core.Interfaces.ConsumeInterface;
import com.shaoyuan.core.action.AppAction;
import com.shaoyuan.core.actionImpl.AppActionImpl;
import com.shaoyuan.model.dataModel.DataReportModel;
import com.shaoyuan.net.HttpCallback;

import java.util.Map;

/**
 * Created by small-ho on 2019/7/20 10:23
 * title：分析报告消耗fragment核心逻辑
 */
public class ConsumePersenter implements ConsumeInterface.presenter {
    private ConsumeInterface.view view;
    private AppAction action;

    public ConsumePersenter(ConsumeInterface.view view) {
        this.view = view;
        action = new AppActionImpl(view.getContext());
    }

    @Override
    public void initConsumeDatas() {
        action.reportsAnalyses(params(), new HttpCallback<DataReportModel>() {
            @Override
            public void onSuccess(DataReportModel dataReportModel) {
                view.showLog("报告分析：" + dataReportModel.toString());
                view.initConsumeDatas(dataReportModel);
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
