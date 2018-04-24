package com.example.vladislav.vkclient;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.vladislav.vkclient.Adapters.SliderPagerAdapter;
import com.example.vladislav.vkclient.Fragments.FotoFragment;

import java.util.List;

public class MoreInfoActivity extends AppCompatActivity {
    private static final String TAG = "MoreInfoActivity";
    List<String>bigImageUrls;
    int position;
    ViewPager pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "CREATED INFO ACTIVITY");
        setContentView(R.layout.activity_more_info);
        Log.d(TAG, "INTENT : " + getIntent().getStringArrayListExtra("IMAGE_URLS"));
        Log.d(TAG, " POSITION : "
                + getIntent().getExtras().getInt("IMAGE_POSITION"));
        bigImageUrls = getIntent().getStringArrayListExtra("IMAGE_URLS");
        position = getIntent().getExtras().getInt("IMAGE_POSITION");
        Log.d(TAG, "BIG_IMAGE_URLS_SIZE_AFTER_SENT : " + bigImageUrls.size());
        pager = findViewById(R.id.photoSliderPager);
        SliderPagerAdapter adapter = new SliderPagerAdapter(getSupportFragmentManager());
        adapter.bigImageUrls = getIntent().getStringArrayListExtra("IMAGE_URLS");
        adapter.startPosition = getIntent().getExtras().getInt("IMAGE_POSITION");
        foolViewPager(pager,adapter,position,getSupportFragmentManager());
    }
    public static void foolViewPager(ViewPager pager, FragmentPagerAdapter adapter, int position,FragmentManager fm) {
        pager.setAdapter(new FragmentPagerAdapter(fm) {
                             @Override
                             public Fragment getItem(int position) {
                                 return null;
                             }

                             @Override
                             public int getCount() {
                                 return 0;
                             }
                         });

        pager.setCurrentItem(position, false);
        pager.setAdapter(adapter);
        pager.setCurrentItem(position);
    }
}
