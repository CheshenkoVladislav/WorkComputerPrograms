package com.example.vladislav.doors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private boolean firstDoorIsOpened;
    Door door1;
    Door door2;
    Door door3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Distributor distributor = new Distributor();
        int [] result = distributor.itemsDistribution();
        Log.d(TAG, "onCreate: ");
        door1 = new Door(findViewById(R.id.door1), result[0]);
        door2 = new Door(findViewById(R.id.door2), result[1]);
        door3 = new Door(findViewById(R.id.door3), result[2]);

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
        SelectDoor selectDoor = new SelectDoor(door1,door2,door3);
        openDoors(selectDoor);
    }

    private void openDoors(SelectDoor selectDoor) {
        door1.getDoor().setOnClickListener(v -> {
            if (!firstDoorIsOpened){
                Log.d(TAG, "DOOR1 CLICK");
                door1.setSelected(true);
                door1.setOpened(true);
                openFirstDoor(selectDoor.selectFirstDoor(),v);
                firstDoorIsOpened = true;
            }else openScndDoor(selectDoor.selectFirstDoor(),v);
        });
        door2.getDoor().setOnClickListener(v -> {
            if (!firstDoorIsOpened){
                Log.d(TAG, "DOOR2 CLICK");
                door2.setSelected(true);
                door2.setOpened(true);
                openFirstDoor(selectDoor.selectFirstDoor(),v);
                firstDoorIsOpened = true;
            } else openScndDoor(selectDoor.selectFirstDoor(),v);
        });
        door3.getDoor().setOnClickListener(v -> {
            if (!firstDoorIsOpened){
                Log.d(TAG, "DOOR3 CLICK");
                door3.setSelected(true);
                door3.setOpened(true);
                openFirstDoor(selectDoor.selectFirstDoor(),v);
                firstDoorIsOpened = true;
            }else openScndDoor(selectDoor.selectFirstDoor(),v);
        });
    }

    private void openFirstDoor(Door door, View v) {
        door.open();
            try {
                Thread.sleep(500);
                Dialog dialogFragment = new Dialog();
                dialogFragment.show(getSupportFragmentManager(),"tag");
                SelectDoor selectDoor = new SelectDoor(door1,door2,door3);
                openDoors(selectDoor);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
    private void openScndDoor(Door door, View v){
        door.open();
    }
}
