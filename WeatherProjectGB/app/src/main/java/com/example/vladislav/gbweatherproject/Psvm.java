package com.example.vladislav.gbweatherproject;

import android.annotation.SuppressLint;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Psvm {
    private static String KEY = "Bar12345Bar12345";
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        String s = "Hello world";
        byte[] bytes = s.getBytes();
        System.out.println(Arrays.toString(bytes));
        String b = Arrays.toString(bytes);

        @SuppressLint("GetInstance")
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec keySpec = new SecretKeySpec(KEY.getBytes(),"AES");
        cipher.init(Cipher.ENCRYPT_MODE,keySpec);
        byte [] bytes1 = cipher.doFinal(s.getBytes());
        System.out.println(Arrays.toString(bytes1));
        char [] chars = Arrays.toString(bytes1).toCharArray();
        System.out.println("ByteClass " + Arrays.toString(chars));
        for (Character c : chars) {
            System.out.print(c.charValue());
        }
        System.out.println("BYTE CLASS " + chars);
        Cipher cipher1 = Cipher.getInstance("AES");
        cipher1.init(Cipher.DECRYPT_MODE,keySpec);
        byte [] ourBytes = cipher1.doFinal(bytes1);
        String str = new String(ourBytes, "UTF-8");
        System.out.println(str);
    }
}
