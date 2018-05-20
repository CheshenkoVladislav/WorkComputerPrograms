package com.example.vladislav.doors;

import android.media.Image;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {
    private boolean click;
    private static final String TAG = "MainActivity";
    Door door1;
    Door door2;
    Door door3;
    static int [] result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = itemsDistribution();
        ImageView imageDoor1 = findViewById(R.id.door1);
        ImageView imageDoor2 = findViewById(R.id.door2);
        ImageView imageDoor3 = findViewById(R.id.door3);
        door1 = new Door(imageDoor1,result[0]);
        door2 = new Door(imageDoor2,result[1]);
        door3 = new Door(imageDoor3,result[2]);

        imageDoor1.setOnClickListener(v -> {
            door1.setSelected(true);
            startAction(door1);
        });
        imageDoor2.setOnClickListener(v -> {
            door2.setSelected(true);
            startAction(door1);
        });
        imageDoor3.setOnClickListener(v -> {
            door3.setSelected(true);
            startAction(door1);
        });
    }

    private int[] itemsDistribution() {
        int d1;
        int d2;
        int d3;
        d1 = randomNum(1,0);
        System.out.println(d1);
        if (d1 != 1){
            d2 = randomNum(1,0);
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
        return new int[]{d1,d2,d3};
    }

    private int randomNum(int max, int min) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
    void startAction(Door door){
        if (door.getContent() != 1 && !door1.isSelected()){
            door.open();
            try {
                Thread.sleep(1000);
                Dialog dialog = new Dialog();
                dialog.show(getSupportFragmentManager(),"enter");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
