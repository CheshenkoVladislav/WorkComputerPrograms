package com.example.vladislav.vkclient.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vladislav.vkclient.Adapters.ViewPagerAdapter;
import com.example.vladislav.vkclient.Interfaces.additionalFunctions;
import com.example.vladislav.vkclient.R;


public class bigPhotoFragment extends Fragment {
    public int position;
    public String imageUrl;

    public additionalFunctions additionalFunctions;
    public void setAdditionalFunctions(com.example.vladislav.vkclient.Interfaces.additionalFunctions additionalFunctions) {
        this.additionalFunctions = additionalFunctions;}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_big_photo,container,false);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public static bigPhotoFragment createFragment(){
        bigPhotoFragment fragment = new bigPhotoFragment();

    }
}
