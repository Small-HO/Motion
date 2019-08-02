package com.shaoyuan.core.Interfaces;

import android.content.Context;

import com.shaoyuan.model.dierbanBean.SiteDetailBean;

/**
 * Created by gzl on 2019/8/2 9:46
 * title：场地详情-用户
 */
public interface SiteDetailInterface {
    interface view{
        Context getContext();

        void initView();

        void initData();

        void initSiteDetail(SiteDetailBean siteDetailBean);

        String getMachid();
    }

    interface presenter{
        void initSiteDetail();
    }
}
