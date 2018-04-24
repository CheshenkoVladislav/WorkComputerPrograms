package com.example.vladislav.vkclient.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.vladislav.vkclient.BigPhotoFragment;

import java.util.List;

public class SliderPagerAdapter extends FragmentPagerAdapter {
    public List<String>bigImageUrls;
    public int startPosition;

    public SliderPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        BigPhotoFragment fragment = new BigPhotoFragment();
        fragment.setImageUrl(bigImageUrls.get(position));
        return fragment;
    }


    @Override
    public int getCount() {
        return bigImageUrls.size();
    }
}
