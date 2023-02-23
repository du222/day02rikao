package com.example.day02rikao.http;

import com.example.day02rikao.entity.GoodsEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api {

    @GET("goods/info?category_id=0&currentPage=1&pageSize=10")
    Observable<GoodsEntity> getGoods();
}
