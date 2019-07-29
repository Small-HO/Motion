package com.shaoyuan.model.dataInfo;

import java.io.Serializable;

/**
 * Created by small-ho on 2019/7/29 16:07
 * title：选择体检项目
 */
public class IllnessInfo implements Serializable {

    private String item;
    private boolean select = false;

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
