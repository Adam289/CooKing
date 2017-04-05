package com.adam289.cooking.model;

import android.content.res.AssetManager;

import com.adam289.cooking.MyApplication;
import com.adam289.cooking.model.entity.CookEntity.CategoryChildInfo1;
import com.adam289.cooking.model.entity.CookEntity.CategoryChildInfo2;
import com.adam289.cooking.model.entity.CookEntity.CategoryInfo;
import com.adam289.cooking.model.entity.tb_cook.TB_CustomCategory;
import com.adam289.cooking.ui.component.tagComponent.ChannelItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.litepal.crud.DataSupport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Desc
 * Created by Adam289 on 2017/4/5.
 */

public class CustomCategoryManager {
    private static CustomCategoryManager instance = null;

    public static CustomCategoryManager getInstance() {
        if (instance == null) {
            instance = new CustomCategoryManager();
        }
        return instance;
    }
    private List<TB_CustomCategory> mList;
    private List<TB_CustomCategory> mListOthers;
    private Gson gson;

    public CustomCategoryManager() {
        this.gson = gson;
    }
    public void initData(ArrayList<CategoryChildInfo1> childInfo1ArrayList){
        mList = DataSupport.findAll(TB_CustomCategory.class);
        if(mList==null||mList.size()<1){
            mList = new ArrayList<>();
        }
        StringBuilder buf = new StringBuilder();
        try {
            InputStream inputStream = MyApplication.getContext().getAssets().open("default_cook_category.json", AssetManager.ACCESS_STREAMING);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
            String str;
            while((str = bufferedReader.readLine())!=null){
                buf.append(str);
            }
            inputStream.close();
            JSONArray array = new JSONArray(buf.toString());
            mList  = gson.fromJson(array.toString(),new TypeToken<List<TB_CustomCategory>>(){}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mListOthers = new ArrayList<>();

        if(childInfo1ArrayList == null || childInfo1ArrayList.size() < 1)
            return ;

        for(CategoryChildInfo1 item1 : childInfo1ArrayList){
            for(CategoryChildInfo2 item2 : item1.getChilds()){
                if(!isInDatas(item2.getCategoryInfo().getCtgId())){
                    mListOthers.add(categoryChildInfo2Tb(item2.getCategoryInfo()));
                }
            }
        }
    }
    private boolean isInDatas(String cid){
        for(TB_CustomCategory item : mList){
            if(item.getCtgId().equals(cid)){
                return true;
            }
        }

        return false;
    }

    private TB_CustomCategory categoryChildInfo2Tb(CategoryInfo categoryInfo){
        return new TB_CustomCategory(categoryInfo);
    }

    private TB_CustomCategory ChannelItem2Tb(ChannelItem channelItem){
        return new TB_CustomCategory(channelItem);
    }

    public List<TB_CustomCategory> getDatas(){
        return mList;
    }

    public List<TB_CustomCategory> getOtherDatas() {
        return mListOthers;
    }

    public void save(List<ChannelItem> channelItemDatas, List<ChannelItem> channelItemOtherDatas){
        this.mList.clear();
        this.mListOthers.clear();

        for(ChannelItem item : channelItemDatas)
            this.mList.add(ChannelItem2Tb(item));

        for(ChannelItem item : channelItemOtherDatas)
            this.mListOthers.add(ChannelItem2Tb(item));

        DataSupport.deleteAll(TB_CustomCategory.class);
        DataSupport.saveAll(this.mList);
    }
}
