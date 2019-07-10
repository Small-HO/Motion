package com.shaoyuan.core.Interfaces;

import android.content.Context;

import com.shaoyuan.model.BannerModel;

import java.util.List;

/**
 * Created by small-ho on 2019/7/10 10:34
 * title：首页Fragment接口
 */
public interface HomeInterface {
    interface view {
        Context getContext();

        void initBannerView(List<BannerModel> info);
    }
    interface presenter {
        List<BannerModel> initBannerData();
    }
}
