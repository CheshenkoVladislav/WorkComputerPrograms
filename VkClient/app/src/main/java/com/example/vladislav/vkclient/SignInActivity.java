package com.example.vladislav.vkclient;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SharedMemory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;

import java.util.ArrayList;
import java.util.List;

public class SignInActivity extends AppCompatActivity {
    Button btn;
    private static final String TAG = "SignInActivity";
    public static String userId;
    private String[]access = new String[]{VKScope.PHOTOS,
            VKScope.VIDEO, VKScope.DIRECT,VKScope.ADS,
            VKScope.PAGES,VKScope.STATS,VKScope.STATUS,
            VKScope.WALL,VKScope.NOHTTPS,VKScope.GROUPS,VKScope.OFFLINE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VKSdk.login(SignInActivity.this,access);
            }
        });
    }

    @Override
    protected void onActivityResult(final int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                // Пользователь успешно авторизовался
                Log.d(TAG, "AUTHORIZE OK : " + res.accessToken
//                + "\nsecret: " + res.secret
//                + "\nemail: " + res.email
                + "\nuserID: " + res.userId);
                userId = res.userId;
            }
            @Override
            public void onError(VKError error) {
                // Произошла ошибка авторизации (например, пользователь запретил авторизацию)
                Log.d(TAG, "ERROR AUTHORIZE: " + error.errorCode);
            }
        }));
        finish();
    }

}
