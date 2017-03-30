package com.adam289.cooking.IView;

import com.adam289.cooking.model.entity.SubscriberEntity.CategorySubscriberResultInfo;
import com.adam289.cooking.model.entity.SubscriberEntity.SearchCookMenuSubscriberResultInfo;

import rx.Observable;

/**
 * Desc
 * Created by Adam289 on 2017/3/23.
 */

public interface ICookRespository {
     public Observable<CategorySubscriberResultInfo> getCategoryQuery();
     public Observable<SearchCookMenuSubscriberResultInfo> searchCookMenuByID(final String cid, final int page, final int size);
     public Observable<SearchCookMenuSubscriberResultInfo> searchCookMenuByName(final String name, final int page, final int size);
}
