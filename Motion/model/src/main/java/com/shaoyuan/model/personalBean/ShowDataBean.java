package com.shaoyuan.model.personalBean;

/**
 * Created by gzl on 2019/7/29 14:45
 * title：获取个人资料
 */
public class ShowDataBean {

    /**
     * method : getuserinfo
     * repcode : 00
     * repmsg : 响应码说明
     * headpic : http://192.168.1.168:8889/asssd.jpeg
     * nickname : 小明
     * sex : 男
     * birthdate : 2019-06-30
     * height : 185
     * weight : 120
     */

    private String method;
    private String repcode;
    private String repmsg;
    private String headpic;
    private String nickname;
    private String sex;
    private String birthdate;
    private String height;
    private String weight;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
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

    public String getHeadpic() {
        return headpic;
    }

    public void setHeadpic(String headpic) {
        this.headpic = headpic;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
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
}
