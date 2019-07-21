package com.shaoyuan.model.dataModel;

import com.shaoyuan.model.BaseModel;

/**
 * Created by small-ho on 2019/7/19 13:51
 * title：消耗摄入数据模型
 */
public class CountcontodayModel extends BaseModel {
    private String congetdata;
    private String intakegetdata;

    public String getCongetdata() {
        return congetdata;
    }

    public void setCongetdata(String congetdata) {
        this.congetdata = congetdata;
    }

    public String getIntakegetdata() {
        return intakegetdata;
    }

    public void setIntakegetdata(String intakegetdata) {
        this.intakegetdata = intakegetdata;
    }
}
