package com.adam289.cooking.model.entity.CookEntity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Desc
 * Created by Adam289 on 2017/3/23.
 */

public class CookDetail implements Parcelable {
    private ArrayList<String> ctgIds;
    private String ctgTitles;
    private String menuId;
    private String name;
    private CookRecipe recipe;
    private String thumbnail;

    public CookDetail() {
    }

    public ArrayList<String> getCtgIds() {
        return ctgIds;
    }

    public void setCtgIds(ArrayList<String> ctgIds) {
        this.ctgIds = ctgIds;
    }

    public String getCtgTitles() {
        return ctgTitles;
    }

    public void setCtgTitles(String ctgTitles) {
        this.ctgTitles = ctgTitles;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CookRecipe getRecipe() {
        return recipe;
    }

    public void setRecipe(CookRecipe recipe) {
        this.recipe = recipe;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    protected CookDetail(Parcel in) {
        ctgIds = in.createStringArrayList();
        ctgTitles = in.readString();
        menuId = in.readString();
        name = in.readString();
        recipe = in.readParcelable(CookRecipe.class.getClassLoader());
        thumbnail = in.readString();
    }

    public static final Creator<CookDetail> CREATOR = new Creator<CookDetail>() {
        @Override
        public CookDetail createFromParcel(Parcel in) {
            return new CookDetail(in);
        }

        @Override
        public CookDetail[] newArray(int size) {
            return new CookDetail[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(ctgIds);
        parcel.writeString(ctgTitles);
        parcel.writeString(menuId);
        parcel.writeString(name);
        parcel.writeParcelable(recipe, i);
        parcel.writeString(thumbnail);
    }
}
