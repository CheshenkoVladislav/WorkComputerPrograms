package com.example.vladislav.doors;

import android.app.FragmentManager;
import android.util.Log;

public class SelectDoor implements Selector {
    private Door door1;
    private Door door2;
    private Door door3;
    private Door [] doors;
    private Door openedDoor;
    private static final String TAG = "SelectDoor";

    SelectDoor(Door door1, Door door2, Door door3){
        this.door1 = door1;
        this.door2 = door2;
        this.door3 = door3;
        doors = new Door[] {door1,door2,door3};
    }
    @Override
    public Door selectFirstDoor() {
        if (door1.getContent() != 1 && !door1.isSelected() && !door1.isOpened()) {
            return door1;
        } else if (door2.getContent() != 1 && !door2.isSelected() && !door2.isOpened()) {
            return door2;
        } else if (door3.getContent() != 1 && !door3.isSelected() && !door3.isOpened()) {
            return door3;
        } else return selectScndDoor();
    }

    @Override
    public Door selectScndDoor() {
        Log.d(TAG, "selectScndDoor: ");
        for (Door door : doors) {
            if (!door.isOpened() && door.isSelected() && door.getContent() != 1) {
                return door3;
            }
        }
        return null;
    }
}
