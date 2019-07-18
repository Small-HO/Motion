package com.shaoyuan.core.Interfaces;

import android.content.Context;

/**
 * Created by small-ho on 2019/7/15 9:27
 * title：我的页面Fragment接口
 */
public interface MineInterface {
    interface view {
        Context getContext();

        void toHeaderPage();
        void toOrderPage();
        void toUserPage();
        void toSecurePage();
        void toQuestions();
        void toSuggestion();
    }
}
