package com.shaoyuan.model.dataInfo;

import java.io.Serializable;

/**
 * Created by small-ho on 2019/7/23 18:02
 * title：添加工作部分数据
 */
public class WorkInfo implements Serializable {
    private String typenamee;
    private String typeidd;
    private String phy;
    private String mets;
    private String str1;
    private String str2;
    private String str3;

    public WorkInfo(String typenamee) {
        this.typenamee = typenamee;
    }

    public WorkInfo() {
    }

    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }

    public String getStr2() {
        return str2;
    }

    public void setStr2(String str2) {
        this.str2 = str2;
    }

    public String getStr3() {
        return str3;
    }

    public void setStr3(String str3) {
        this.str3 = str3;
    }

    public String getPhy() {
        return phy;
    }

    public void setPhy(String phy) {
        this.phy = phy;
    }

    public String getMets() {
        return mets;
    }

    public void setMets(String mets) {
        this.mets = mets;
    }

    public String getTypenamee() {
        return typenamee;
    }

    public void setTypenamee(String typenamee) {
        this.typenamee = typenamee;
    }

    public String getTypeidd() {
        return typeidd;
    }

    public void setTypeidd(String typeidd) {
        this.typeidd = typeidd;
    }

}
