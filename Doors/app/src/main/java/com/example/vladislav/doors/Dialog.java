package com.example.vladislav.doors;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

public class Dialog extends DialogFragment {
    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog dialog = new AlertDialog.Builder(getContext())
                .setTitle("Подтверждение")
                .setMessage("Может изменить выбор?")
                .setPositiveButton("Да", (dialog1, which) -> {

                })
                .setNegativeButton("Нет", (dialog12, which) -> {

                })
                .create();
        return dialog;
    }

}
