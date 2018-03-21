package com.example.vladislav.recycleapplication.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.vladislav.recycleapplication.ItemsListFragment;

/**
 * Created by vladislav on 21.03.18.
 */

public class MainPageAdapter extends FragmentPagerAdapter {
    String TYPE_EXPENSE = "expence";
    private String[]tabs = {
            "Доходы",
            "Расходы",
            "Баланс"};
    public MainPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return ItemsListFragment.createFragment(TYPE_EXPENSE);
            case 1: return ItemsListFragment.createFragment(TYPE_EXPENSE);
            case 2: return ItemsListFragment.createFragment(TYPE_EXPENSE);
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
