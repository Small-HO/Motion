package com.shaoyuan.model.dataInfo;

/**
 * Created by small-ho on 2019/7/15 10:17
 * title：订单列表数据模型
 */
public class OrderInfo {
    private String temstype;
    private String setmealprice;
    private boolean paystate;
    private String creattime;
    private String mechname;

    public String getTemstype() {
        return temstype;
    }

    public void setTemstype(String temstype) {
        this.temstype = temstype;
    }

    public String getSetmealprice() {
        return setmealprice;
    }

    public void setSetmealprice(String setmealprice) {
        this.setmealprice = setmealprice;
    }

    public boolean isPaystate() {
        return paystate;
    }

    public void setPaystate(boolean paystate) {
        this.paystate = paystate;
    }

    public String getCreattime() {
        return creattime;
    }

    public void setCreattime(String creattime) {
        this.creattime = creattime;
    }

    public String getMechname() {
        return mechname;
    }

    public void setMechname(String mechname) {
        this.mechname = mechname;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "temstype='" + temstype + '\'' +
                ", setmealprice='" + setmealprice + '\'' +
                ", paystate=" + paystate +
                ", creattime='" + creattime + '\'' +
                ", mechname='" + mechname + '\'' +
                '}';
    }
}
