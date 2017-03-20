package com.adam289.cooking.ui.activity;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.adam289.cooking.presenter.Presenter;
import com.umeng.analytics.MobclickAgent;

import butterknife.ButterKnife;

/**
 * @ author adam289
 * @ desc 
 * @ created at 2017/3/19 7:31
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected Context mContext;
    protected Presenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceStatee) {
        super.onCreate(savedInstanceStatee);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        mContext = this;
        //禁止横屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init(savedInstanceStatee);
    }

    protected abstract int getLayoutId();

    protected abstract Presenter getPresenter();

    protected abstract void init(Bundle savedInstanceState);

    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
        if (presenter == null && getPresenter() != null) {
            presenter = getPresenter();
        }
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter = null;
        }
    }

}
