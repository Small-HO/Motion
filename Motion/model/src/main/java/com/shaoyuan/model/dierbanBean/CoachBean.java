package com.shaoyuan.model.dierbanBean;

import java.util.List;

/**
 * Created by gzl on 2019/8/6 14:21
 * title：教练介绍列表
 */
public class CoachBean {

    /**
     * repcode : 00
     * repmsg : 返回成功
     * coachlist : [{"userid":"15600478631617455","name":"王老师","lowest":200,"comment":"97%","pic":"http://192.168.1.143:8889/img/1560047863129841328-D41D8CD98F00B204E9800998ECF8427E.png","lable":["健身","增肌","瑜伽"]}]
     * method : caochlist
     */

    private String repcode;
    private String repmsg;
    private String method;
    private List<CoachlistBean> coachlist;

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

    public List<CoachlistBean> getCoachlist() {
        return coachlist;
    }

    public void setCoachlist(List<CoachlistBean> coachlist) {
        this.coachlist = coachlist;
    }

    public static class CoachlistBean {
        /**
         * userid : 15600478631617455
         * name : 王老师
         * lowest : 200
         * comment : 97%
         * pic : http://192.168.1.143:8889/img/1560047863129841328-D41D8CD98F00B204E9800998ECF8427E.png
         * lable : ["健身","增肌","瑜伽"]
         */

        private String coachid;
        private String name;
        private int lowest;
        private String comment;
        private String pic;
        private List<String> lable;
        private String coursecount;

        public String getCoursecount() {
            return coursecount;
        }

        public void setCoursecount(String coursecount) {
            this.coursecount = coursecount;
        }

        public String getCoachid() {
            return coachid;
        }

        public void setCoachid(String coachid) {
            this.coachid = coachid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getLowest() {
            return lowest;
        }

        public void setLowest(int lowest) {
            this.lowest = lowest;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public List<String> getLable() {
            return lable;
        }

        public void setLable(List<String> lable) {
            this.lable = lable;
        }
    }
}
