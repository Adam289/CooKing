package com.adam289.cooking.model.interfaces;

import com.adam289.cooking.model.entity.SubscriberEntity.CategorySubscriberResultInfo;
import com.adam289.cooking.model.entity.SubscriberEntity.SearchCookMenuSubscriberResultInfo;
import com.adam289.cooking.utils.MyContants;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Desc
 * Created by Adam289 on 2017/3/23.
 */

public interface ICookService {


    @GET(MyContants.Cook_Service_CategoryQuery)
    Observable<CategorySubscriberResultInfo> getCategoryQuery(@Query(MyContants.Cook_Parameter_Key) String key);

    @GET(MyContants.Cook_Service_MenuSearch)
    Observable<SearchCookMenuSubscriberResultInfo> searchCookMenuByID(
            @Query(MyContants.Cook_Parameter_Key) String key
            , @Query(MyContants.Cook_Parameter_Cid) String cid
            , @Query(MyContants.Cook_Parameter_Page) int page
            , @Query(MyContants.Cook_Parameter_Size) int size);

    @GET(MyContants.Cook_Service_MenuSearch)
    Observable<SearchCookMenuSubscriberResultInfo> searchCookMenuByName(
            @Query(MyContants.Cook_Parameter_Key) String key
            , @Query(MyContants.Cook_Parameter_Name) String name
            , @Query(MyContants.Cook_Parameter_Page) int page
            , @Query(MyContants.Cook_Parameter_Size) int size);

}
