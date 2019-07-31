package com.shaoyuan.model.healthdataBean;

import java.util.List;

/**
 * Created by gzl on 2019/7/30 8:40
 * title：返回消耗类型让用户选择
 */
public class SelectConsumeTypeBean {


    /**
     * getdata : [{"typenamee":"推荐选项","typeidd":"0100"},{"typenamee":"自行车","typeidd":"0101"},{"typenamee":"跑步","typeidd":"0102"},{"typenamee":"爬山越野","typeidd":"0103"},{"typenamee":"运动步行","typeidd":"0104"},{"typenamee":"体感游戏","typeidd":"0105"},{"typenamee":"功率车","typeidd":"0106"},{"typenamee":"划船机","typeidd":"0107"},{"typenamee":"韵律运动","typeidd":"0108"},{"typenamee":"循环训练","typeidd":"0109"},{"typenamee":"椭圆机","typeidd":"0110"},{"typenamee":"阻抗训练","typeidd":"0111"},{"typenamee":"健身房综合训练","typeidd":"0112"},{"typenamee":"其他器械健身","typeidd":"0113"},{"typenamee":"家庭及视频健身","typeidd":"0114"},{"typenamee":"拉伸、瑜伽、普拉提","typeidd":"0115"}]
     * repcode : 00
     * repmsg : 获取成功
     * method : getuserchoiceconsameday
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
         * typenamee : 推荐选项
         * typeidd : 0100
         */

        private String typenamee;
        private String typeidd;

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
}
