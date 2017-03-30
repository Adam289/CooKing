package com.adam289.cooking.model.entity.CookEntity;

import java.util.ArrayList;

/**
 * Desc 一级子数据
 * Created by Adam289 on 2017/3/22.
 */

public class CategoryChildInfo1 {
    private CategoryInfo categoryInfo;
    private ArrayList<CategoryChildInfo2> childs;

    public CategoryChildInfo1() {
    }

    public CategoryInfo getCategoryInfo() {
        return categoryInfo;
    }

    public void setCategoryInfo(CategoryInfo categoryInfo) {
        this.categoryInfo = categoryInfo;
    }

    public ArrayList<CategoryChildInfo2> getChilds() {
        return childs;
    }

    public void setChilds(ArrayList<CategoryChildInfo2> childs) {
        this.childs = childs;
    }
}
