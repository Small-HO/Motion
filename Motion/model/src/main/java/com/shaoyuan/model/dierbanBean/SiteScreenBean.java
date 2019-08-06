package com.shaoyuan.model.dierbanBean;

import java.util.List;

/**
 * Created by gzl on 2019/8/1 14:58
 * title：场地预约筛选
 */
public class SiteScreenBean {

    /**
     * method : venuescreen
     * repcode : 00
     * repmsg : 查询成功
     * area : ["裕华区","长安区","桥西区"]
     * classify : ["游泳馆","私教室"]
     * price : ["从低到高","从高到低"]
     * dissort : ["从近到远","从远到近"]
     * function : ["游泳馆","私教室"]
     * equipment : ["瑜伽垫","健身球"]
     * usearea : ["0-100m²","100-200m²","200-300m²","300-400m²","400-500m²","500m²以上"]
     */

    private String method;
    private String repcode;
    private String repmsg;
    private List<String> area;
    private List<String> classify;
    private List<String> price;
    private List<String> dissort;
    private List<String> function;
    private List<String> equipment;
    private List<String> usearea;

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

    public List<String> getArea() {
        return area;
    }

    public void setArea(List<String> area) {
        this.area = area;
    }

    public List<String> getClassify() {
        return classify;
    }

    public void setClassify(List<String> classify) {
        this.classify = classify;
    }

    public List<String> getPrice() {
        return price;
    }

    public void setPrice(List<String> price) {
        this.price = price;
    }

    public List<String> getDissort() {
        return dissort;
    }

    public void setDissort(List<String> dissort) {
        this.dissort = dissort;
    }

    public List<String> getFunction() {
        return function;
    }

    public void setFunction(List<String> function) {
        this.function = function;
    }

    public List<String> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<String> equipment) {
        this.equipment = equipment;
    }

    public List<String> getUsearea() {
        return usearea;
    }

    public void setUsearea(List<String> usearea) {
        this.usearea = usearea;
    }
}
