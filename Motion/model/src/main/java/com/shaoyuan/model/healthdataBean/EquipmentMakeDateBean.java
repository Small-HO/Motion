package com.shaoyuan.model.healthdataBean;

import java.util.Date;
import java.util.List;

/**
 * Created by gzl on 2019/7/30 17:29
 * title：器材可预约时间段
 */
public class EquipmentMakeDateBean {

    private List<Date> times;
    private String method;
    public void setTimes(List<Date> times) {
        this.times = times;
    }
    public List<Date> getTimes() {
        return times;
    }

    public void setMethod(String method) {
        this.method = method;
    }
    public String getMethod() {
        return method;
    }
}
