package com.shaoyuan.motion.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.shaoyuan.api.Constants;
import com.shaoyuan.core.Interfaces.CoachDetailInterface;
import com.shaoyuan.core.persenter.CoachDetailPresenter;
import com.shaoyuan.core.utils.Utils;
import com.shaoyuan.model.dierbanBean.CoachDetailBean;
import com.shaoyuan.motion.BaseActivity;
import com.shaoyuan.motion.R;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class CoachDetailActivity extends BaseActivity implements CoachDetailInterface.view {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_back_title)
    TextView tvBackTitle;
    @BindView(R.id.img_coach_detail)
    ImageView imgCoachDetail;
    @BindView(R.id.tv_coach_detail_name)
    TextView tvCoachDetailName;
    @BindView(R.id.tv_coach_detail_area)
    TextView tvCoachDetailArea;
    @BindView(R.id.tv_coach_detail_capac)
    TextView tvCoachDetailCapac;
    @BindView(R.id.tv_coach_detail_region)
    TextView tvCoachDetailRegion;
    @BindView(R.id.tv_coach_detail_distance)
    TextView tvCoachDetailDistance;
    @BindView(R.id.tv_coach_detail_machname)
    TextView tvCoachDetailMachname;
    @BindView(R.id.tv_coach_detail_equpro)
    TextView tvCoachDetailEqupro;
    @BindView(R.id.bt_coach_detail_mack)
    Button btCoachDetailMack;
    private String machid;
    private CoachDetailPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_coach_detail;
    }


    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void initView() {
        tvBackTitle.setText("预约详情");
        Intent intent = getIntent();
        machid = intent.getStringExtra("areaid");
        presenter = new CoachDetailPresenter(this);
    }

    @Override
    public void initData() {
        presenter.initCoachDetail();
    }

    @Override
    public void initCoachDetail(CoachDetailBean model) {
        List<CoachDetailBean.AreainfoBean> areainfo = model.getAreainfo();
        for (int i = 0; i < areainfo.size(); i++) {
            List<String> pic = areainfo.get(i).getPic();
            for (int j = 0; j < pic.size(); j++) {
                RequestOptions options = RequestOptions.bitmapTransform(new RoundedCorners(20));
                Glide.with(this).load(pic.get(j)).apply(options).into(imgCoachDetail);
            }
            String areaname = areainfo.get(i).getAreaname();       //场馆类型
            String machname = areainfo.get(i).getMachname();        //场馆名
            String capac = areainfo.get(i).getCapac();          //最大容纳人数
            String area = areainfo.get(i).getArea();            //面积
            double lat = areainfo.get(i).getLat();              //纬度
            double lng = areainfo.get(i).getLng();              //经度
            String region = areainfo.get(i).getRegion();        //区域

            tvCoachDetailName.setText(areaname);
            tvCoachDetailMachname.setText(machname);
            tvCoachDetailCapac.setText(capac);
            tvCoachDetailArea.setText(area);
            tvCoachDetailRegion.setText(region);
            double distance = Utils.DistanceOfTwoPoints(Constants.WEIDU, Constants.JINDDU, lat,lng);
            tvCoachDetailDistance.setText("距您"+distance+"公里");
        }
    }

    @Override
    public String getAreaid() {
        return machid;
    }

    @Override
    public void showLog(String log) {

    }

    @OnClick({R.id.iv_back, R.id.bt_coach_detail_mack})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            //预约
            case R.id.bt_coach_detail_mack:
                break;
        }
    }
}
