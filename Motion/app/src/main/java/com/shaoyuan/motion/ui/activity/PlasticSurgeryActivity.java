package com.shaoyuan.motion.ui.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.shaoyuan.core.Interfaces.PlasticSurgeryInterface;
import com.shaoyuan.core.persenter.PlasticSurgeryPresenter;
import com.shaoyuan.core.utils.LogUtils;
import com.shaoyuan.model.personalBean.PhysicalDetailsBean;
import com.shaoyuan.motion.BaseActivity;
import com.shaoyuan.motion.R;
import com.shaoyuan.motion.adapter.InspectAdapter;
import com.shaoyuan.motion.adapter.LabelAdapter;
import com.shaoyuan.motion.adapter.TraitAdapter;
import com.shaoyuan.motion.utils.ImageLoader;

import butterknife.BindView;
import butterknife.OnClick;

@SuppressLint("SetTextI18n")
public class PlasticSurgeryActivity extends BaseActivity implements PlasticSurgeryInterface.view {
    private static final String Tag = "PlasticSurgeryActivity";
    private PlasticSurgeryPresenter presenter;

    @BindView(R.id.tv_back_title)TextView mTitle;
    @BindView(R.id.iv_image)ImageView mImage;
    @BindView(R.id.tv_item_title)TextView mName;
    @BindView(R.id.recycler_view)RecyclerView mLabel;
    @BindView(R.id.tv_num)TextView mNum;
    @BindView(R.id.tv_original_price)TextView mOriginal;
    @BindView(R.id.tv_current_price_context)TextView mCurrent;

    @BindView(R.id.recycler_view_item)RecyclerView mTrait;
    @BindView(R.id.tv_taocan)TextView mCombo;

    @BindView(R.id.inspectRV)RecyclerView mInspect;
    @BindView(R.id.mechanismname)TextView mPlasticName;
    @BindView(R.id.address)TextView mAddress;

    @BindView(R.id.tv_current_price)TextView mPriceCurrent;
    @BindView(R.id.ealprices2)TextView mEalprices;

    private PhysicalDetailsBean bean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startload();
        initView();
        initData();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_plastic_surgery;
    }

    @OnClick({R.id.iv_back,R.id.tv_reservation})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_reservation:
                toOrderPage();
                break;
        }
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void initView() {
        presenter = new PlasticSurgeryPresenter(this);
    }

    @Override
    public void initData() {
        presenter.initPlasticSurgeryData(); //  初始化体检详情
    }

    @Override
    public String initInterData() {
        return getIntent().getStringExtra("setmealid");
    }

    @Override
    public void initPlasticSurgeryData(PhysicalDetailsBean bean) {
        this.bean = bean;

        mTitle.setText(bean.getMechname());                         //  标题
        ImageLoader.image(this,bean.getExhpic(),mImage);    //  footer
        mName.setText(bean.getSetmealname());                       //  套餐名称
        //  标签
        mLabel.setLayoutManager(new GridLayoutManager(this,4));
        mLabel.setAdapter(new LabelAdapter(this,bean.getDisease()));

        mNum.setText("共" + bean.getTotal() + "项检查");             //  项目条数
        mOriginal.setText("￥" + bean.getSetmealprices());           //  原价
        mOriginal.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
        mCurrent.setText("￥" + bean.getSetmealprice());             //  现价
        //  套餐特点
        mTrait.setLayoutManager(new GridLayoutManager(this,4));
        mTrait.setAdapter(new TraitAdapter(this,bean.getDisease()));

        mCombo.setText("-" + bean.getSetmealname() + "-");          //  套餐标题
        //  检查项目
        mInspect.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mInspect.setAdapter(new InspectAdapter(this,bean.getMinationlist()));

        mPlasticName.setText(bean.getMechname());                   //  地址名称
        mAddress.setText("地址：" + bean.getMechaddress());         //  详细地址

        mPriceCurrent.setText("￥" + bean.getSetmealprice());        //  结算现价
        mEalprices.setText("￥" + bean.getSetmealprices());          //  结算原价
        mEalprices.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);

        stopload();
    }

    @Override
    public void toOrderPage() {
        startActivity(new Intent(this,BookingOrderActivity.class)
                .putExtra("setmealid",getIntent().getStringExtra("setmealid"))
                .putExtra("pic",bean.getExhpic())
                .putExtra("setmealname",bean.getSetmealname())
                .putExtra("mechname",bean.getMechname())
                .putExtra("setmealprice",bean.getSetmealprice())
                .putExtra("setmealprices",bean.getSetmealprices())
        );
    }

    @Override
    public void showLog(String log) {
        LogUtils.i(Tag,log);
    }
}
