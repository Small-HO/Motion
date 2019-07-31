package com.shaoyuan.motion.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.shaoyuan.motion.BaseActivity;
import com.shaoyuan.motion.R;
import com.shaoyuan.motion.ui.view.sitepopwindow.UserPopupWindow;

import butterknife.BindView;
import butterknife.OnClick;

public class SiteActivity extends BaseActivity {

    @BindView(R.id.tv_back_title)
    TextView mTitle;
    @BindView(R.id.tv_area)
    TextView tvArea;
    @BindView(R.id.tv_venue)
    TextView tvVenue;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_distance)
    TextView tvDistance;
    @BindView(R.id.rec_user_venue)
    RecyclerView recUserVenue;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.img_jiaru)
    ImageView imgJiaRu;
    //Popwindow
    private UserPopupWindow diyPopupWindow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTitle.setText(R.string.tv_home_module_site);
        imgJiaRu.setVisibility(View.VISIBLE);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_site;
    }

    @OnClick({ R.id.tv_area, R.id.tv_venue, R.id.tv_price, R.id.tv_distance,R.id.iv_back,R.id.img_jiaru})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_area:
                if (diyPopupWindow == null) {
                    diyPopupWindow = new UserPopupWindow(this);
                }
                diyPopupWindow.setAnimationStyle(android.R.style.Animation_Toast);
                diyPopupWindow.showViewBottom(tvArea, 0);
                break;
            case R.id.tv_venue:
                break;
            case R.id.tv_price:
                break;
            case R.id.tv_distance:
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.img_jiaru:
                break;
        }
    }
}
