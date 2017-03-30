package com.adam289.cooking.model.entity.responsitory;

import com.adam289.cooking.IView.ICookRespository;
import com.adam289.cooking.model.entity.SubscriberEntity.CategorySubscriberResultInfo;
import com.adam289.cooking.model.entity.SubscriberEntity.SearchCookMenuSubscriberResultInfo;
import com.adam289.cooking.model.interfaces.ICookService;
import com.adam289.cooking.model.net.RetrofitService;
import com.adam289.cooking.utils.MyContants;
import com.google.gson.Gson;

import rx.Observable;

/**
 * Desc
 * Created by Adam289 on 2017/3/23.
 */

public class CookResponsitory implements ICookRespository {
    private static CookResponsitory instance = null;
    public static CookResponsitory getInstance(){
        if(instance==null){
            instance = new CookResponsitory();
        }
        return instance;
    }
    private Gson gson;
    private CookResponsitory(){
        gson = new Gson();
    }

    @Override
    public Observable<CategorySubscriberResultInfo> getCategoryQuery() {
        ICookService iCookService = RetrofitService.getInstance().createApi(ICookService.class);
        iCookService.getCategoryQuery(MyContants.Key_MobAPI_Cook);
        return null;
    }
    @Override
    public Observable<SearchCookMenuSubscriberResultInfo> searchCookMenuByID(final String cid, final int page, final int size){
        ICookService iCookService = RetrofitService.getInstance().createApi(ICookService.class);
        return iCookService.searchCookMenuByID(MyContants.Key_MobAPI_Cook, cid, page, size);
    }

    @Override
    public Observable<SearchCookMenuSubscriberResultInfo> searchCookMenuByName(final String name, final int page, final int size){
        ICookService iCookService = RetrofitService.getInstance().createApi(ICookService.class);
        return iCookService.searchCookMenuByName(MyContants.Key_MobAPI_Cook, name, page, size);
    }
}
