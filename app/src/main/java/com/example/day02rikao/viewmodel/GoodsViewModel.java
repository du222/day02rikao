package com.example.day02rikao.viewmodel;

import android.app.Application;
import android.content.Context;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bumptech.glide.Glide;
import com.example.day02rikao.R;
import com.example.day02rikao.Reposities.GoodsReposities;
import com.example.day02rikao.adapter.GoodsAdapter;
import com.example.day02rikao.databinding.FragmentHomeBinding;
import com.example.day02rikao.entity.GoodsEntity;
import com.example.day02rikao.view.HomeFragment;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class GoodsViewModel extends BaseViewModel {
    GoodsReposities goodsRepo = new GoodsReposities();
    GoodsAdapter mGoodsAdapter;
    public GoodsViewModel(@NonNull Application application) {
        super(application);
    }

    public void data(FragmentHomeBinding binding, LifecycleOwner ow) {
        List<GoodsEntity.DataBean> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        binding.rv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        mGoodsAdapter = new GoodsAdapter(R.layout.item,list);
        binding.rv.setAdapter(mGoodsAdapter);
        goodsRepo.getGoods().observe(ow, new Observer<GoodsEntity>() {
            @Override
            public void onChanged(GoodsEntity goodsEntity) {
                list.addAll(goodsEntity.getData());
                mGoodsAdapter.notifyDataSetChanged();
            }
        });
        list2.add(R.drawable.yk);
        list2.add(R.drawable.timg1);
        list2.add(R.drawable.t2);
        binding.bann.setImages(list2);
        binding.bann.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        });
        binding.bann.start();

    }
}
