package com.example.vladislav.gbweatherproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Environment;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Avatar extends Thread {
    private ImageView imageView;
    private Context context;
    private String file_name = "avatar.jpg";

    Avatar(Context context, ImageView imageView) {
        this.context = context;
        this.imageView = imageView;
    }

    @Override
    public void run() {
        saveToInternalStorage();
        loadAvatar(context.getFilesDir());
        interrupt();
    }

    private void saveToInternalStorage() {
        File dir = context.getFilesDir();
        boolean ifFileDirExist = dir.exists() || dir.mkdirs();
        if (ifFileDirExist) {
            saveBitmap(new File(dir, file_name));
        }
    }

    private void saveToExternalStorage() {
        File dir = context.getExternalFilesDir(Environment.DIRECTORY_DCIM);
        if (!isExternalStorageWrittable()) {
            showToast(context.getResources().getString(R.string.external_storage_not_writtable));
            return;
        }
        saveBitmap(new File(dir, file_name));
    }

    private void saveBitmap(File file) {
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            Bitmap bitmap = getImageViewBitmap();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showToast(String string) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
    }

    private boolean isExternalStorageWrittable() {
        String state = Environment.getExternalStorageState();
        return !Environment.MEDIA_MOUNTED.equals(state);
    }

    private Bitmap getImageViewBitmap() {
        return ((BitmapDrawable) imageView.getDrawable()).getBitmap();
    }

    private void loadAvatar(File fileDir) {
        File avatar = new File(fileDir, file_name);
        if (avatar.exists()) {
            Picasso
                    .get()
                    .load(avatar)
                    .into(imageView);
        }
    }
}
