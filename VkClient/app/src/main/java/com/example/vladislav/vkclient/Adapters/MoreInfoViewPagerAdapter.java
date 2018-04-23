package com.example.vladislav.vkclient.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.vladislav.vkclient.Data.UrlsForRecycleItem;
import com.example.vladislav.vkclient.Fragments.SliderShowFragment;
import com.example.vladislav.vkclient.Fragments.bigPhotoFragment;

import java.util.List;

public class MoreInfoViewPagerAdapter extends FragmentPagerAdapter {
    private List<UrlsForRecycleItem>imageArray;
    private int startPosition;
    public MoreInfoViewPagerAdapter(FragmentManager fm,List<UrlsForRecycleItem>imageArray,int startPosition) {
        super(fm);
        this.startPosition = startPosition;
        this.imageArray = imageArray;
    }

    @Override
    public Fragment getItem(int position) {
        if (startPosition != -1)position = startPosition;
        return bigPhotoFragment;
    }

    @Override
    public int getCount() {
        return imageArray.size();
    }

    private Fragment createFragment(){
        bigPhotoFragment.createFragment().setAdditionalFunctions();
    }
}
