package com.adam289.cooking.model.entity.CookEntity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Desc
 * Created by Adam289 on 2017/3/23.
 */

public class CookRecipe implements Parcelable {
    private String img;
    private String ingredients;
    private String method;
    private String sumary;
    private String title;

    public CookRecipe() {
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getSumary() {
        return sumary;
    }

    public void setSumary(String sumary) {
        this.sumary = sumary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    protected CookRecipe(Parcel in) {
        img = in.readString();
        ingredients = in.readString();
        method = in.readString();
        sumary = in.readString();
        title = in.readString();
    }

    public static final Creator<CookRecipe> CREATOR = new Creator<CookRecipe>() {
        @Override
        public CookRecipe createFromParcel(Parcel in) {
            return new CookRecipe(in);
        }

        @Override
        public CookRecipe[] newArray(int size) {
            return new CookRecipe[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(img);
        parcel.writeString(ingredients);
        parcel.writeString(method);
        parcel.writeString(sumary);
        parcel.writeString(title);
    }
}
