package com.shaoyuan.aspectj.statistics;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by small-ho on 2019/7/4 10:48
 * title：用户操作数据统计
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Statistics {
    Function function();
}
