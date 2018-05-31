package com.example.vladislav.gbweatherproject;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.EditText;

import java.util.Objects;

public class SearchCityDialog extends DialogFragment {
    private EditText view;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        view = new EditText(getContext());
        AlertDialog dialog = new AlertDialog.Builder(getContext())
                .setTitle("Set city")
                .setView(view)
                .setPositiveButton("Select", (dialog1, which) ->
                        setCityAndStartNewIntent(String.valueOf(view.getText())))
                .create();
        //Set appear animation
        Objects.requireNonNull(dialog.getWindow()).
                getAttributes().windowAnimations = R.style.DialogAnimation;
        return dialog;
    }

    private void setCityAndStartNewIntent(String city) {
        Intent intent = new Intent(getActivity(), WeatherActivity.class);
        intent.putExtra(Coder.KEY_CITY, city);
        startActivity(intent);
    }
}
