package com.example.vladislav.vkclient;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.vladislav.vkclient.Adapters.ViewPagerAdapter;
import com.example.vladislav.vkclient.Fragments.FotoFragment;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKAccessTokenTracker;
import com.vk.sdk.VKSdk;

public class MainActivity extends AppCompatActivity{
    ViewPager pager;
    ViewPagerAdapter adapter;
    TabLayout tab;
    private static final String TAG = "MainActivity";
    Button btn;
    Toolbar toolbar;
    FloatingActionButton fab;
    AppBarLayout appBarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vkAccessTokenTracker.startTracking();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VKSdk.logout();
                logIn();
            }
        });
        fab = findViewById(R.id.fab);
        fab.hide();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int returnPosition = 1;
                appBarLayout.setExpanded(true);
                getFotoFragment().getRecycler().smoothScrollToPosition(returnPosition);
            }
        });
        appBarLayout = findViewById(R.id.appBar);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset == 0) fab.hide();
                else fab.show();
            }
        });
    }

    private void initFragments() {
        pager = findViewById(R.id.pager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        tab = findViewById(R.id.tab);
        pager.setAdapter(adapter);
        tab.setupWithViewPager(pager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        logIn();
    }

    VKAccessTokenTracker vkAccessTokenTracker = new VKAccessTokenTracker() {
        @Override
        public void onVKAccessTokenChanged(VKAccessToken oldToken, VKAccessToken newToken) {
            if (newToken == null) {
                VKSdk.logout();
                logIn();
                // VKAccessToken is invalid
            }
        }
    };
    public void logIn(){
        if (!VKSdk.isLoggedIn()) {
            Intent intent = new Intent(this, SignInActivity.class);
            startActivity(intent);
        }else initFragments();
    }

    private FotoFragment getFotoFragment() {
        FotoFragment fragment = (FotoFragment) adapter.getCurrentFragment();
        return fragment;
    }
}
