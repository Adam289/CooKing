package com.adam289.cooking;

import android.content.Context;

import org.litepal.LitePalApplication;

/**
 * Created by temp on 2017/3/18.
 */

public class MyApplication extends LitePalApplication {
    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }
    public static Context getContext(){
        return mContext;
    }
}
