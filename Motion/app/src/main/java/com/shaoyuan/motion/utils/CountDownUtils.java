package com.shaoyuan.motion.utils;

import android.annotation.SuppressLint;
import android.os.CountDownTimer;
import android.widget.TextView;

/**
 * Author: Small-HO
 * Data：2017/11/29-17:09
 * Description:倒计时工具类
 */
public class CountDownUtils extends CountDownTimer {
    private TextView mTextView;

    private boolean isStart;
    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receive
     *                          {@link #onTick(long)} callbacks.
     */
    public CountDownUtils(long millisInFuture, long countDownInterval, TextView textView) {
        super(millisInFuture, countDownInterval);
        this.mTextView = textView;
        isStart = true;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onTick(long millisUntilFinished) {
        isStart = false;
        mTextView.setEnabled(false);
        mTextView.setText(millisUntilFinished / 1000 + "s");    //  设置倒计时时间
    }

    @Override
    public void onFinish() {
        isStart = true;
        mTextView.setText("重新获取");
        mTextView.setEnabled(true);
    }

    /** 判断是否停止运行 */
    public boolean onIsStart() {
        return isStart;
    }
}
