package com.shaoyuan.motion.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AbsListView;

import com.shaoyuan.core.Interfaces.PayInterface;
import com.shaoyuan.core.persenter.PayPresenter;
import com.shaoyuan.core.utils.LogUtils;
import com.shaoyuan.motion.R;
import com.shaoyuan.motion.config.Constants;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by small-ho on 2019/8/6 13:20
 * title：支付弹框
 */
public class PayDialog extends Dialog implements PayInterface.view {
    private static final String Tag = "PayDialog";
    private PayPresenter payPresenter;

    public PayDialog(Context context) {
        super(context, R.style.MyDialogSize);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_dialog_pay);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @OnClick({R.id.rl_alipay,R.id.rl_wxpay,R.id.rl_pay})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_alipay:
                payPresenter.alipay();
                break;
            case R.id.rl_wxpay:
                payPresenter.wxpay();
                break;
            case R.id.rl_pay:
                payPresenter.pay();
                break;
        }
    }

    @Override
    public void initView() {
        payPresenter = new PayPresenter(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public String getAppid() {
        return Constants.App_ID;
    }

    @Override
    public void showLog(String log) {
        LogUtils.i(Tag,log);
    }

    @Override
    public void show() {
        super.show();
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.gravity = Gravity.BOTTOM;
        layoutParams.width = AbsListView.LayoutParams.MATCH_PARENT;
        layoutParams.height = AbsListView.LayoutParams.WRAP_CONTENT;

        getWindow().setAttributes(layoutParams);
    }
}
