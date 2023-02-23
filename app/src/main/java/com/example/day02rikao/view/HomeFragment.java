package com.example.day02rikao.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day02rikao.R;
import com.example.day02rikao.databinding.FragmentHomeBinding;
import com.example.day02rikao.viewmodel.GoodsViewModel;


public class HomeFragment extends BaseFragment<GoodsViewModel,FragmentHomeBinding> {


    @Override
    protected int layoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void progressData() {
        vm.data(binding,this);
    }


}