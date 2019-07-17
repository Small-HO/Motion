package com.shaoyuan.model.dataModel;

import com.shaoyuan.model.BaseModel;

import java.io.Serializable;

/**
 * Created by small-ho on 2019/7/16 15:21
 * title：用户基本信息模型
 */
public class UserInfoModel extends BaseModel implements Serializable {

    private String name;            //  昵称
    private String nation;          //  民族
    private String sex;             //  性别
    private String birthdate;       //  出生日期
    private String censusregister;  //  户籍详细地址
    private String education;       //  学历
    private String address;         //  现住地址
    private String province;        //  省
    private String city;            //  市
    private String area;            //  地区
    private String registration1;   //  是否有就业创业登记证
    private String registrationno;  //  就业创业登记证号
    private String registration2;   //  是否领取过失业保险金
    private String registration3;   //  今年是否享受过免费培训
    private String nickname;        //  昵称
    private String height;          //  身高
    private String weight;          //  体重
    private String headpic;         //  图片

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
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

    public String getCensusregister() {
        return censusregister;
    }

    public void setCensusregister(String censusregister) {
        this.censusregister = censusregister;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getRegistration1() {
        return registration1;
    }

    public void setRegistration1(String registration1) {
        this.registration1 = registration1;
    }

    public String getRegistrationno() {
        return registrationno;
    }

    public void setRegistrationno(String registrationno) {
        this.registrationno = registrationno;
    }

    public String getRegistration2() {
        return registration2;
    }

    public void setRegistration2(String registration2) {
        this.registration2 = registration2;
    }

    public String getRegistration3() {
        return registration3;
    }

    public void setRegistration3(String registration3) {
        this.registration3 = registration3;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public String getHeadpic() {
        return headpic;
    }

    public void setHeadpic(String headpic) {
        this.headpic = headpic;
    }
}
