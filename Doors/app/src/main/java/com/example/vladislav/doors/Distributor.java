package com.example.vladislav.doors;

import android.util.Log;

import java.util.concurrent.ThreadLocalRandom;

public class Distributor{
    private static final String TAG = "Distributor";
    public int[] itemsDistribution() {
        int d1;
        int d2;
        int d3;
        d1 = randomNum(1, 0);
        if (d1 != 1) {
            d2 = randomNum(1, 0);
            if (d2 != 1) {
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
        return new int[]{d1, d2, d3};
    }
    private int randomNum(int max, int min) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
