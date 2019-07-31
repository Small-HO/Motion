package com.shaoyuan.model.dataInfo;

import com.shaoyuan.model.bean.SelectBean;

import java.io.Serializable;

/**
 * Created by small-ho on 2019/7/29 16:07
 * title：选择体检项目
 */
public class IllnessInfo extends SelectBean implements Serializable{

    private String item;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
