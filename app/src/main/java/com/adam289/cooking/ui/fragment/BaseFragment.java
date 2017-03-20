package com.adam289.cooking.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adam289.cooking.presenter.Presenter;

import butterknife.ButterKnife;

/**
 * Created by temp on 2017/3/20.
 */

public abstract class BaseFragment extends Fragment {
    protected Presenter presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(getLayoutId(),container,false);
        ButterKnife.bind(this,view);
        initView(inflater,container,savedInstanceState);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(presenter==null&&getPresenter()!=null){
            presenter = getPresenter();
        }
    }

    protected abstract Presenter getPresenter();

    protected abstract void initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    protected abstract int getLayoutId();
}
