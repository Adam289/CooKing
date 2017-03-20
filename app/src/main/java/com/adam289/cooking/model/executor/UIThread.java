package com.adam289.cooking.model.executor;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by temp on 2017/3/19.
 */

public class UIThread implements PostExceptionThread {
    public UIThread() {
    }

    public static UIThread instance(){
        return Holder.INSTANCE;
    }
    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
    private final static class Holder {
        private static final UIThread INSTANCE = new UIThread();
    }
}
