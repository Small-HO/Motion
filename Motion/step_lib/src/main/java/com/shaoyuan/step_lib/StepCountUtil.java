package com.shaoyuan.step_lib;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.widget.Toast;

import static android.content.Context.SENSOR_SERVICE;

/**
 * Created by small-ho on 2019/7/27 10:53
 * title：计步器
 * TYPE_STEP_COUNTER：计步器（记录历史步数累加值）
 * TYPE_STEP_DETECTOR：检测器（检测每次步伐数据）
 */
@TargetApi(Build.VERSION_CODES.KITKAT)
public class StepCountUtil implements StepInterface.function,SensorEventListener {

    private Context context;
    private SensorManager manager;  //  传感器管理者
    private int mDetector = 0;      //  一次有效的计步

    private StepInterface.callback callback;  //  数据回调

    public StepCountUtil(Context mContext) {
        this.context = mContext;
    }

    public void stepCallback(StepInterface.callback callback) {
        this.callback = callback;
    }

    /** 检测是否支持计步 */
    @Override
    public boolean checkStepService() {
        SensorManager sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        Sensor detectorSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
        return countSensor != null || detectorSensor != null;
    }

    /** 开启计步 */
    @Override
    public void startStep() {
        manager = (SensorManager) context.getSystemService(SENSOR_SERVICE);
        //  单次有效计步
        Sensor mStepCount = manager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        //  系统计步累加值
        Sensor mStepDetector = manager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);

        if (Build.VERSION.SDK_INT >= 19) {
            manager.registerListener(this, mStepCount,SensorManager.SENSOR_DELAY_FASTEST);
            manager.registerListener(this, mStepDetector,SensorManager.SENSOR_DELAY_FASTEST);
        }else {
            Toast.makeText(context,"该手机不支持计步",Toast.LENGTH_SHORT).show();
        }
    }

    /** 结束计步 */
    @Override
    public void startStop() {
        mDetector = 0;                          //  清空单次计步
        callback.sensorStepSingle(mDetector);
        manager.unregisterListener(this);
    }

    /** 获取传感器计步数值 */
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
            //  计步历史累加值
            float steps = event.values[0];
            //  总步数监听回调
            callback.sensorStepTotal((int) steps);
        }

        if (event.sensor.getType() == Sensor.TYPE_STEP_DETECTOR || event.values[0] == 1.0) {
            //  一次有效的计步
            mDetector ++;
            //  单次步数监听回调
            callback.sensorStepSingle(mDetector);
//
//            count.setSteps(mDetector);
//            count.initLisener(new StepValuePassListener() {
//                @Override
//                public void stepChanged(int steps) {
//                    callback.sensorStepCount(steps);
//                }
//            });
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
