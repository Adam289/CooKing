package com.adam289.cooking.model.entity.CookEntity;

/**
 * Desc
 * Created by Adam289 on 2017/3/22.
 */

public class CategoryInfo {

    private String ctgId;
    private String parentId;
    private String name;

    public CategoryInfo(){

    }

    public String getCtgId() {
        return ctgId;
    }

    public void setCtgId(String ctgId) {
        this.ctgId = ctgId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
