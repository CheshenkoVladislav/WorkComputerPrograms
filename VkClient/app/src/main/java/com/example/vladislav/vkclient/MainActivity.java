package com.example.vladislav.vkclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKRequest;

public class MainActivity extends AppCompatActivity {
    Button btn;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button2);
        VKRequest request = VKApi.audio().get();
        request.start();
        Log.d(TAG, "GET AUDIO : " + request.response);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VKSdk.logout();
                logIn();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        logIn();
    }
    private void logIn(){
        if (!VKSdk.isLoggedIn()) {
            Intent intent = new Intent(this, SignInActivity.class);
            startActivity(intent);
        }
    }
}
