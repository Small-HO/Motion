package com.shaoyuan.core.persenter;

import com.shaoyuan.core.Interfaces.CoachInterface;
import com.shaoyuan.core.action.AppAction;
import com.shaoyuan.core.actionImpl.AppActionImpl;
import com.shaoyuan.model.dierbanBean.CoachBean;
import com.shaoyuan.net.HttpCallback;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gzl on 2019/8/6 14:34
 * title：教练列表
 */
public class CoachPresenter implements CoachInterface.presenter {

    private CoachInterface.view view;
    private AppAction appAction;

    public CoachPresenter(CoachInterface.view view) {
        this.view = view;
        appAction=new AppActionImpl(view.getContext());
    }

    @Override
    public void initCoach() {
        appAction.coach(params(), new HttpCallback<CoachBean>() {
            @Override
            public void onSuccesss(CoachBean result) {
                view.initCoach(result);
            }
        });
    }

    private Map<String,Object> params(){
        Map<String,Object> map=new HashMap<>();
        map.put("method","caochlist");
        //用户
        //15641307846793458
        //教练
        //15600480279493010
        map.put("userid","15641307846793458");
        map.put("beginline","1");
        map.put("count","10");
        map.put("sex","");
        map.put("labelist","");
        map.put("uptime","");
        map.put("downtime","");
        map.put("price","");
        map.put("comment","");
        return map;
    }
}
