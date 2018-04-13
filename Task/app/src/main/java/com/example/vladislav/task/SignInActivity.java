package com.example.vladislav.task;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.vladislav.task.Data.TokenRequest;
import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInActivity extends AppCompatActivity {
    String ID = "8921f3f50065c632079f7f6b2416b1fb8f2c0d2e4b9d97cdd620759259544dbb";
    String SECRET = "9f31f96cbd92fd7bfadc5bfa06f1c5ce60a5c9bd06f0423b05d283a85b38a910";
    String GRANT_TYPE = "client_credentials";
    TwitterLoginButton twitterLoginButton;
    private static final String TAG = "SignInActivity";
    static Result<TwitterSession>res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        TwitterConfig config = new TwitterConfig.Builder(this)
                .logger(new DefaultLogger(Log.DEBUG))
                .twitterAuthConfig(new TwitterAuthConfig(getResources().getString(R.string.com_twitter_sdk_android_CONSUMER_KEY),getResources()
                        .getString(R.string.com_twitter_sdk_android_CONSUMER_SECRET)))
                .build();
        Twitter.initialize(config);
        twitterLoginButton = findViewById(R.id.twitter_sign_in_button);
//        twitterLoginButton.setEnabled(true);
        twitterLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Clicked Twitter: ");
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        loginTwitter();
        twitterLoginButton.setEnabled(true);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TwitterAuthConfig.DEFAULT_AUTH_REQUEST_CODE && resultCode == RESULT_OK)
        twitterLoginButton.onActivityResult(requestCode,resultCode,data);
        Log.d(TAG, "onActivityResult: " + data.getDataString());
    }

    private void loginTwitter() {
        twitterLoginButton.setCallback(new com.twitter.sdk.android.core.Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                Log.d(TAG, "\nsuccess: " + result.data + "\nusername: " + result.data.getUserName() + "\nid: " + result.data.getUserId()
                + "\n" + result.response);
            }

            @Override
            public void failure(TwitterException exception) {
                Log.d(TAG, "failure: " + exception.getMessage());
            }
        });
    }

    private void requestToken() {
        RetrofitClass.getApi().getToken(ID,SECRET,GRANT_TYPE).enqueue(new Callback<TokenRequest>() {
            @Override
            public void onResponse(Call<TokenRequest> call, Response<TokenRequest> response) {
                Log.d(TAG, "onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<TokenRequest> call, Throwable t) {
                Log.d(TAG, "onFailure: FAIL " + t.getMessage());
            }
        });
    }
}
