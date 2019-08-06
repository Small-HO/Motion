package com.shaoyuan.motion.ui.view.sitepopwindow;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.shaoyuan.core.Interfaces.SiteInterface;
import com.shaoyuan.core.persenter.SitePresenter;
import com.shaoyuan.model.dierbanBean.JudgeCoactBean;
import com.shaoyuan.model.dierbanBean.SiteBean;
import com.shaoyuan.model.dierbanBean.SiteScreenBean;
import com.shaoyuan.motion.R;
import com.shaoyuan.motion.adapter.DissortPopAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gzl on 2019/8/1 10:09
 * title：距离筛选
 */
public class DistancePopupWindow extends ZPopupWindow implements ZPopupWindow.OnDismissListener, SiteInterface.view{

    private RecyclerView rec_user_screen;
    Context context;
    private SitePresenter presenter;
    private String pertype;

    public DistancePopupWindow(Context context) {
        super(context);
        this.context=context;
    }

    @Override
    public void onDismiss() {

    }

    @Override
    protected View generateCustomView(Context context) {
        this.context=context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.popwindow_user, null, false);
        rec_user_screen = inflate.findViewById(R.id.rec_user_screen);
        initView();
        initData();
        return inflate;
    }

    @Override
    public Context getContext() {
        return context;
    }

    @Override
    public void initView() {
        presenter=new SitePresenter(this);
    }

    @Override
    public void initData() {
        presenter.submit();
    }

    @Override
    public void initJudgeCoact(JudgeCoactBean judgeCoactBean) {
        pertype = judgeCoactBean.getPertype();
    }

    @Override
    public void intJudgeCoacts(JudgeCoactBean judgeCoactBean) {
        pertype = judgeCoactBean.getPertype();
    }

    @Override
    public void site(SiteBean siteBean) {

    }

    @Override
    public void initSiteScreen(SiteScreenBean siteScreenBean) {
        if(pertype.equals("1")){
            List<String> dissort = siteScreenBean.getDissort();
            List<SiteScreenBean> list=new ArrayList<>();
            for (int i = 0; i < dissort.size(); i++) {
                SiteScreenBean siteScreenBean1=new SiteScreenBean();
                siteScreenBean1.setDissort(dissort);
                list.add(siteScreenBean1);
            }
            DissortPopAdapter dissortPopAdapter=new DissortPopAdapter(context,list);
            GridLayoutManager gridLayoutManager=new GridLayoutManager(context,2);
            rec_user_screen.setLayoutManager(gridLayoutManager);
            rec_user_screen.setAdapter(dissortPopAdapter);
            dissortPopAdapter.setOnItemClickListener(new DissortPopAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(int position) {

                }
            });
        }
    }

    @Override
    public void showLog(String log) {

    }
}
