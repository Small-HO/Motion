package com.shaoyuan.core.persenter;

import com.shaoyuan.api.Constants;
import com.shaoyuan.core.Interfaces.SiteInterface;
import com.shaoyuan.core.action.AppAction;
import com.shaoyuan.core.actionImpl.AppActionImpl;
import com.shaoyuan.model.dierbanBean.JudgeCoactBean;
import com.shaoyuan.model.dierbanBean.SiteBean;
import com.shaoyuan.model.dierbanBean.SiteScreenBean;
import com.shaoyuan.net.HttpCallback;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gzl on 2019/8/1 9:30
 * title：
 */
public class SitePresenter implements SiteInterface.presenter{

    private SiteInterface.view view;
    private AppAction appAction;
    private String ceshi;

    public SitePresenter(SiteInterface.view view) {
        this.view = view;
        appAction=new AppActionImpl(view.getContext());
    }


    @Override
    public void submit() {
        appAction.judgeCoach(params(), new HttpCallback<JudgeCoactBean>() {
            @Override
            public void onSuccesss(JudgeCoactBean result) {
                ceshi = result.getPertype();
                //view.showLog("测试教练数据：" + result.toString() + "测试id：" + ceshi);
                if (result.getRepcode().equals("00")) {
                    view.initJudgeCoact(result);    //  显示教练
                }else if (result.getRepcode().equals("01")) {
                    view.intJudgeCoacts(result);
                }
                submits(ceshi);
                siteScreen(ceshi);
            }
        });
    }


    private void submits(String perType) {
        appAction.site(param(perType), new HttpCallback<SiteBean>() {
            @Override
            public void onSuccesss(SiteBean result) {
                view.site(result);
            }
        });
    }

    private void siteScreen(String perType) {
        appAction.siteScreen(map(perType), new HttpCallback<SiteScreenBean>() {
            @Override
            public void onSuccesss(SiteScreenBean result) {
                view.initSiteScreen(result);
            }
        });
    }

    private Map<String, Object> params() {
        Map<String,Object> map=new HashMap<>();
        map.put("method","judgecoach");
        //15641307846793458
        //教练
        //15600480279493010
        map.put("userid","15600480279493010");
        return map;
    }

    private Map<String, Object> param(String perType) {
        Map<String,Object> map=new HashMap<>();
        map.put("method","venuelist");
        map.put("pertype",perType);
        map.put("areasele","");
        map.put("areasort","");
        map.put("price","");
        map.put("dissort","");
        map.put("lat",Constants.WEIDU);
        map.put("lng",Constants.JINDDU);
        map.put("function","");
        map.put("equipment","");
        map.put("usearea","");
        map.put("coursekind","");
        view.showLog("测试参数：" + map.toString());
        return map;
    }

    private Map<String, Object> map(String perType) {
        Map<String,Object> map=new HashMap<>();
        map.put("method","venuescreen");
        map.put("city","石家庄市");
        map.put("pertype",perType);
        map.put("lng", Constants.JINDDU);
        map.put("lat",Constants.WEIDU);
        return map;
    }


}
