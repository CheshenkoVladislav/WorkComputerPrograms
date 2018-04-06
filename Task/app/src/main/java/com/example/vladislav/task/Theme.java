package com.example.vladislav.task;

import android.widget.ImageView;
import android.widget.TextView;

public class Theme {
    int id;
    int imageId;
    String numbers;
    String name;
    String text;


    public Theme(String numbers, String name, String text) {
        this.numbers = numbers;
        this.name = name;
        this.text = text;
    }
    public Theme(int image, String numbers, String name, String text) {
        this.imageId = image;
        this.numbers = numbers;
        this.name = name;
        this.text = text;
    }

    public int getImage() {
        return imageId;
    }

    public void setImage(int image) {
        this.imageId = image;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
