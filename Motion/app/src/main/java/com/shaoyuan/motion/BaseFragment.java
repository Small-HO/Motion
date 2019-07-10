package com.shaoyuan.motion;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shaoyuan.core.utils.MyToast;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by small-ho on 2019/7/10 14:50
 * title：Fragment基类
 */
public abstract class BaseFragment extends Fragment {
    private Unbinder unbinder;
    protected Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(),container,false);
        unbinder = ButterKnife.bind(this,view);
        context = getActivity();
        initFragmentData(savedInstanceState);
        return view;
    }

    public void showToast(String msg) {
        MyToast.showToast(context,msg);
    }

    public abstract int getLayoutId();
    public abstract void initFragmentData(Bundle savedInstanceState);

    @Override
    public void onDestroy() {
        if (unbinder != null) {
            unbinder.unbind();
        }
        super.onDestroy();
    }
}
