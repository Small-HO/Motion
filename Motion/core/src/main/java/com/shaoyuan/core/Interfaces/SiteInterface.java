package com.shaoyuan.core.Interfaces;

import android.content.Context;

import com.shaoyuan.model.dierbanBean.JudgeCoactBean;
import com.shaoyuan.model.dierbanBean.SiteBean;
import com.shaoyuan.model.dierbanBean.SiteScreenBean;

/**
 * Created by gzl on 2019/8/1 9:26
 * title：场地预约
 */
public interface SiteInterface {
    interface view {
        Context getContext();

        void initView();

        void initData();

        void initJudgeCoact(JudgeCoactBean judgeCoactBean); //  教练
        void intJudgeCoacts(JudgeCoactBean judgeCoactBean); //  用户
        void site(SiteBean siteBean);   //  列表

        void initSiteScreen(SiteScreenBean siteScreenBean);

        void showLog(String log);
    }


    interface presenter {
        void submit();
    }
}
