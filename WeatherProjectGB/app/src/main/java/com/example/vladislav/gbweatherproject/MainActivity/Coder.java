package com.example.vladislav.gbweatherproject.MainActivity;

import android.annotation.SuppressLint;
import android.util.Base64;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Coder {
    private static final String KEY = "B2fdgsdgi3bgn283";

    public String encryptState(String city) {
        String encryptString = null;
        try {
            @SuppressLint("GetInstance")
            Cipher encryptor = Cipher.getInstance("AES");
            SecretKeySpec key = new SecretKeySpec(KEY.getBytes(), "AES");
            encryptor.init(Cipher.ENCRYPT_MODE, key);
            encryptString = Base64.encodeToString(encryptor.doFinal(city.getBytes()), Base64.NO_WRAP);
        } catch (NoSuchAlgorithmException |
                NoSuchPaddingException |
                InvalidKeyException |
                BadPaddingException |
                IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return encryptString;
    }

    public String decryptCurrentState(String city) {
        String decryptedCity = null;
        try {
            @SuppressLint("GetInstance")
            Cipher decryptor = Cipher.getInstance("AES");
            SecretKeySpec key = new SecretKeySpec(KEY.getBytes(), "AES");
            decryptor.init(Cipher.DECRYPT_MODE, key);
            decryptedCity = new String(decryptor.doFinal(Base64.decode(city, Base64.NO_WRAP)));
            System.out.println("DECRYPT " + decryptedCity);
        } catch (NoSuchAlgorithmException |
                NoSuchPaddingException |
                InvalidKeyException |
                BadPaddingException |
                IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return decryptedCity;
    }
}
