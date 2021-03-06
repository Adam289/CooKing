package com.adam289.cooking.model.entity.CookEntity;

import java.util.ArrayList;

/**
 * Desc
 * Created by Adam289 on 2017/3/23.
 */

public class SearchCookMenuResultInfo {
    private int curPage;
    private int total;
    private ArrayList<CookDetail> list;

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ArrayList<CookDetail> getList() {
        return list;
    }

    public void setList(ArrayList<CookDetail> list) {
        this.list = list;
    }
}
