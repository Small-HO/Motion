package com.shaoyuan.core.persenter;

import android.content.Context;

import com.shaoyuan.core.Interfaces.HomeInterface;
import com.shaoyuan.core.action.AppAction;
import com.shaoyuan.core.actionImpl.AppActionImpl;
import com.shaoyuan.model.dataModel.BannerModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by small-ho on 2019/7/10 12:12
 * title：首页核心逻辑
 */
public class HomePresenter implements HomeInterface.presenter {

    private HomeInterface.view view;
    private Context context;
    private AppAction action;

    public HomePresenter(HomeInterface.view view, Context context) {
        this.view = view;
        this.context = context;
        action = new AppActionImpl(context);
    }

    @Override
    public List<BannerModel> initBannerData() {
        //  此处获取到请求的数据返回ui层即可
        List<BannerModel> list = new ArrayList<>();
        BannerModel model = new BannerModel();
        model.setUrl("http://192.168.1.166:8889/img/physical/自行车.png");
        list.add(model);
        return list;
    }
}
