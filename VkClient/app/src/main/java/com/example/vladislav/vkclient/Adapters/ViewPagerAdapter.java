package com.example.vladislav.vkclient.Adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;

import com.example.vladislav.vkclient.Fragments.FotoFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private Fragment currentFragment;
    SparseArray<Fragment>arrayFragment = new SparseArray<>();

    public static String TYPE_KEY = "fragmentType";
    private String []pages = new String[]{"Картинки", "Видео", "Гифки"};
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:return currentFragment = new FotoFragment();
            case 1:return currentFragment = new FotoFragment();
            case 2:return currentFragment = new FotoFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return pages.length;
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        if (getCurrentFragment() != object) {
            currentFragment = ((Fragment) object);
        }
        super.setPrimaryItem(container, position, object);
    }

    public Fragment getCurrentFragment() {
        return currentFragment;
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return pages[position];
    }
}
