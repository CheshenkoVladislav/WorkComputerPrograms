package com.example.vladislav.vkclient.Adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.AdapterViewFlipper;

import com.example.vladislav.vkclient.Fragments.FotoFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private String []pages = new String[]{"Картинки", "Видео", "Гифки"};
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:return new FotoFragment();
            case 1:return new FotoFragment();
            case 2:return new FotoFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return pages.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return pages[position];
    }
}
