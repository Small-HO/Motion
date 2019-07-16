package com.shaoyuan.motion.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.shaoyuan.core.Interfaces.HomeInterface;
import com.shaoyuan.core.persenter.HomePresenter;
import com.shaoyuan.model.dataModel.BannerModel;
import com.shaoyuan.motion.BaseFragment;
import com.shaoyuan.motion.R;
import com.shaoyuan.motion.ui.activity.CoachActivity;
import com.shaoyuan.motion.ui.activity.CurriculumActivity;
import com.shaoyuan.motion.ui.activity.EquipmentActivity;
import com.shaoyuan.motion.ui.activity.MedicalActivity;
import com.shaoyuan.motion.ui.activity.PlanActivity;
import com.shaoyuan.motion.ui.activity.RecipeActivity;
import com.shaoyuan.motion.ui.activity.RecordActivity;
import com.shaoyuan.motion.ui.activity.SiteActivity;
import com.shaoyuan.motion.utils.MyImageLoader;
import com.shaoyuan.motion.utils.MyScalePageTransformer;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment implements HomeInterface.view {
    private static final String Tag = "HomeFragment";
    private HomePresenter mHomePresenter;

    @BindView(R.id.tv_title)TextView mTitle;
    @BindView(R.id.banner)Banner mBanner;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void initFragmentData(Bundle savedInstanceState) {
        mHomePresenter = new HomePresenter(this, getContext());
        mTitle.setText(R.string.tv_tab_home_title);
        initBannerView(mHomePresenter.initBannerData());
    }

    @OnClick({R.id.tv_module_recipe,R.id.tv_module_plan,R.id.tv_module_medical,R.id.tv_module_record,
            R.id.tv_module_site,R.id.tv_module_equipment,R.id.tv_module_coach,R.id.tv_module_curriculum})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_module_recipe:     //  运动处方
                toRecipePage();
                break;
            case R.id.tv_module_plan:       //  运动计划
                toPlanPage();
                break;
            case R.id.tv_module_medical:    //  健康医疗
                toMedicalPage();
                break;
            case R.id.tv_module_record:     //  健康档案
                toRecordPage();
                break;
            case R.id.tv_module_site:       //  场地预约
                toSitePage();
                break;
            case R.id.tv_module_equipment:  //  器材预约
                toEquipmentPage();
                break;
            case R.id.tv_module_coach:      //  教练预约
                toCoachPage();
                break;
            case R.id.tv_module_curriculum: //  课程预约
                toCurriculumPage();
                break;
        }
    }

    /** 初始化首页轮播 */
    @Override
    public void initBannerView(List<BannerModel> info) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < info.size(); i++) {
            list.add(info.get(i).getUrl());
        }
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .setImageLoader(new MyImageLoader())
                .setImages(list)                        //  设置图片路径集合
                .setPageTransformer(true,new MyScalePageTransformer())
                .setOffscreenPageLimit(list.size())     //  预加载个数，路径集合的个数
                .setDelayTime(3000)                     //  设置轮播时间间隔
                .isAutoPlay(true)                       //  设置是否自动轮播
                .setIndicatorGravity(BannerConfig.CENTER);  //  设置指示器的位置，左中右
        mBanner.start();
    }

    /** 跳转运动处方 */
    @Override
    public void toRecipePage() {
        startActivity(new Intent(getContext(), RecipeActivity.class));
    }

    /** 跳转运动计划 */
    @Override
    public void toPlanPage() {
        startActivity(new Intent(getContext(), PlanActivity.class));
    }

    /** 跳转健康医疗 */
    @Override
    public void toMedicalPage() {
        startActivity(new Intent(getContext(), MedicalActivity.class));
    }

    /** 跳转健康档案 */
    @Override
    public void toRecordPage() {
        startActivity(new Intent(getContext(), RecordActivity.class));
    }

    /** 跳转场地预约 */
    @Override
    public void toSitePage() {
        startActivity(new Intent(getContext(), SiteActivity.class));
    }

    /** 跳转器材预约 */
    @Override
    public void toEquipmentPage() {
        startActivity(new Intent(getContext(), EquipmentActivity.class));
    }

    /** 跳转教练预约 */
    @Override
    public void toCoachPage() {
        startActivity(new Intent(getContext(), CoachActivity.class));
    }

    /** 跳转课程预约 */
    @Override
    public void toCurriculumPage() {
        startActivity(new Intent(getContext(), CurriculumActivity.class));
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }
}
