package com.example.day02rikao;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.day02rikao.adapter.FragmentAdapter;
import com.example.day02rikao.databinding.ActivityMainBinding;
import com.example.day02rikao.view.BaseActivity;
import com.example.day02rikao.view.CartFragment;
import com.example.day02rikao.view.GzFragment;
import com.example.day02rikao.view.HomeFragment;
import com.example.day02rikao.view.MyFragment;
import com.example.day02rikao.viewmodel.BaseViewModel;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<BaseViewModel, ActivityMainBinding> {
    FragmentAdapter mFragmentAdapter;
    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void progressData() {
        List<Fragment> list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new GzFragment());
        list.add(new CartFragment());
        list.add(new MyFragment());

        mFragmentAdapter = new FragmentAdapter(getSupportFragmentManager(),list);
        binding.vp.setAdapter(mFragmentAdapter);
        binding.bottom.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        binding.vp.setCurrentItem(0);
                        break;
                    case R.id.guanzhu:
                        binding.vp.setCurrentItem(1);
                        break;
                    case R.id.cart:
                        binding.vp.setCurrentItem(2);
                        break;
                    case R.id.my:
                        binding.vp.setCurrentItem(3);
                        break;
                }
                return true;
            }
        });

        binding.vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                binding.bottom.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


}