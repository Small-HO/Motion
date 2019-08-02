package com.shaoyuan.core.persenter;

import com.shaoyuan.core.Interfaces.SiteDetailInterface;
import com.shaoyuan.core.action.AppAction;
import com.shaoyuan.core.actionImpl.AppActionImpl;
import com.shaoyuan.model.dierbanBean.SiteDetailBean;
import com.shaoyuan.net.HttpCallback;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gzl on 2019/8/2 9:45
 * title：场地详情-用户
 */
public class SiteDetailPresenter implements SiteDetailInterface.presenter {

    private SiteDetailInterface.view view;
    private AppAction appAction;
    private String ceshi;

    public SiteDetailPresenter(SiteDetailInterface.view view) {
        this.view = view;
        appAction=new AppActionImpl(view.getContext());
    }

    @Override
    public void initSiteDetail() {
        appAction.siteDetail(params(), new HttpCallback<SiteDetailBean>() {
            @Override
            public void onSuccesss(SiteDetailBean result) {
                view.initSiteDetail(result);
            }
        });
    }

    private Map<String,Object> params(){
        Map<String,Object> map=new HashMap<>();
        map.put("method","venueintro");
        map.put("machid",view.getMachid());
        return map;
    }
}
