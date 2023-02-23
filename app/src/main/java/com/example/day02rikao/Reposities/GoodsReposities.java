package com.example.day02rikao.Reposities;

import androidx.lifecycle.MutableLiveData;

import com.example.day02rikao.entity.GoodsEntity;
import com.example.day02rikao.model.BaseModel;

public class GoodsReposities extends BaseModel {

    public MutableLiveData<GoodsEntity> getGoods(){
        MutableLiveData<GoodsEntity> data = new MutableLiveData<>();
        return obsere(getApi().getGoods(),data);
    }
}
