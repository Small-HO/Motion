package com.shaoyuan.model.healthdataBean;

import java.util.List;

/**
 * Created by gzl on 2019/7/30 8:59
 * title：获取所有食物信息
 */
public class SaveAllFoodBean {

    /**
     * repcode : 00
     * repmsg : 获取成功
     * getdata : [{"foodname":"黄油","foodheat":"8.92"},{"foodname":"奶油","foodheat":"7.20"},{"foodname":"黄油渣","foodheat":"5.99"},{"foodname":"母乳化牛奶粉","foodheat":"5.10"},{"foodname":"羊奶粉","foodheat":"4.98"},{"foodname":"牛奶粉","foodheat":"4.84"},{"foodname":"奶片","foodheat":"4.72"},{"foodname":"奶皮子","foodheat":"4.60"},{"foodname":"婴儿牛奶粉","foodheat":"4.43"},{"foodname":"奶疙瘩","foodheat":"4.26"},{"foodname":"冰淇淋粉","foodheat":"3.96"},{"foodname":"脱脂奶豆腐","foodheat":"3.43"},{"foodname":"炼乳","foodheat":"3.32"},{"foodname":"奶酪","foodheat":"3.28"},{"foodname":"鲜奶豆腐","foodheat":"3.05"},{"foodname":"酸奶","foodheat":"0.72"},{"foodname":"果料酸奶","foodheat":"0.67"},{"foodname":"母乳","foodheat":"0.65"},{"foodname":"酸奶","foodheat":"0.64"},{"foodname":"羊奶","foodheat":"0.59"},{"foodname":"脱脂酸奶","foodheat":"0.57"},{"foodname":"牛奶","foodheat":"0.54"},{"foodname":"果味奶","foodheat":"0.20"}]
     * method : getuserchoicefood
     */

    private String repcode;
    private String repmsg;
    private String method;
    private List<GetdataBean> getdata;

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
         * foodname : 黄油
         * foodheat : 8.92
         */

        private String foodname;
        private String foodheat;

        public String getFoodname() {
            return foodname;
        }

        public void setFoodname(String foodname) {
            this.foodname = foodname;
        }

        public String getFoodheat() {
            return foodheat;
        }

        public void setFoodheat(String foodheat) {
            this.foodheat = foodheat;
        }
    }
}
