package com.example.vladislav.vkclient.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vladislav.vkclient.API.Vk;
import com.example.vladislav.vkclient.Adapters.RecyclerViewAdapter;
import com.example.vladislav.vkclient.App;
import com.example.vladislav.vkclient.Data.AlbumRoot;
import com.example.vladislav.vkclient.Data.PhotoRoot;
import com.example.vladislav.vkclient.Data.ProfileInfoRoot;
import com.example.vladislav.vkclient.R;
import com.example.vladislav.vkclient.SignInActivity;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FotoFragment extends Fragment{
    RecyclerView recycler;
    RecyclerViewAdapter adapter = new RecyclerViewAdapter();
    private static final String TAG = "FotoFragment";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_foto,container,false);
        adapter.fillingList();
        return view;

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recycler = view.findViewById(R.id.recycler);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(view.getContext()));
        Vk vk = App.getVk();
    }
}
