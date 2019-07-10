package com.shaoyuan.motion.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shaoyuan.core.Interfaces.HomeInterface;
import com.shaoyuan.core.persenter.HomePresenter;
import com.shaoyuan.model.BannerModel;
import com.shaoyuan.motion.R;
import com.shaoyuan.motion.utils.MyImageLoader;
import com.shaoyuan.motion.utils.MyScalePageTransformer;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements HomeInterface.view {
    private static final String Tag = "HomeFragment";

    @BindView(R.id.tv_home_title)TextView mTitle;
    @BindView(R.id.banner)Banner mBanner;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        initViews(view);
        return view;
    }

    @Override
    public void initViews(View view) {
        HomePresenter mHomePresenter = new HomePresenter(this, getContext());
        mTitle.setText(R.string.tv_tab_home_title);
        initBannerView(mHomePresenter.initBannerData());
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
}
