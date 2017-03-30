package com.adam289.cooking.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.adam289.cooking.R;
import com.adam289.cooking.model.entity.CookEntity.CookDetail;
import com.adam289.cooking.utils.GlideUtil;

import butterknife.BindView;

/**
 * Desc
 * Created by Adam289 on 2017/3/24.
 */

public class CookListAdapter extends BaseRecyclerAdapter<CookDetail> {
    private GlideUtil glideUtil;
    private Activity activity;

    public CookListAdapter(Activity activity) {
        this.activity = activity;
        glideUtil = new GlideUtil();
    }


    @Override
    public CommonHolder setViewHolder(ViewGroup parent) {
        return null;
    }

    class CardHolder extends CommonHolder<CookDetail> {

        @BindView(R.id.img_cook)
        ImageView imgCook;
        @BindView(R.id.text_name)
        TextView textName;

        public CardHolder(Context context, ViewGroup root) {
            super(context, root, R.layout.item_cook_list);
        }

        @Override
        public void bindData(CookDetail cookDetail) {
textName.setText(cookDetail.getName());
            if(cookDetail.getRecipe()!=null&&cookDetail.getRecipe().getImg()!=null&& TextUtils.isEmpty(cookDetail.getRecipe().getImg())){
                glideUtil.attach(imgCook).injectImageWithNull(cookDetail.getRecipe().getImg());
            }
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    CookDetailActivity.startActivity(activity, imgvCook, cook, true);
                }
            });
        }
    }
}
