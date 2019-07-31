package com.shaoyuan.step_lib;

/**
 * Created by small-ho on 2019/7/27 10:52
 * title：计步核心接口
 */
public interface StepInterface {

    /** 计步接口 */
    interface function {
        boolean checkStepService();     //  检测手机是否支持计步功能
        void startStep();               //  开启
        void startStop();               //  关闭
    }

    /** 数据回调 */
    interface callback{
        void sensorStepSingle(int step);    //  单次计步数据回调
        void sensorStepTotal(int step);     //  总步数回调
        void sensorStepCount(int step);     //  通过算法计算回调的步数
    }
}
