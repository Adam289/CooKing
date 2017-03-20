package com.adam289.cooking.model.executor;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * Created by temp on 2017/3/19.
 */

public class RxJavaExecutor {
    private ThreadExecutor threadExecutor;
    private PostExceptionThread postExceptionThread;
    private Subscription subscription = Subscriptions.empty();

    public RxJavaExecutor(ThreadExecutor threadExecutor,PostExceptionThread postExceptionThread) {
        this.threadExecutor = threadExecutor;
        this.postExceptionThread = postExceptionThread;
    }
    public void execute(Observable observable, Subscriber subscriber){
        this.subscription = observable.subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExceptionThread.getScheduler()).subscribe(subscriber);


    }
}
