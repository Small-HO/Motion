package com.shaoyuan.motion.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

import com.shaoyuan.motion.BaseActivity;
import com.shaoyuan.motion.R;

import butterknife.BindView;
import butterknife.OnClick;

public class BookingOrderActivity extends BaseActivity {

    @BindView(R.id.tv_back_title)TextView mTitle;
    @BindView(R.id.tv_hint)TextView mHint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mTitle.setText("预约订单");
        //  改变颜色
        SpannableStringBuilder builder = new SpannableStringBuilder(mHint.getText().toString());
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.RED);
        builder.setSpan(colorSpan, 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        mHint.setText(builder);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_booking_order;
    }

    @OnClick({R.id.iv_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
