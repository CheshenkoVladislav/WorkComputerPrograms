package com.example.vladislav.recycleapplication;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.vladislav.recycleapplication.Adapter.MainPageAdapter;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    private static final String TAG = "MainActivity";
    ViewPager viewPager;
    TabLayout tabLayout;
    MainPageAdapter adapter = new MainPageAdapter(getSupportFragmentManager());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        System.out.println("GGGGGGGGGGGGGGGGGGGG");
    }

    @Override
    public void onPageSelected(int position) {
        System.out.println(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        System.out.println(state);
        }
    }
