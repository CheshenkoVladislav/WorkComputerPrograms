package com.example.vladislav.gbweatherproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class Avatar {
    private ImageView imageView;
    private Context context;

    Avatar(Context context, ImageView imageView) {
        this.context = context;
        this.imageView = imageView;
    }

    public void saveImageToInternalStorage() {
        new Thread() {
            private static final String FILE_NAME = "avatar";
            @Override
            public void run() {
                super.run();
                File dir = context.getFilesDir();
                boolean isFileExist = dir.exists() || dir.mkdirs();
                if (isFileExist) {
                    try {
                        File file = new File(dir.getPath(),FILE_NAME);
                        FileOutputStream outputStream = new FileOutputStream(file);
                        Bitmap bitmap = context.getDrawable()
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 85, outputStream);
                        outputStream.flush();
                        outputStream.close();
                        interrupt();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
