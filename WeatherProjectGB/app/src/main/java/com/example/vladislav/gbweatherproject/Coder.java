package com.example.vladislav.gbweatherproject;

import android.annotation.SuppressLint;
import android.app.Application;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import static android.content.Context.MODE_PRIVATE;

public class Coder extends Application {
    private String city;
    private String KEY = "B2fdgsdgi3bgn283";
    private String KEY_WEATHER = "status";
    private String PREFS_NAME = "saveState";
    public Coder(String city){
        this.city = city;
    }

    private void encryptState() {
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    @SuppressLint("GetInstance")
                    Cipher encryptor = Cipher.getInstance("AES");
                    SecretKeySpec key = new SecretKeySpec(KEY.getBytes(),"AES");
                    encryptor.init(Cipher.ENCRYPT_MODE, key);
                    getSharedPreferences(PREFS_NAME,MODE_PRIVATE)
                            .edit();
                } catch (NoSuchAlgorithmException
                        | NoSuchPaddingException
                        | InvalidKeyException e) {
                    e.printStackTrace();
                }
            }
        };
    }
    private String decryptByre(){
        try {
            @SuppressLint("GetInstance")
            Cipher decryptor = Cipher.getInstance("AES");
            SecretKeySpec key = new SecretKeySpec(KEY.getBytes(),"AES");
            decryptor.init(Cipher.DECRYPT_MODE, key);
        } catch (NoSuchAlgorithmException
                | NoSuchPaddingException
                | InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }
}
