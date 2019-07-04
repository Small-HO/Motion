package com.shaoyuan.aspectj.Interface;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by small-ho on 2019/7/3 17:02
 * title：利用注解来切点标识方法，作用在运行期
 */
@SuppressWarnings("CheckStyle")
@Target(ElementType.METHOD)  //  可以注解在方法上
@Retention(RetentionPolicy.RUNTIME) //  运行时存在
public @interface LoginIntercept {
    int actionDefine() default 0;
}
