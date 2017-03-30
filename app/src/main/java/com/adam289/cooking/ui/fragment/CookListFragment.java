package com.adam289.cooking.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.adam289.cooking.IView.ICookListView;
import com.adam289.cooking.R;
import com.adam289.cooking.model.entity.CookEntity.CookDetail;
import com.adam289.cooking.model.entity.tb_cook.TB_CustomCategory;
import com.adam289.cooking.presenter.CookListPresenter;
import com.adam289.cooking.presenter.Presenter;
import com.adam289.cooking.ui.adapter.CookListAdapter;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.header.bezierlayout.BezierLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Desc
 * Created by Adam289 on 2017/3/23.
 */

public class CookListFragment extends BaseFragment implements ICookListView {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.view_overlay)
    View viewOverlay;
    private CookListPresenter cookListPresenter;
    private CookListAdapter cookListAdapter;
    private Context mContext;
    @BindView(R.id.recycler_view)
    private TwinklingRefreshLayout twinklingRefreshLayout;
    private TB_CustomCategory customCategory;

    @Override
    protected Presenter getPresenter() {
        return cookListPresenter;
    }

    @Override
    protected void initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity();
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        cookListAdapter= new CookListAdapter(getActivity());
        recyclerView.setAdapter(cookListAdapter);

        BezierLayout headView = new BezierLayout(mContext);
        headView.setRippleColor(getResources().getColor(R.color.white));
        headView.setWaveColor(getResources().getColor(R.color.main_indicator_bg));
        twinklingRefreshLayout.setHeaderView(headView);
        ArrayList<CookDetail> datas = new ArrayList<>();
        cookListAdapter.setDataList(datas);

        cookListPresenter = new CookListPresenter(mContext,this);
        cookListPresenter.updateRefreshCookMenuByID(customCategory.getCtgId());

        twinklingRefreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                super.onRefresh(refreshLayout);
                cookListPresenter.updateRefreshCookMenuByID(customCategory.getCtgId());
            }

            @Override
            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
                super.onLoadMore(refreshLayout);
                cookListPresenter.loadMOreCookMenuByID(customCategory.getCtgId());
            }
        });

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_cook_list;
    }

    @Override
    public void onCookListUpdateRefreshSuccess(ArrayList<CookDetail> list) {
twinklingRefreshLayout.finishRefreshing();

        cookListAdapter.setDataList(list);
        cookListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCookListUpdateRefreshFail(String msg) {
twinklingRefreshLayout.finishRefreshing();
        Toast.makeText(mContext,msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCookListLoadMoreSuccess(ArrayList<CookDetail> list) {
twinklingRefreshLayout.finishLoadmore();
        cookListAdapter.addItems(conversion(list));
    }

    @Override
    public void onCookListLoadMoreFail(String msg) {
        twinklingRefreshLayout.finishLoadmore();
        Toast.makeText(mContext,msg,Toast.LENGTH_LONG).show();
    }

    private List<CookDetail> conversion(ArrayList<CookDetail> list){
        List<CookDetail> datas = new ArrayList<>();
        for(CookDetail item : list){
            datas.add(item);
        }

        return datas;
    }
    public void setCustomCategoryData(TB_CustomCategory tb_customCategory){
        this.customCategory = tb_customCategory;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
