package com.shaoyuan.motion.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.shaoyuan.motion.BaseFragment;
import com.shaoyuan.motion.R;

import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends BaseFragment {

    public MineFragment() {
        // Required empty public constructor
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @OnClick({R.id.tv_module_resume})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_header:            //  头像

                break;
            case R.id.tv_module_order:      //  订单

                break;
            case R.id.tv_module_cookies:    //  浏览记录

                break;
            case R.id.tv_module_resume:     //  个人资料

                break;
            case R.id.rl_module_secure:     //  修改密码

                break;
            case R.id.rl_module_share:      //  分享客户端

                break;
            case R.id.rl_module_faq:        //  常见问题

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
}
