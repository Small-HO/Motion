package com.shaoyuan.motion.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.shaoyuan.core.Interfaces.MineInterface;
import com.shaoyuan.motion.BaseFragment;
import com.shaoyuan.motion.R;
import com.shaoyuan.motion.ui.activity.HeaderActivity;
import com.shaoyuan.motion.ui.activity.OrderActivity;
import com.shaoyuan.motion.ui.activity.QuestionsActivity;
import com.shaoyuan.motion.ui.activity.SecureActivity;
import com.shaoyuan.motion.ui.activity.UserActivity;

import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends BaseFragment implements MineInterface.view {

    public MineFragment() {
        // Required empty public constructor
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @OnClick({R.id.iv_header,R.id.tv_module_order,R.id.tv_module_cookies,R.id.tv_module_resume,
            R.id.rl_module_secure,R.id.rl_module_share,R.id.rl_module_faq,R.id.rl_module_set,R.id.rl_module_feedback,
            R.id.rl_module_exit
    })
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_header:            //  头像
                toHeaderPage();
                break;
            case R.id.tv_module_order:      //  订单
                toOrderPage();
                break;
            case R.id.tv_module_cookies:    //  浏览记录

                break;
            case R.id.tv_module_resume:     //  个人资料
                toUserPage();
                break;
            case R.id.rl_module_secure:     //  修改密码
                toSecurePage();
                break;
            case R.id.rl_module_share:      //  分享客户端

                break;
            case R.id.rl_module_faq:        //  常见问题
                toQuestions();
                break;
            case R.id.rl_module_set:        //  设置中心

                break;
            case R.id.rl_module_feedback:   //  意见反馈

                break;
            case R.id.rl_module_exit:       //  退出登录

                break;
        }
    }

    @Override
    public void initFragmentData(Bundle savedInstanceState) {

    }

    @Override
    public void toHeaderPage() {
        startActivity(new Intent(getContext(), HeaderActivity.class));
    }

    @Override
    public void toOrderPage() {
        startActivity(new Intent(getContext(), OrderActivity.class));
    }

    @Override
    public void toUserPage() {
        startActivity(new Intent(getContext(), UserActivity.class));
    }

    @Override
    public void toSecurePage() {
        startActivity(new Intent(getContext(), SecureActivity.class));
    }

    @Override
    public void toQuestions() {
        startActivity(new Intent(getContext(), QuestionsActivity.class));
    }
}
