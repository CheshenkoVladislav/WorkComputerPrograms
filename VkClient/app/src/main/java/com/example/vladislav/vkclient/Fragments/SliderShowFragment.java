package com.example.vladislav.vkclient.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.vladislav.vkclient.Adapters.MoreInfoViewPagerAdapter;
import com.example.vladislav.vkclient.Data.UrlsForRecycleItem;
import com.example.vladislav.vkclient.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SliderShowFragment extends DialogFragment {
    ImageView image;
    public String imageUrl;
    public List<UrlsForRecycleItem>imageUrls;
    public int positon;
    private static final String TAG = "SliderShowFragment";
    ViewPager pager;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "CREATED PHOTO FRAGMENT");

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more_info,container,false);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        image = view.findViewById(R.id.infoPhotoImage);
        pager = view.findViewById(R.id.pagerTwo);
        MoreInfoViewPagerAdapter adapter = new MoreInfoViewPagerAdapter(getChildFragmentManager(),imageUrls,positon);
        pager.setAdapter(adapter);
        Log.d(TAG, "IMAGE VIEW: " + image.toString());
    }
}
