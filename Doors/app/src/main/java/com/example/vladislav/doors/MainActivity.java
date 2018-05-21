package com.example.vladislav.doors;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity
        implements Door.SelectListener {
    private static final String TAG = "MainActivity";
    private boolean firstDoorIsOpened;
    Door[] doors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Distributor distributor = new Distributor();
        initDoors(distributor.itemsDistribution());
    }

    @Override
    public void onSelected(int number) {
        if (!firstDoorIsOpened) {
            doors[number].setSelected(true);
            //select door for open
            openDoor(new SelectDoor(doors).selectDoor());
            showDialog();
            firstDoorIsOpened = true;
        } else {
            try {
                openDoor(new SelectDoor(doors).selectScndDoor());
                TimeUnit.SECONDS.sleep(3);
                openDoor(new SelectDoor(doors).selectScndDoor());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void showDialog() {
        Dialog dialog = new Dialog();
        dialog.show(getSupportFragmentManager(), "dialog1");
    }

    private void setClickableSelectedDoor(Door door) {
        for (Door d : doors) {
            if (door == d) d.getDoor().setClickable(false);
        }
    }

    private void initDoors(int[] result) {
        doors = new Door[]{
                new Door(findViewById(R.id.door1), result[0], 0),
                new Door(findViewById(R.id.door2), result[1], 1),
                new Door(findViewById(R.id.door3), result[2], 2),};
        for (Door d : doors) {
            d.registerListener(this);
            d.startListen();
        }
    }

    private void openDoor(Door door) {
        Log.d(TAG, "openDoor: " + door);
        door.open();
    }
}
