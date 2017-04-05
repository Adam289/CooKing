package com.adam289.cooking.model.respository;

import com.adam289.cooking.model.entity.SubscriberEntity.CategorySubscriberResultInfo;
import com.adam289.cooking.model.entity.SubscriberEntity.SearchCookMenuSubscriberResultInfo;
import com.adam289.cooking.model.interfaces.ICookRespository;
import com.adam289.cooking.model.interfaces.ICookService;
import com.adam289.cooking.model.net.RetrofitService;
import com.adam289.cooking.utils.MyContants;
import com.google.gson.Gson;

import rx.Observable;

/**
 * Desc
 * Created by Adam289 on 2017/4/6.
 */

public class CookRespository    implements ICookRespository {

    private static CookRespository Instance = null;

    public static CookRespository getInstance(){
        if(Instance == null)
            Instance = new CookRespository();

        return Instance;
    }

    private Gson gson;
    private CookRespository(){
        gson = new Gson();
    }

    @Override
    public Observable<CategorySubscriberResultInfo> getCategoryQuery(){
        ICookService iCookService = RetrofitService.getInstance().createApi(ICookService.class);
        return iCookService.getCategoryQuery(MyContants.Key_MobAPI_Cook);
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
