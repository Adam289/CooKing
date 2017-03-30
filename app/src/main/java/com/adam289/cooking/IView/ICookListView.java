package com.adam289.cooking.IView;

import com.adam289.cooking.model.entity.CookEntity.CookDetail;

import java.util.ArrayList;

/**
 * Desc
 * Created by Adam289 on 2017/3/23.
 */

public interface ICookListView {
    public void onCookListUpdateRefreshSuccess(ArrayList<CookDetail> list);
    public void onCookListUpdateRefreshFail(String msg);
    public void onCookListLoadMoreSuccess(ArrayList<CookDetail> list);
    public void onCookListLoadMoreFail(String msg);
}
