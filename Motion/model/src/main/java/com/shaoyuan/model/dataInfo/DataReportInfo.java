package com.shaoyuan.model.dataInfo;

import java.io.Serializable;

/**
 * Created by small-ho on 2019/7/20 10:28
 * title：报告分析数据
 */
public class DataReportInfo implements Serializable {
    private String contype;
    private String conmany;
    private String contime;
    private String tmtype;
    private String foodh;

    public String getTmtype() {
        return tmtype;
    }

    public void setTmtype(String tmtype) {
        this.tmtype = tmtype;
    }

    public String getFoodh() {
        return foodh;
    }

    public void setFoodh(String foodh) {
        this.foodh = foodh;
    }

    public String getContype() {
        return contype;
    }

    public void setContype(String contype) {
        this.contype = contype;
    }

    public String getConmany() {
        return conmany;
    }

    public void setConmany(String conmany) {
        this.conmany = conmany;
    }

    public String getContime() {
        return contime;
    }

    public void setContime(String contime) {
        this.contime = contime;
    }
}
