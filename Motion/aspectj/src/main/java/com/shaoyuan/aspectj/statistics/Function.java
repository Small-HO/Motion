package com.shaoyuan.aspectj.statistics;

/**
 * Created by small-ho on 2019/7/4 10:54
 * title：埋点用户操作（如：登录、注册）
 */
public enum Function {
    LOGIN(1, "登陆"),
    REGISTER(2, "注册");

    int functionId;
    String functionName;

    Function(int functionId, String functionName) {
        this.functionId = functionId;
        this.functionName = functionName;
    }

    public String getFunctionName() {
        return functionName;
    }
}
