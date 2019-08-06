package com.shaoyuan.motion.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.shaoyuan.api.Constants;
import com.shaoyuan.core.Interfaces.SiteDetailInterface;
import com.shaoyuan.core.persenter.SiteDetailPresenter;
import com.shaoyuan.core.utils.Utils;
import com.shaoyuan.model.dierbanBean.SiteDetailBean;
import com.shaoyuan.motion.BaseActivity;
import com.shaoyuan.motion.R;
import com.shaoyuan.motion.adapter.SiteApparatusAdapter;
import com.shaoyuan.motion.adapter.SiteCoachAdapter;
import com.shaoyuan.motion.adapter.SiteFunctionAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class SiteDetailActivity extends BaseActivity implements SiteDetailInterface.view {

    @BindView(R.id.tv_back_title)
    TextView mTitle;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.img_site_detail)
    ImageView imgSiteDetail;
    @BindView(R.id.tv_site_title)
    TextView tvSiteTitle;
    @BindView(R.id.tv_site_name)
    TextView tvSiteName;
    @BindView(R.id.tv_site_distance)
    TextView tvSiteDistance;
    @BindView(R.id.tv_site_telon)
    TextView tvSiteTelon;
    @BindView(R.id.tv_site_price)
    TextView tvSitePrice;
    @BindView(R.id.tv_site_area)
    TextView tvSiteArea;
    @BindView(R.id.tv_site_shower)
    TextView tvSiteShower;
    @BindView(R.id.tv_site_pmax)
    TextView tvSitePmax;
    @BindView(R.id.tv_site_detail)
    TextView tvSiteDetail;
    @BindView(R.id.rec_site_function)
    RecyclerView recSiteFunction;
    @BindView(R.id.rec_site_apparatus)
    RecyclerView recSiteApparatus;
    @BindView(R.id.rec_site_coach)
    RecyclerView recSiteCoach;
    @BindView(R.id.rec_site_train)
    RecyclerView recSiteTrain;
    @BindView(R.id.rec_site_date)
    RecyclerView recSiteDate;
    @BindView(R.id.rec_site_course)
    RecyclerView recSiteCourse;

    private String machid;
    private SiteDetailPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_site_detail;
    }


    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void initView() {
        mTitle.setText("场地详情");
        Intent intent = getIntent();
        machid = intent.getStringExtra("machid");
        presenter = new SiteDetailPresenter(this);
    }

    @Override
    public void initData() {
        presenter.initSiteDetail();
        startload();
    }

    @Override
    public void initSiteDetail(SiteDetailBean siteDetailBean) {
        stopload();
        List<SiteDetailBean.VenueinfoBean> venueinfo = siteDetailBean.getVenueinfo();
        for (int i = 0; i < venueinfo.size(); i++) {
            String machname = venueinfo.get(i).getMachname();    //场馆名
            String address = venueinfo.get(i).getAddress();         //场馆地址
            double lat = venueinfo.get(i).getLat();             //维度
            double lng = venueinfo.get(i).getLng();             //经度
            List<String> pic = venueinfo.get(i).getPic();
            for (int j = 0; j < pic.size(); j++) {
                String s = pic.get(j);              //场馆图片
                RequestOptions options = RequestOptions.bitmapTransform(new RoundedCorners(10));
                Glide.with(this).load(s)
                        .apply(options)
                        .into(imgSiteDetail);
            }
            String price = venueinfo.get(i).getPrice();         //价钱范围
            String telno = venueinfo.get(i).getTelno();         //手机号
            String floorarea = venueinfo.get(i).getFloorarea();     //面积
            String pmax = venueinfo.get(i).getPmax();           //最大容纳人数
            String ifshower = venueinfo.get(i).getIfshower();    //是否提供洗浴 0.提供，1.不提供
            String detail = venueinfo.get(i).getDetail();       //场馆描述
            tvSiteTitle.setText(machname);
            tvSiteName.setText(address);
            double distance = Utils.DistanceOfTwoPoints(Constants.WEIDU, Constants.JINDDU, lat, lng);
            tvSiteDistance.setText("距您" + distance + "公里");
            tvSitePrice.setText(price);
            tvSitePmax.setText(pmax);
            tvSiteArea.setText(floorarea);
            tvSiteTelon.setText(telno);
            tvSiteDetail.setText(detail);
            if (ifshower.equals("0")) {
                tvSiteShower.setText("提供");
            } else if (ifshower.equals("1")) {
                tvSiteShower.setText("不提供");
            }
        }
    //  功能介绍列表
        List<SiteDetailBean.FuncintroBean> funcintro = siteDetailBean.getFuncintro();
        SiteFunctionAdapter siteFunctionAdapter=new SiteFunctionAdapter(this,funcintro);
        LinearLayoutManager functionManager=new LinearLayoutManager(this);
        functionManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recSiteFunction.setLayoutManager(functionManager);
        recSiteFunction.setAdapter(siteFunctionAdapter);
    //  器械介绍列表
        List<SiteDetailBean.ApparlistBean> apparlist = siteDetailBean.getApparlist();
        SiteApparatusAdapter siteApparatusAdapter=new SiteApparatusAdapter(this,apparlist);
        LinearLayoutManager appartManager=new LinearLayoutManager(this);
        appartManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recSiteApparatus.setLayoutManager(appartManager);
        recSiteApparatus.setAdapter(siteApparatusAdapter);
    //场馆教练
        List<SiteDetailBean.CoachinfoBean> coachinfo = siteDetailBean.getCoachinfo();
        SiteCoachAdapter coachAdapter=new SiteCoachAdapter(this,coachinfo);
        LinearLayoutManager coachManager=new LinearLayoutManager(this);
        coachManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recSiteCoach.setLayoutManager(coachManager);
        recSiteCoach.setAdapter(coachAdapter);
    }

    @Override
    public String getMachid() {
        return machid;
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
