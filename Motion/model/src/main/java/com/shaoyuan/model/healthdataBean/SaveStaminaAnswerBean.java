package com.shaoyuan.model.healthdataBean;

import java.util.List;

/**
 * Created by gzl on 2019/7/30 9:44
 * title：获取体能问卷问题和答案
 */
public class SaveStaminaAnswerBean {

    /**
     * repcode : 00
     * repmsg : 获取问题成功
     * sportquestionlis : [{"questid":"2","qucontent":"深蹲可以完成多少次？（蹲至大腿与地面平行）","questtiontype":"0","remind":"腰背保持直线，髋关节低于膝关节。不正确的技术动作反而会使膝关节受损","answerlist":[{"answerid":"1","ancontent":"没试过，或达不到11次"},{"answerid":"2","ancontent":"只能蹲11-22次，感觉很吃力"},{"answerid":"3","ancontent":"偶尔自己会练，坚持做23-30次没问题"},{"answerid":"4","ancontent":"经常练，做31-38次没有问题"},{"answerid":"5","ancontent":"很轻松，做39次以上不在话下"}]}]
     * method : getsportquestionlist
     */

    private String repcode;
    private String repmsg;
    private String method;
    private List<SportquestionlisBean> sportquestionlis;

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

    public List<SportquestionlisBean> getSportquestionlis() {
        return sportquestionlis;
    }

    public void setSportquestionlis(List<SportquestionlisBean> sportquestionlis) {
        this.sportquestionlis = sportquestionlis;
    }

    public static class SportquestionlisBean {
        /**
         * questid : 2
         * qucontent : 深蹲可以完成多少次？（蹲至大腿与地面平行）
         * questtiontype : 0
         * remind : 腰背保持直线，髋关节低于膝关节。不正确的技术动作反而会使膝关节受损
         * answerlist : [{"answerid":"1","ancontent":"没试过，或达不到11次"},{"answerid":"2","ancontent":"只能蹲11-22次，感觉很吃力"},{"answerid":"3","ancontent":"偶尔自己会练，坚持做23-30次没问题"},{"answerid":"4","ancontent":"经常练，做31-38次没有问题"},{"answerid":"5","ancontent":"很轻松，做39次以上不在话下"}]
         */

        private String questid;
        private String qucontent;
        private String questtiontype;
        private String remind;
        private List<AnswerlistBean> answerlist;

        public String getQuestid() {
            return questid;
        }

        public void setQuestid(String questid) {
            this.questid = questid;
        }

        public String getQucontent() {
            return qucontent;
        }

        public void setQucontent(String qucontent) {
            this.qucontent = qucontent;
        }

        public String getQuesttiontype() {
            return questtiontype;
        }

        public void setQuesttiontype(String questtiontype) {
            this.questtiontype = questtiontype;
        }

        public String getRemind() {
            return remind;
        }

        public void setRemind(String remind) {
            this.remind = remind;
        }

        public List<AnswerlistBean> getAnswerlist() {
            return answerlist;
        }

        public void setAnswerlist(List<AnswerlistBean> answerlist) {
            this.answerlist = answerlist;
        }

        public static class AnswerlistBean {
            /**
             * answerid : 1
             * ancontent : 没试过，或达不到11次
             */

            private String answerid;
            private String ancontent;

            public String getAnswerid() {
                return answerid;
            }

            public void setAnswerid(String answerid) {
                this.answerid = answerid;
            }

            public String getAncontent() {
                return ancontent;
            }

            public void setAncontent(String ancontent) {
                this.ancontent = ancontent;
            }
        }
    }
}
