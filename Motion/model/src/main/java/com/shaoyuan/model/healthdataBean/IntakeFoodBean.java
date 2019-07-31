package com.shaoyuan.model.healthdataBean;

import java.util.List;

/**
 * Created by gzl on 2019/7/30 8:37
 * title：用户查看当天食物摄入信息
 */
public class IntakeFoodBean {


    /**
     * jianyi : 1715-2216
     * intakegetdata : 271.05
     * intakeweight : 82.0
     * repcode : 00
     * repmsg : 获取成功
     * getdata : [{"mo":[{"foodid":"15643842177448425","foodname":"油炸土豆片","foodh":"250.91","foodq":"41"}],"lu":[{"foodid":"15594559777760413","foodname":"挂面","foodh":"20.14","foodq":"41"}],"di":[],"de":[]}]
     * method : getshoweatfoodlist
     */

    private String jianyi;
    private String intakegetdata;
    private String intakeweight;
    private String repcode;
    private String repmsg;
    private String method;
    private List<GetdataBean> getdata;

    public String getJianyi() {
        return jianyi;
    }

    public void setJianyi(String jianyi) {
        this.jianyi = jianyi;
    }

    public String getIntakegetdata() {
        return intakegetdata;
    }

    public void setIntakegetdata(String intakegetdata) {
        this.intakegetdata = intakegetdata;
    }

    public String getIntakeweight() {
        return intakeweight;
    }

    public void setIntakeweight(String intakeweight) {
        this.intakeweight = intakeweight;
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
        private List<MoBean> mo;
        private List<LuBean> lu;
        private List<?> di;
        private List<?> de;

        public List<MoBean> getMo() {
            return mo;
        }

        public void setMo(List<MoBean> mo) {
            this.mo = mo;
        }

        public List<LuBean> getLu() {
            return lu;
        }

        public void setLu(List<LuBean> lu) {
            this.lu = lu;
        }

        public List<?> getDi() {
            return di;
        }

        public void setDi(List<?> di) {
            this.di = di;
        }

        public List<?> getDe() {
            return de;
        }

        public void setDe(List<?> de) {
            this.de = de;
        }

        public static class MoBean {
            /**
             * foodid : 15643842177448425
             * foodname : 油炸土豆片
             * foodh : 250.91
             * foodq : 41
             */

            private String foodid;
            private String foodname;
            private String foodh;
            private String foodq;

            public String getFoodid() {
                return foodid;
            }

            public void setFoodid(String foodid) {
                this.foodid = foodid;
            }

            public String getFoodname() {
                return foodname;
            }

            public void setFoodname(String foodname) {
                this.foodname = foodname;
            }

            public String getFoodh() {
                return foodh;
            }

            public void setFoodh(String foodh) {
                this.foodh = foodh;
            }

            public String getFoodq() {
                return foodq;
            }

            public void setFoodq(String foodq) {
                this.foodq = foodq;
            }
        }

        public static class LuBean {
            /**
             * foodid : 15594559777760413
             * foodname : 挂面
             * foodh : 20.14
             * foodq : 41
             */

            private String foodid;
            private String foodname;
            private String foodh;
            private String foodq;

            public String getFoodid() {
                return foodid;
            }

            public void setFoodid(String foodid) {
                this.foodid = foodid;
            }

            public String getFoodname() {
                return foodname;
            }

            public void setFoodname(String foodname) {
                this.foodname = foodname;
            }

            public String getFoodh() {
                return foodh;
            }

            public void setFoodh(String foodh) {
                this.foodh = foodh;
            }

            public String getFoodq() {
                return foodq;
            }

            public void setFoodq(String foodq) {
                this.foodq = foodq;
            }
        }
    }
}
