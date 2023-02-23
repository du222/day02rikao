package com.example.day02rikao.adapter;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.day02rikao.R;
import com.example.day02rikao.entity.GoodsEntity;

import java.util.List;

public class GoodsAdapter extends BaseQuickAdapter<GoodsEntity.DataBean, BaseViewHolder> {
    public GoodsAdapter(int layoutResId, @Nullable List<GoodsEntity.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, GoodsEntity.DataBean dataBean) {

        baseViewHolder.setText(R.id.tv,dataBean.getGoods_desc());
        ImageView view = baseViewHolder.getView(R.id.iv);
        Glide.with(view).load(dataBean.getGoods_default_icon()).into(view);

    }
}
