package com.shaoyuan.model.dataModel;

import com.shaoyuan.model.BaseModel;
import com.shaoyuan.model.dataInfo.DataReportInfo;

import java.util.List;

/**
 * Created by small-ho on 2019/7/20 10:29
 * title：报告分析数据数据模型
 */
public class DataReportModel extends BaseModel {
    private List<DataReportInfo> getdata;
    private String countres;
    private String weight;
    private String countrew;

    public String getCountrew() {
        return countrew;
    }

    public void setCountrew(String countrew) {
        this.countrew = countrew;
    }

    public List<DataReportInfo> getGetdata() {
        return getdata;
    }

    public void setGetdata(List<DataReportInfo> getdata) {
        this.getdata = getdata;
    }

    public String getCountres() {
        return countres;
    }

    public void setCountres(String countres) {
        this.countres = countres;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
