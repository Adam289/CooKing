package com.adam289.cooking.presenter;

import android.content.Context;

import com.adam289.cooking.IView.ICookListView;
import com.adam289.cooking.IView.ICookRespository;
import com.adam289.cooking.R;
import com.adam289.cooking.model.entity.SubscriberEntity.SearchCookMenuSubscriberResultInfo;
import com.adam289.cooking.model.entity.responsitory.CookResponsitory;
import com.adam289.cooking.utils.ErrorExceptionUtils;
import com.adam289.cooking.utils.MyContants;

import rx.Subscriber;

/**
 * Desc
 * Created by Adam289 on 2017/3/23.
 */

public class CookListPresenter extends Presenter {
    private ICookListView iCookListView;
    private ICookRespository iCookRespository;
    private int curPage = 1;
    private int totalPage = 1;
    private UpdateRefreshCookMenuByIDSubscriber updateRefreshCookMenuByIDSubscriber;

    public CookListPresenter(Context mContext, ICookListView iCookListView) {
        super(mContext);
        this.iCookListView = iCookListView;
        this.iCookRespository = CookResponsitory.getInstance();
    }

    @Override
    public void destory() {
        if(updateRefreshCookMenuByIDSubscriber != null){
            updateRefreshCookMenuByIDSubscriber.unsubscribe();
        }

        if(loadMoreCookMenuByIDSubscriber != null){
            loadMoreCookMenuByIDSubscriber.unsubscribe();
        }
    }

    public void updateRefreshCookMenuByID(String cid) {
        curPage = 1;
        rxJavaExecutor.execute(iCookRespository.searchCookMenuByID(cid, curPage, MyContants.Per_Page_Size), updateRefreshCookMenuByIDSubscriber);

    }

    public void loadMOreCookMenuByID(String cid) {
        curPage++;
        if (curPage > totalPage) {
            curPage--;
            if (iCookListView != null) {
                iCookListView.onCookListLoadMoreFail(mContext.getString(R.string.none_more));
                return;

            }
        }
    }

    private class UpdateRefreshCookMenuByIDSubscriber extends Subscriber<SearchCookMenuSubscriberResultInfo> {

        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            if (updateRefreshCookMenuByIDSubscriber != null) {
                updateRefreshCookMenuByIDSubscriber.unsubscribe();
            }
            if (iCookListView != null) {
                iCookListView.onCookListUpdateRefreshFail(ErrorExceptionUtils.getErrorMsg(e));
            }
        }

        @Override
        public void onNext(SearchCookMenuSubscriberResultInfo searchCookMenuSubscriberResultInfo) {
            totalPage = searchCookMenuSubscriberResultInfo.getResult().getTotal();
            if (iCookListView != null) {
                iCookListView.onCookListUpdateRefreshSuccess(searchCookMenuSubscriberResultInfo.getResult().getList());
            }
            this.onCompleted();
        }
    }

    private LoadMoreCookMenuByIDSubscriber loadMoreCookMenuByIDSubscriber;

    private class LoadMoreCookMenuByIDSubscriber extends Subscriber<SearchCookMenuSubscriberResultInfo> {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            if (loadMoreCookMenuByIDSubscriber != null) {
                loadMoreCookMenuByIDSubscriber.unsubscribe();
            }

            if (iCookListView != null)
                iCookListView.onCookListLoadMoreFail(e.getMessage());

        }

        @Override
        public void onNext(SearchCookMenuSubscriberResultInfo data) {

            if (iCookListView != null)
                iCookListView.onCookListLoadMoreSuccess(data.getResult().getList());

            this.onCompleted();
        }
    }
}
