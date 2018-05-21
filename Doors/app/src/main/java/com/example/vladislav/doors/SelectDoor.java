package com.example.vladislav.doors;

import android.util.Log;

public class SelectDoor {
    private Door [] doors;
    private static final String TAG = "SelectDoor";

    SelectDoor(Door[] doors) {
        this.doors = doors;
    }

    // выбирает первую дверь
    public Door selectDoor() {
        for (Door door : doors) {
            if (door.getContent() != 1 && door.isSelected() && !door.isOpened()) {
                Log.d(TAG, "selectDoor: " + door.getDoor());
                return door;
            }
        }
        return null;

    }

    //выбирает дверь после подтверждения выбора, нету больше не выбранных дверей,
    // то открываем выбранную
    public Door selectScndDoor() {
        for (Door door : doors) {
            if (door.isSelected() && !door.isOpened()) {
                return door;
            }
        }
        for (Door door : doors) {
            if (!door.isOpened()) return door;
        }
        return null;
    }
}
