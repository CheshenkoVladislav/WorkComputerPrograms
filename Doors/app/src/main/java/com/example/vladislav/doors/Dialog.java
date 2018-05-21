package com.example.vladislav.doors;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import java.util.Objects;

public class Dialog extends DialogFragment {
    private static final String TAG = "Dialog";
    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(Objects.requireNonNull(getContext()))
                .setTitle("Подтверждение")
                .setMessage("Может изменить выбор?")
                .setPositiveButton("Да", (dialog1, which) -> {
                    ((MainActivity) Objects.requireNonNull(getActivity())).doors[0]
                            .setSelected(false);
                    ((MainActivity) getActivity()).doors[1]
                            .setSelected(false);
                    ((MainActivity) getActivity()).doors[2]
                            .setSelected(false);
                    Log.d(TAG, "YES");
                    dismiss();
                })
                .setNegativeButton("Нет", (dialog12, which) -> Log.d(TAG, "NO"))
                .create();
    }

}
