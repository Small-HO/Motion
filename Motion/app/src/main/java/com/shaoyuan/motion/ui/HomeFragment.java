package com.shaoyuan.motion.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.shaoyuan.core.Interfaces.HomeInterface;
import com.shaoyuan.core.persenter.HomePresenter;
import com.shaoyuan.model.BannerModel;
import com.shaoyuan.motion.BaseFragment;
import com.shaoyuan.motion.R;
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

    @BindView(R.id.tv_title)TextView mTitle;
    @BindView(R.id.banner)Banner mBanner;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void initFragmentData(Bundle savedInstanceState) {
        HomePresenter mHomePresenter = new HomePresenter(this, getContext());
        mTitle.setText(R.string.tv_tab_home_title);
        initBannerView(mHomePresenter.initBannerData());
    }

    @OnClick({R.id.tv_module_recipe,R.id.tv_module_plan,R.id.tv_module_medical,R.id.tv_module_record,
            R.id.tv_module_site,R.id.tv_module_equipment,R.id.tv_module_coach,R.id.tv_module_curriculum})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_module_recipe:     //  运动处方
                showToast("运动处方");
                break;
            case R.id.tv_module_plan:       //  运动计划
                showToast("运动计划");
                break;
            case R.id.tv_module_medical:    //  健康医疗
                showToast("健康医疗");
                break;
            case R.id.tv_module_record:     //  健康档案
                showToast("健康档案");
                break;
            case R.id.tv_module_site:       //  场地预约
                showToast("场地预约");
                break;
            case R.id.tv_module_equipment:  //  器材预约
                showToast("器材预约");
                break;
            case R.id.tv_module_coach:      //  教练预约
                showToast("教练预约");
                break;
            case R.id.tv_module_curriculum: //  课程预约
                showToast("课程预约");
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

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }
}
