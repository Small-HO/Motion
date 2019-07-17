package com.shaoyuan.core.Interfaces;

import android.content.Context;

/**
 * Created by small-ho on 2019/7/17 16:33
 * title：修改密码核心接口类
 */
public interface SecureInterface {
    interface view {
        Context getContext();

        void initView();

        String getOldPwd();
        String getNewPwd();
        String getRetype();
    }
    interface presenter {
        void updatePas();
    }
}
