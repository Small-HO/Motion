package com.shaoyuan.motion.ui.view.sitepopwindow;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.shaoyuan.core.Interfaces.SiteInterface;
import com.shaoyuan.core.persenter.SitePresenter;
import com.shaoyuan.model.dierbanBean.JudgeCoactBean;
import com.shaoyuan.model.dierbanBean.SiteBean;
import com.shaoyuan.model.dierbanBean.SiteScreenBean;
import com.shaoyuan.motion.R;
import com.shaoyuan.motion.adapter.AreaPopAdapter;
import com.shaoyuan.motion.adapter.FunctionPopAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by gzl on 2019/8/1 10:09
 * title：区域筛选框
 */

public class AreaPopupWindow extends ZPopupWindow implements ZPopupWindow.OnDismissListener, SiteInterface.view {

    private RecyclerView rec_user_screen;
    private AreaPopAdapter areaPopAdapter;
    private SitePresenter presenter;
    private int raw_index=-1;
    private boolean isShow;

    Context context;
    private String pertype;

    private TextView tv_pop_dui;
    private TextView tv_pop_xian;

    public AreaPopupWindow(Context context) {
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
        return inflate;
    }

    @Override
    public Context getContext() {
        return context;
    }

    @Override
    public void initView() {
        presenter=new SitePresenter(this);
        presenter.submit();
    }

    @Override
    public void initData() {

    }

    @Override
    public void initSiteScreen(SiteScreenBean siteScreenBean) {
        if(pertype.equals("1")){
       List<String> area = siteScreenBean.getArea();
       List<SiteScreenBean> list=new ArrayList<>();
        for (int i = 0; i < area.size(); i++) {
            SiteScreenBean siteScreenBean1=new SiteScreenBean();
            siteScreenBean1.setArea(area);
            list.add(siteScreenBean1);
        }
       areaPopAdapter = new AreaPopAdapter(context,list);
       GridLayoutManager gridLayoutManager=new GridLayoutManager(context,2);
       rec_user_screen.setLayoutManager(gridLayoutManager);
       rec_user_screen.setAdapter(areaPopAdapter);
       areaPopAdapter.setOnItemClickListener(new AreaPopAdapter.OnItemClickListener() {
           @Override
           public void onItemClick(int position, View view) {
               raw_index=position;
               TextView tv_pop_xian = view.findViewById(R.id.tv_pop_xian);
               TextView tv_pop_dui = view.findViewById(R.id.tv_pop_dui);
               if(raw_index==position){
                   tv_pop_xian.setVisibility(View.VISIBLE);
                   tv_pop_dui.setVisibility(View.VISIBLE);
               }else{
                   tv_pop_xian.setVisibility(View.GONE);
                   tv_pop_dui.setVisibility(View.GONE);
               }
           }
       });
        }else if(pertype.equals("0")){
            List<String> function = siteScreenBean.getFunction();
            List<SiteScreenBean> list=new ArrayList<>();
            for (int i = 0; i < function.size(); i++) {
                SiteScreenBean siteScreenBean1=new SiteScreenBean();
                siteScreenBean1.setFunction(function);
                list.add(siteScreenBean1);
            }
            FunctionPopAdapter functionPopAdapter=new FunctionPopAdapter(context,list);
            GridLayoutManager gridLayoutManager=new GridLayoutManager(context,2);
            rec_user_screen.setLayoutManager(gridLayoutManager);
            rec_user_screen.setAdapter(functionPopAdapter);
            functionPopAdapter.setOnItemClickListener(new FunctionPopAdapter.OnItemClickListener() {

                @Override
                public void onItemClick(int position, View view) {
                    raw_index=position;
                    functionPopAdapter.notifyDataSetChanged();
                    tv_pop_xian = view.findViewById(R.id.tv_pop_xian);
                    tv_pop_dui = view.findViewById(R.id.tv_pop_dui);
                    if(raw_index==position){
                        tv_pop_xian.setVisibility(View.VISIBLE);
                        tv_pop_dui.setVisibility(View.VISIBLE);
                    }else{
                        tv_pop_xian.setVisibility(View.GONE);
                        tv_pop_dui.setVisibility(View.GONE);
                    }

                    //isShow();
                }
            });
        }
    }

    private void isShow(){
        if(isShow){
            tv_pop_xian.setVisibility(View.VISIBLE);
            tv_pop_dui.setVisibility(View.VISIBLE);
            isShow=false;
        }else{
            tv_pop_xian.setVisibility(View.GONE);
            tv_pop_dui.setVisibility(View.GONE);
            isShow=true;
        }
    }

    @Override
    public void showLog(String log) {

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
}
