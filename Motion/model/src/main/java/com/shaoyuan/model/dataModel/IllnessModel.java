package com.shaoyuan.model.dataModel;

import com.shaoyuan.model.dataInfo.IllnessInfo;

import java.util.List;

/**
 * Created by small-ho on 2019/7/29 16:07
 * title：选择体检项目数据模型
 */
public class IllnessModel {

    private List<IllnessInfo> list;

    public List<IllnessInfo> getList() {
        return list;
    }

    public void setList(List<IllnessInfo> list) {
        this.list = list;
    }
}
