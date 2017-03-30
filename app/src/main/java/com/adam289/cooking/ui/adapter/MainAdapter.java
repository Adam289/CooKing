package com.adam289.cooking.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.adam289.cooking.model.entity.tb_cook.TB_CustomCategory;
import com.adam289.cooking.ui.fragment.CookListFragment;

import java.util.List;

/**
 * Desc
 * Created by Adam289 on 2017/3/23.
 */

public class MainAdapter extends FragmentPagerAdapter {
    private List<TB_CustomCategory> mList;
    public MainAdapter(FragmentManager fm, List<TB_CustomCategory> list) {
        super(fm);
        mList = list;
    }

    @Override
    public Fragment getItem(int position) {
        CookListFragment fragment = new CookListFragment();
        fragment.setCustomCategoryData(mList.get(position));

        return fragment;
    }

    @Override
    public int getCount() {
        if(null ==mList){
            return  0;
        }
        return mList.size();
    }

    @Override
    public long getItemId(int position) {
        // 获取当前数据的hashCode
        int hashCode = mList.get(position).hashCode();
        return hashCode;
    }
}
