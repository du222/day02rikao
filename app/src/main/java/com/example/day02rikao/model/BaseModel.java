package com.example.day02rikao.model;

import androidx.lifecycle.MutableLiveData;

import com.example.day02rikao.http.Api;
import com.example.day02rikao.http.RetrofitManager;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class BaseModel {

    public Api getApi(){
        return RetrofitManager.getInstance().getRetrofit().create(Api.class);
    }

    public <T>MutableLiveData<T> obsere(Observable observable,MutableLiveData<T> liveData){

        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer() {
                    @Override
                    public void accept(Object o) throws Exception {
                        liveData.postValue((T) o);
                    }
                });
                return  liveData;
    }
}
