package com.example.vladislav.doors;

import android.widget.ImageView;

public class Door{
    private static final String TAG = "Door";

    private int number;

    private ImageView door;
    public ImageView getDoor() {return door;}

    private boolean opened;
    public boolean isOpened() {return opened;}
    public void setOpened(boolean opened) {this.opened = opened;}

    private boolean selected;
    public void setSelected(boolean selected) { this.selected = selected; }
    public boolean isSelected() { return selected; }

    private int content;
    public int getContent() { return content; }

    private SelectListener listener;

    Door(ImageView door, int content, int number) {
        this.door = door;
        this.door.setImageResource(R.drawable.door_clise);
        this.content = content;
        this.number = number;
    }

    public void registerListener(SelectListener listener) {
        this.listener = listener;
    }

    public void startListen() {
        door.setOnClickListener(v -> {
            if (listener != null) {
                listener.onSelected(number);
            }
        });
    }

    public void open(){
        if (content != 1)
            door.setImageResource(R.drawable.door_with_sheep);
        else door.setImageResource(R.drawable.door_with_car);
        opened = true;
    }

    public interface SelectListener {
        void onSelected(int number);
    }
}
