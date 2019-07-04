package com.shaoyuan.aspectj.aspect;

import android.util.Log;

import com.shaoyuan.aspectj.statistics.Statistics;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by small-ho on 2019/7/4 10:59
 * title：用户操作埋点相关的Aspectj的实现类（结合实际情况对该类进行修改）
 * 使用：在需要统计的方法上@Statistics(function = Function.LOGIN)或者@Statistics(function = Function.REGISTER)
 */
@Aspect
public class StatisticsInstrumentation {
    public static final String TAG = "Statistics";
    @Around("execution(@com.shaoyuan.aspectj.login.Statistics * *(..)) && @annotation(statistics)")
    public void aroundJoinPoint(ProceedingJoinPoint joinPoint, Statistics statistics) throws Throwable {
        calculate(statistics);
        joinPoint.proceed();//执行原方法
    }

    private void calculate(Statistics statistics) {
        if (statistics != null) {
            Log.e(TAG, "对" + statistics.function().getFunctionName() + "进行统计");
            // select * from FunctionsTable where operatorId=statistics.getFunctionId()
            //if(size > 0){
            // int counts = operateCounts ++
            // update FunctionsTable set operateCounts = counts
            // }else {
            // insert into FunctionsTable values (xxx, statistics.getFunctionId(), 1)
            // }
        }
    }
}
