package com.shaoyuan.core.persenter;

import com.shaoyuan.core.Interfaces.CoachDetailInterface;
import com.shaoyuan.core.action.AppAction;
import com.shaoyuan.core.actionImpl.AppActionImpl;
import com.shaoyuan.model.dierbanBean.CoachDetailBean;
import com.shaoyuan.net.HttpCallback;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gzl on 2019/8/6 10:18
 * title：
 */
public class CoachDetailPresenter implements CoachDetailInterface.presenter {

    private CoachDetailInterface.view view;
    private AppAction appAction;

    public CoachDetailPresenter(CoachDetailInterface.view view) {
        this.view = view;
        appAction=new AppActionImpl(view.getContext());
    }

    @Override
    public void initCoachDetail() {
        appAction.coachDetail(param(), new HttpCallback<CoachDetailBean>() {
            @Override
            public void onSuccesss(CoachDetailBean result) {
                view.initCoachDetail(result);
            }
        });
    }

    private Map<String,Object> param(){
        Map<String,Object> map=new HashMap<>();
        map.put("method","areainfo");
        map.put("areaid",view.getAreaid());
        return map;
    }
}
