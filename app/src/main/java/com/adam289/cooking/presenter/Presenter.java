package com.adam289.cooking.presenter;

import android.content.Context;

import com.adam289.cooking.model.executor.JobExecutor;
import com.adam289.cooking.model.executor.RxJavaExecutor;
import com.adam289.cooking.model.executor.UIThread;


/**
 * Created by temp on 2017/3/19.
 */

public abstract class Presenter {
    protected Context mContext;
    protected RxJavaExecutor rxJavaExecutor;

    public Presenter(Context mContext) {
        this.mContext = mContext;
        this.rxJavaExecutor = new RxJavaExecutor(JobExecutor.instance(), UIThread.instance());
    }
    public abstract void destory();
}
