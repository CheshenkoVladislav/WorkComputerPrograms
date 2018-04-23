package com.example.vladislav.vkclient;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.vladislav.vkclient.Fragments.FotoFragment;
import com.example.vladislav.vkclient.Fragments.SliderShowFragment;

public class MoreInfoActivity extends AppCompatActivity {
    private static final String TAG = "MoreInfoActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "CREATED INFO ACTIVITY");
        setContentView(R.layout.activity_more_info);
//        photoUrl = getIntent().getStringExtra(FotoFragment.IMAGE_URL_KEY);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        SliderShowFragment fragment = new SliderShowFragment();
        fragment.imageUrl = getIntent().getStringExtra(FotoFragment.IMAGE_URL_KEY);
        transaction.add(R.id.fragmentContainer,fragment);
        fragment.show(fragmentManager,"TAG");
    }
}
