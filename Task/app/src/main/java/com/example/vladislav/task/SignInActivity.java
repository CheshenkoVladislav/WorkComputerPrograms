package com.example.vladislav.task;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.vladislav.task.Data.TokenRequest;
import com.example.vladislav.task.Interfaces.Api;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInActivity extends AppCompatActivity {
    Button signIn;
    String ID = "8921f3f50065c632079f7f6b2416b1fb8f2c0d2e4b9d97cdd620759259544dbb";
    String SECRET = "9f31f96cbd92fd7bfadc5bfa06f1c5ce60a5c9bd06f0423b05d283a85b38a910";
    String GRANT_TYPE = "client_credentials";
    private static final String TAG = "SignInActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        signIn = findViewById(R.id.button);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestToken();
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
