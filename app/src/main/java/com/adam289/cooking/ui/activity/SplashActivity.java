package com.adam289.cooking.ui.activity;

import android.app.Activity;
import android.os.Bundle;

import com.adam289.cooking.IView.ISplashView;
import com.adam289.cooking.presenter.SplashPresenter;


public class SplashActivity extends Activity implements ISplashView {

    private SplashPresenter splashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        splashPresenter = new SplashPresenter(this, this);
        splashPresenter.initData();
    }

    @Override
    public void onSplashInitData(){
        startMainActivity();
    }

    private void startMainActivity(){
        MainActivity.startActivity(this);
        overridePendingTransition(0, 0);
        finish();
    }

}
