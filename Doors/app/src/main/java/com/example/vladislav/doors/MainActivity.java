package com.example.vladislav.doors;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
        implements Door.SelectListener {
    private static final String TAG = "MainActivity";
    public static String GAME_STATUS_KEY = "win";
    Door[] doors;
    //флаг открытия первой двери, говорит когда открывать следующие
    private boolean firstDoorIsOpened;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //раскладываем итемы
        Distributor distributor = new Distributor();
        initDoors(distributor.itemsDistribution());
    }

    //слушатель состояния дверей находится в классе Door
    @Override
    public void onSelected(int number) {
        if (!firstDoorIsOpened) {
            doors[number].setSelected(true);
            //select door for open
            openDoor(new SelectDoor(doors).selectDoor());
            showDialog();
            firstDoorIsOpened = true;
        } else {
            newThredComand();
        }
    }

    //Создаем поток для постепенного открытия дверей
    public void newThredComand() {
        @SuppressLint("HandlerLeak")
        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                openDoor(new SelectDoor(doors).selectScndDoor());
            }
        };
        Runnable runnable = () -> {
            synchronized (this) {
                try {
                    handler.sendEmptyMessage(0);
                    wait(1000);
                    handler.sendEmptyMessage(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(runnable).start();
    }

    //подтверждение выбора
    private void showDialog() {
        Dialog dialog = new Dialog();
        dialog.show(getSupportFragmentManager(), "dialog1");
    }

    //находим двери
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

    //открываем дверь, если все двери открыты, то выкидываем последний диалог
    private synchronized void openDoor(Door door) {
        door.open();
        if (doors[0].isOpened() && doors[1].isOpened() && doors[2].isOpened()) {
            if (door.getContent() == 1) {
                showFinalDialog(true);
            } else showFinalDialog(false);
        }
    }

    //показываем финальный диалог
    private void showFinalDialog(boolean gameStatus) {
        FinalDialog finalDialog = new FinalDialog();
        Bundle bundle = new Bundle();
        bundle.putBoolean(GAME_STATUS_KEY, gameStatus);
        finalDialog.setArguments(bundle);
        finalDialog.show(getSupportFragmentManager(), "dialog2");
    }
}
