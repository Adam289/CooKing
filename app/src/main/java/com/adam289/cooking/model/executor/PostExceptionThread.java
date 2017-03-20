package com.adam289.cooking.model.executor;

import rx.Scheduler;

/**
 * Created by temp on 2017/3/19.
 */

public interface PostExceptionThread {
    public Scheduler getScheduler();
}
