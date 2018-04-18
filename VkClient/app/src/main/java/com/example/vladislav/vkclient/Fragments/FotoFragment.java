package com.example.vladislav.vkclient.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vladislav.vkclient.Interfaces.LoadMorePhotos;
import com.example.vladislav.vkclient.Interfaces.Vk;
import com.example.vladislav.vkclient.Adapters.RecyclerViewAdapter;
import com.example.vladislav.vkclient.App;

import com.example.vladislav.vkclient.Data.Photo.PhotoRoot;
import com.example.vladislav.vkclient.R;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FotoFragment extends Fragment {
    RecyclerView recycler;
    SwipeRefreshLayout refresh;
    String [] filters = new String[]{"photo"};
    RecyclerViewAdapter adapter = new RecyclerViewAdapter();
    Vk vk;
    private static final String TAG = "FotoFragment";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_foto,container,false);
        return view;

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recycler = view.findViewById(R.id.recycler);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(view.getContext()));

        adapter.setLoadMorePhotos(new AdapterLoadMoreItems());
        vk = App.getVk();
        refresh = view.findViewById(R.id.refresh);
        dataInsert();
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                dataInsert();
            }
        });
    }

    private void dataInsert() {
        vk.getAllPhotos(0,App.ACCESS_TOKEN,App.VERSION).enqueue(new Callback<PhotoRoot>() {
            @Override
            public void onResponse(Call<PhotoRoot> call, Response<PhotoRoot> response) {
                adapter.setData(response.body().getResponse().getItems());
                Log.d(TAG, "PHOTO_GOOD_RESPONSE: " + response.body());
                refresh.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<PhotoRoot> call, Throwable t) {
                Log.d(TAG, "FAIL_RESPONSE: " + t.getMessage());
                refresh.setRefreshing(false);
            }
        });
    }

    public class AdapterLoadMoreItems implements LoadMorePhotos{

        @Override
        public void loadPhotos() {
            vk.getAllPhotos(adapter.packageUrls.size(),App.ACCESS_TOKEN,App.VERSION).enqueue(new Callback<PhotoRoot>() {
                @Override
                public void onResponse(Call<PhotoRoot> call, Response<PhotoRoot> response) {
                    adapter.loadMore(response.body().getResponse().getItems());
                    Log.d(TAG, "LOADING_SUCCESS : " + response.body());
                }

                @Override
                public void onFailure(Call<PhotoRoot> call, Throwable t) {

                }
            });
        }
    }
}
