package com.shaoyuan.motion.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.shaoyuan.core.Interfaces.CoachInterface;
import com.shaoyuan.core.persenter.CoachPresenter;
import com.shaoyuan.model.dierbanBean.CoachBean;
import com.shaoyuan.motion.BaseActivity;
import com.shaoyuan.motion.R;
import com.shaoyuan.motion.adapter.CoachAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 教练列表
 */
public class CoachActivity extends BaseActivity implements CoachInterface.view {

    @BindView(R.id.tv_back_title)
    TextView mTitle;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_coach_begood)
    TextView tvCoachBegood;
    @BindView(R.id.img_one)
    ImageView imgOne;
    @BindView(R.id.line_coach_begood)
    LinearLayout lineCoachBegood;
    @BindView(R.id.tv_coach_age)
    TextView tvCoachAge;
    @BindView(R.id.img_two)
    ImageView imgTwo;
    @BindView(R.id.line_coach_age)
    LinearLayout lineCoachAge;
    @BindView(R.id.tv_coach_sex)
    TextView tvCoachSex;
    @BindView(R.id.img_three)
    ImageView imgThree;
    @BindView(R.id.line_coach_sex)
    LinearLayout lineCoachSex;
    @BindView(R.id.tv_coach_screen)
    TextView tvCoachScreen;
    @BindView(R.id.img_for)
    ImageView imgFor;
    @BindView(R.id.ling_coach_screen)
    LinearLayout lingCoachScreen;
    @BindView(R.id.rec_coach)
    RecyclerView recCoach;
    @BindView(R.id.img_jiaru)
    ImageView imgJiaru;
    private CoachPresenter coachPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_coach;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void initView() {
        mTitle.setText(R.string.tv_home_module_coach);
        imgJiaru.setVisibility(View.VISIBLE);
        coachPresenter = new CoachPresenter(this);
    }

    @Override
    public void initData() {
        coachPresenter.initCoach();
    }

    @Override
    public void initCoach(CoachBean coachBean) {
        tvCoachBegood.setText("擅长");
        tvCoachAge.setText("从业年限");
        tvCoachSex.setText("性别");
        tvCoachScreen.setText("筛选");
        imgOne.setVisibility(View.VISIBLE);
        imgTwo.setVisibility(View.VISIBLE);
        imgThree.setVisibility(View.VISIBLE);
        imgFor.setVisibility(View.VISIBLE);

        List<CoachBean.CoachlistBean> coachlist = coachBean.getCoachlist();
        CoachAdapter coachAdapter = new CoachAdapter(this, coachlist);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recCoach.setLayoutManager(manager);
        recCoach.setAdapter(coachAdapter);
        coachAdapter.setOnItemClickListener(new CoachAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(CoachActivity.this, CoachBriefActivity.class);
                intent.putExtra("coachid", coachlist.get(position).getCoachid());
                startActivity(intent);
            }
        });
    }

    @OnClick({R.id.iv_back, R.id.line_coach_begood, R.id.line_coach_age, R.id.line_coach_sex, R.id.ling_coach_screen,R.id.img_jiaru})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.line_coach_begood:
                break;
            case R.id.line_coach_age:
                break;
            case R.id.line_coach_sex:
                break;
            case R.id.ling_coach_screen:
                break;
            case R.id.img_jiaru:
                setPopwindow();
                break;
        }
    }

    //教练申请加入
    private void setPopwindow() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.popwindow_entrance, null);
        PopupWindow popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, false);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x0000000));
        popupWindow.showAsDropDown(imgJiaru, 0, 0);
        //场馆加入我们
        LinearLayout line_venue_join = inflate.findViewById(R.id.line_venue_join);
        TextView tv_site_add = inflate.findViewById(R.id.tv_site_add);
        ImageView img_site_add = inflate.findViewById(R.id.img_site_add);
        tv_site_add.setText("教练申请加入");
        img_site_add.setBackgroundResource(R.mipmap.jianshen);
        line_venue_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                startActivity(new Intent(CoachActivity.this, VenueAddActivity.class));
            }
        });
    }

}
