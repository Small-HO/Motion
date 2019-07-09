package com.shaoyuan.motion.utils;

import android.app.Activity;

import java.util.Stack;

/**
 * Created by small-ho on 2019/7/6 16:07
 * title：Activity管理类
 */
public class ActivityManager {
    private static Stack<Activity> mActivityStack;
    private static ActivityManager mInstance;

    private ActivityManager(){}

    /** 单利模式 */
    public static ActivityManager getInstance(){
        if (mInstance == null){
            synchronized (ActivityManager.class){
                if (mInstance == null){
                    mInstance = new ActivityManager();
                }
            }
        }
        return mInstance;
    }

    /** 添加一个Activity到堆栈 */
    public void addActivity(Activity activity){
        if (null == mActivityStack){
            mActivityStack = new Stack<>();
        }
        mActivityStack.add(activity);
    }

    /** 从堆栈中移除一个指定的Activity */
    public void removeActivity(Activity activity){
        if (mActivityStack != null){
            mActivityStack.remove(activity);
        }
    }

    /** 获取顶部的Activity */
    public static Activity getTopActivity(){
        if (mActivityStack.isEmpty()){
            return null;
        }else {
            return mActivityStack.get(mActivityStack.size() - 1);
        }
    }

    /** 结束所有的Activity */
    public static void removeAllActivity(){
        if (mActivityStack != null && mActivityStack.size() > 0){
            for (Activity activity: mActivityStack) {
                activity.finish();
            }
        }
    }
}
