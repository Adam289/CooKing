package com.adam289.cooking.model.entity.CookEntity;

import java.util.ArrayList;

/**
 * Desc 查询菜的类型
 * Created by Adam289 on 2017/3/22.
 */

public class CategoryResultInfo {
    private CategoryInfo categoryInfo;
    private ArrayList<CategoryChildInfo1> childs;

    public CategoryResultInfo() {
    }

    public CategoryInfo getCategoryInfo() {
        return categoryInfo;
    }

    public void setCategoryInfo(CategoryInfo categoryInfo) {
        this.categoryInfo = categoryInfo;
    }

    public ArrayList<CategoryChildInfo1> getChilds() {
        return childs;
    }

    public void setChilds(ArrayList<CategoryChildInfo1> childs) {
        this.childs = childs;
    }
}
