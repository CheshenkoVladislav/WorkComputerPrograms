package com.example.vladislav.recycleapplication.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.example.vladislav.recycleapplication.ItemsListFragment;

/**
 * Created by vladislav on 21.03.18.
 */

public class MainPageAdapter extends FragmentPagerAdapter {
    private static final String TAG = "MainPageAdapter";
    public static String TYPE_EXPENSE = "expense";
    public static String TYPE_INCOME = "income";
    public static String TYPE_BALANCE = null;
    private String[]tabs = {
            "Доходы",
            "Расходы",
            "Баланс"};
    public MainPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Log.d(TAG, "getItem: " + "!!!!!!!!!!!!!!!!!!!");
        switch (position){
            case 0: {
                ItemsListFragment fragment = ItemsListFragment.createFragment(TYPE_INCOME);
                return fragment;
            }
            case 1: {
                ItemsListFragment fragment = ItemsListFragment.createFragment(TYPE_EXPENSE);
                return fragment;
            }
            case 2: {
                ItemsListFragment fragment = ItemsListFragment.createFragment(TYPE_BALANCE);
                return fragment;
            }
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabs.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }
}
