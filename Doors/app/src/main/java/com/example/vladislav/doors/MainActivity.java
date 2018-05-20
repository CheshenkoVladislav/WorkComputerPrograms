package com.example.vladislav.doors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView door1 = findViewById(R.id.door1);
        ImageView door2 = findViewById(R.id.door2);
        ImageView door3 = findViewById(R.id.door3);

        TextView textView = findViewById(R.id.textView);

        int d1;
        int d2;
        int d3;

        d1 = (int) (Math.random()*10);
        System.out.println(d1);
        if (d1 != 1){
            d2 = (int) Math.random()*10;
            if (d2 != 1){
                d3 = 1;
            } else {
                d3 = 0;
            }
        } else {
            d2 = 0;
            d3 = 0;
        }
        Log.d(TAG, "d1 = " + d1 + " " +
        "d2 = " + d2 + " " +
        "d3 = " + d3);
    }
}
