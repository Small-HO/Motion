package com.shaoyuan.motion;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

import com.shaoyuan.motion.utils.ActivityManager;

import butterknife.ButterKnife;

/**
 * Created by small-ho on 2019/7/6 16:08
 * title：Activity基类
 */
@SuppressLint("Registered")
public abstract class BaseActivity extends AppCompatActivity {
    private static long lastClickTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        ActivityManager.getInstance().addActivity(this);   //  添加到栈中
    }

    /** 处理activity跳转两次问题 */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN){
            if (isFastDoubleClick()){
                return true;
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.getInstance().removeActivity(this);//  从栈中移除
    }

    public static boolean isFastDoubleClick(){
        long time = System.currentTimeMillis();
        long timed = time - lastClickTime;
        lastClickTime = time;
        return timed >= 0 && timed <= 500;
    }

    protected abstract int getLayoutId();
}
