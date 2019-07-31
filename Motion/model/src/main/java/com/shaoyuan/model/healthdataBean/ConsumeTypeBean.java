package com.shaoyuan.model.healthdataBean;

import java.util.List;

/**
 * Created by gzl on 2019/7/30 8:34
 * title：返回具体消耗类型信息
 */
public class ConsumeTypeBean {


    /**
     * getdata : [{"phy":"慢跑：一般","mets":"7.0"},{"phy":"慢跑：场地跑","mets":"8.0"}]
     * age : 25
     * height : 185
     * weight : 135
     * sex : 男
     * repcode : 00
     * repmsg : 获取成功
     * method : getallconinfo
     */

    private int age;
    private String height;
    private String weight;
    private String sex;
    private String repcode;
    private String repmsg;
    private String method;
    private List<GetdataBean> getdata;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRepcode() {
        return repcode;
    }

    public void setRepcode(String repcode) {
        this.repcode = repcode;
    }

    public String getRepmsg() {
        return repmsg;
    }

    public void setRepmsg(String repmsg) {
        this.repmsg = repmsg;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public List<GetdataBean> getGetdata() {
        return getdata;
    }

    public void setGetdata(List<GetdataBean> getdata) {
        this.getdata = getdata;
    }

    public static class GetdataBean {
        /**
         * phy : 慢跑：一般
         * mets : 7.0
         */

        private String phy;
        private String mets;

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
    }
}
