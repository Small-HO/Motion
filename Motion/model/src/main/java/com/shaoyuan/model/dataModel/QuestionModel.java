package com.shaoyuan.model.dataModel;

import com.shaoyuan.model.BaseModel;
import com.shaoyuan.model.dataInfo.QuestionInfo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by small-ho on 2019/7/18 9:08
 * title：常见问题模型类
 */
public class QuestionModel extends BaseModel implements Serializable {
    private List<QuestionInfo> infos;

    public List<QuestionInfo> getInfos() {
        return infos;
    }

    public void setInfos(List<QuestionInfo> infos) {
        this.infos = infos;
    }
}
