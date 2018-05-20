package com.example.vladislav.doors;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class Door{
    private static final String TAG = "Door";
    private ImageView door;

    private boolean selected;
    public void setSelected(boolean selected) { this.selected = selected; }
    public boolean isSelected() { return selected; }

    private int content;
    public int getContent() { return content; }
    Door(ImageView door, int content){
        this.door = door;
        this.door.setImageResource(R.drawable.door_clise);
        this.content = content;
    }
    public void open(){
        if (content != 1)
            door.setImageResource(R.drawable.door_with_sheep);
        else door.setImageResource(R.drawable.door_with_car);
    }
}
