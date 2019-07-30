package com.shaoyuan.model.healthdataBean;

import java.util.List;

/**
 * Created by gzl on 2019/7/30 9:43
 * title：上传体能问卷答案
 */
public class UploadingStaminaAnswerBean {

    /**
     * method : upsportquestion
     * userid : 1560944640393621922
     * ancounttype : 1
     * questionlist : [{"answerlist":[{"answerid":"2","select":false}],"questid":"2"}]
     * difference :
     * datatype : 1
     */

    private String method;
    private String userid;
    private String ancounttype;
    private String difference;
    private String datatype;
    private List<QuestionlistBean> questionlist;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getAncounttype() {
        return ancounttype;
    }

    public void setAncounttype(String ancounttype) {
        this.ancounttype = ancounttype;
    }

    public String getDifference() {
        return difference;
    }

    public void setDifference(String difference) {
        this.difference = difference;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public List<QuestionlistBean> getQuestionlist() {
        return questionlist;
    }

    public void setQuestionlist(List<QuestionlistBean> questionlist) {
        this.questionlist = questionlist;
    }

    public static class QuestionlistBean {
        /**
         * answerlist : [{"answerid":"2","select":false}]
         * questid : 2
         */

        private String questid;
        private List<AnswerlistBean> answerlist;

        public String getQuestid() {
            return questid;
        }

        public void setQuestid(String questid) {
            this.questid = questid;
        }

        public List<AnswerlistBean> getAnswerlist() {
            return answerlist;
        }

        public void setAnswerlist(List<AnswerlistBean> answerlist) {
            this.answerlist = answerlist;
        }

        public static class AnswerlistBean {
            /**
             * answerid : 2
             * select : false
             */

            private String answerid;
            private boolean select;

            public String getAnswerid() {
                return answerid;
            }

            public void setAnswerid(String answerid) {
                this.answerid = answerid;
            }

            public boolean isSelect() {
                return select;
            }

            public void setSelect(boolean select) {
                this.select = select;
            }
        }
    }
}
