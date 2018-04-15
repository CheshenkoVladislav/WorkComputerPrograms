package com.example.vladislav.vkclient.Data;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.squareup.picasso.RequestCreator;

public class ImageData {
    int image1;
    int image2;

    public ImageData(int image1, @Nullable int image2) {
        this.image1 = image1;
        this.image2 = image2;
    }

    public int getImage1() {
        return image1;
    }

    public void setImage1(int image1) {
        this.image1 = image1;
    }

    public int getImage2() {
        return image2;
    }

    public void setImage2(int image2) {
        this.image2 = image2;
    }
}
