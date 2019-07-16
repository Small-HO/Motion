package com.shaoyuan.core.Interfaces;

import android.content.Context;

import com.shaoyuan.model.dataModel.BannerModel;

import java.util.List;

/**
 * Created by small-ho on 2019/7/10 10:34
 * title：首页Fragment接口
 */
public interface HomeInterface {
    interface view {
        Context getContext();

        void initBannerView(List<BannerModel> info);

        void toRecipePage();    //  运动处方
        void toPlanPage();      //  运动计划
        void toMedicalPage();   //  健康医疗
        void toRecordPage();    //  健康档案
        void toSitePage();      //  场地预约
        void toEquipmentPage(); //  器材预约
        void toCoachPage();     //  教练预约
        void toCurriculumPage();//  课程预约
    }
    interface presenter {
        List<BannerModel> initBannerData();
    }
}
