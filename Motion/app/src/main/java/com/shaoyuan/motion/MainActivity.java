package com.shaoyuan.motion;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.shaoyuan.motion.ui.fragment.DataFragment;
import com.shaoyuan.motion.ui.fragment.HomeFragment;
import com.shaoyuan.motion.ui.fragment.MineFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addFragment(savedInstanceState);
    }

    private void addFragment(Bundle savedInstanceState) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        if (savedInstanceState == null) {
            fragments.add(new HomeFragment());
            fragments.add(new DataFragment());
            fragments.add(new MineFragment());

            int index = 0;
            for (Fragment f :fragments) {
                transaction.add(R.id.fragment,f,"tag" + index);
                transaction.hide(f);
                index ++;
            }
            transaction.show(fragments.get(0));
            transaction.commit();
        }else {
            for (int i = 0; i < 3; i++) {
                String tag = "tag" + i;
                Fragment f = manager.findFragmentByTag(tag);
                if (f != null) {
                    fragments.add(f);
                }
            }
        }
    }

    @OnClick({R.id.tb_tb_home,R.id.tb_tv_data,R.id.tb_tv_mine})
    public void onClick(View view) {
        int index = 0;
        switch (view.getId()) {
            case R.id.tb_tb_home:
                index = 0;
                break;
            case R.id.tb_tv_data:
                index = 1;
                break;
            case R.id.tb_tv_mine:
                index = 2;
                break;
        }
        switchFragment(index);
    }

    private void switchFragment(int index) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        if (index >= 0 && index < fragments.size()) {
            int size = fragments.size();
            for (int i = 0; i < size; i++) {
                Fragment fragment = fragments.get(i);
                if (i == index){
                    transaction.show(fragment);
                }else {
                    transaction.hide(fragment);
                }
            }
            transaction.commit();
        }
    }

    @Override
    protected int getLayoutId() {
        setTheme(R.style.AppTheme);
        return R.layout.activity_main;
    }

}
