package com.example.vladislav.doors;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import java.util.Objects;

public class FinalDialog extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String title;
        if (Objects.requireNonNull(getArguments()).getBoolean(MainActivity.GAME_STATUS_KEY))
            title = "Победа!!!";
        else title = "Поражние(";
        return new AlertDialog.Builder(getContext())
                .setMessage(title + "\n Желаете еще?")
                .setPositiveButton("Да", (dialog1, which) -> {
                    Intent intent = new Intent(getContext(), MainActivity.class);
                    startActivity(intent);
                })
                .setNegativeButton("Нет", (dialog1, which) -> dismiss())
                .create();
    }
}
