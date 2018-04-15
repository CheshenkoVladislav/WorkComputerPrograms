package com.example.vladislav.vkclient;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.vladislav.vkclient.Adapters.ViewPagerAdapter;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKAccessTokenTracker;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKRequest;

public class MainActivity extends AppCompatActivity {
    ViewPager pager;
    TabLayout tab;
    private static final String TAG = "MainActivity";
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vkAccessTokenTracker.startTracking();
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VKSdk.logout();
                logIn();
            }
        });
    }

    private void initFragments() {
        pager = findViewById(R.id.pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
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
}
