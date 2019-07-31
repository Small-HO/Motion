package com.shaoyuan.model.dataModel;

import com.shaoyuan.model.BaseModel;
import com.shaoyuan.model.dataInfo.WorkInfo;

import java.util.List;

/**
 * Created by small-ho on 2019/7/23 18:03
 * title：添加工作数据模型
 */
public class WorkModel extends BaseModel {
    private List<WorkInfo> getdata;
    private String height;
    private String weight;
    private String age;
    private String sex;

    public List<WorkInfo> getGetdata() {
        return getdata;
    }

    public void setGetdata(List<WorkInfo> getdata) {
        this.getdata = getdata;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
