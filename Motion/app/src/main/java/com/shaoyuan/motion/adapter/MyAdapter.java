package com.shaoyuan.motion.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by small-ho on 2019/7/19 14:52
 * title：viewpager适配
 */
public class MyAdapter extends FragmentPagerAdapter {

    private Fragment[] fragments;
    private String[] titles;

    public MyAdapter(FragmentManager fm, Fragment[] fragments, String[] titles) {
        super(fm);
        this.fragments = fragments;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments == null ? 0 : fragments.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
