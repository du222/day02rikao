package com.example.day02rikao.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.day02rikao.viewmodel.BaseViewModel;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class BaseFragment<VM extends BaseViewModel,VDB extends ViewDataBinding> extends Fragment {

    protected VM vm;
    protected VDB binding;
    protected abstract int layoutId();
    protected abstract void progressData();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,layoutId(),container,false);

        createVM();
        progressData();
        return binding.getRoot();
    }

    public void createVM(){
        if(vm == null){
            Class mClass;
            Type type = getClass().getGenericSuperclass();
            if(type instanceof ParameterizedType){
                mClass = (Class) ((ParameterizedType)type).getActualTypeArguments()[0];
            }else{
                mClass = BaseViewModel.class;
            }
            vm = (VM) new ViewModelProvider(this).get(mClass);
        }
    };
}
