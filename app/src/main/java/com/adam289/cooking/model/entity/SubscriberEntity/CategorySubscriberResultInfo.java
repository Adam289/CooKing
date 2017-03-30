package com.adam289.cooking.model.entity.SubscriberEntity;

import com.adam289.cooking.model.entity.CookEntity.CategoryResultInfo;

/**
 * Desc
 * Created by Adam289 on 2017/3/23.
 */

public class CategorySubscriberResultInfo {
    private String msg;
    private String retCode;
    private CategoryResultInfo result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public CategoryResultInfo getResult() {
        return result;
    }

    public void setResult(CategoryResultInfo result) {
        this.result = result;
    }
}
