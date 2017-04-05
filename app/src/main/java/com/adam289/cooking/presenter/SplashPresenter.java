package com.adam289.cooking.presenter;

import android.content.Context;

import com.adam289.cooking.IView.ICookRespository;
import com.adam289.cooking.IView.ISplashView;
import com.adam289.cooking.model.CustomCategoryManager;
import com.adam289.cooking.model.entity.CookEntity.CategoryChildInfo1;
import com.adam289.cooking.model.entity.SubscriberEntity.CategorySubscriberResultInfo;
import com.adam289.cooking.model.manager.CookCategoryManager;
import com.adam289.cooking.model.respository.CookRespository;

import java.util.ArrayList;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/2/19.
 */

public class SplashPresenter extends Presenter{

    private ICookRespository iCookRespository;
    private ISplashView iSplashView;

    public SplashPresenter(Context context, ISplashView iSplashView){
        super(context);

        this.iCookRespository = CookRespository.getInstance();
        this.iSplashView = iSplashView;
    }

    public void destory(){
        if(getCategoryQuerySubscriber != null){
            getCategoryQuerySubscriber.unsubscribe();
        }
    }

    public void initData(){

        rxJavaExecutor.execute(
                iCookRespository.getCategoryQuery()
                , getCategoryQuerySubscriber = new GetCategoryQuerySubscriber()
        );

    }

    private GetCategoryQuerySubscriber getCategoryQuerySubscriber;



    private class GetCategoryQuerySubscriber extends Subscriber<CategorySubscriberResultInfo> {
        @Override
        public void onCompleted(){

        }

        @Override
        public void onError(Throwable e){
            if(getCategoryQuerySubscriber != null){
                getCategoryQuerySubscriber.unsubscribe();
            }

            CustomCategoryManager.getInstance().initData(null);

            if(iSplashView != null)
                iSplashView.onSplashInitData();

        }

        @Override
        public void onNext(CategorySubscriberResultInfo data){

             ArrayList<CategoryChildInfo1> datas =data.getResult().getChilds();

            CookCategoryManager.getInstance().initDatas(datas);
            CustomCategoryManager.getInstance().initData(datas);

            if(iSplashView != null)
                iSplashView.onSplashInitData();

            this.onCompleted();
        }
    }
}
