package com.example.vladislav.task;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.JsonReader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vladislav.task.Data.Posts;
import com.example.vladislav.task.Interfaces.Api;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentItems extends Fragment {
    private String type = "Tech";
    AdapterRV adapter = new AdapterRV();
    RecyclerView recycler;
    private static final String TAG = "FragmentItems";
    public void setType(String type) {this.type = type;}
    public String getType() {return type;}
    Toolbar toolbar;
    Api api;
    JsonReader jsonReader;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        api = RetrofitClass.getApi();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_items,container,false);
        Log.d(TAG, "onCreateView: FRAGMENT CREATED");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recycler = view.findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler.setAdapter(adapter);
        Log.d(TAG, "onViewCreated: api :" + api);
        requestTypeData();
//        requestData();
//        requestDocs();
    }

    public static FragmentItems createFragment(String type){
        FragmentItems fragment = new FragmentItems();
        fragment.setType(type);
        return fragment;
    }

    private void requestTypeData() {
        api.getPostsForCategory().enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d(TAG, "ACCEPT_RESPONSE: " + response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d(TAG, "FAIL_RESPONSE: " + t.getMessage());
            }
        });
    }

    private void requestDocs(){
        api.getDocs().enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }

    private void requestData() {
        api.getAllPosts().enqueue(new Callback<Posts>() {
            @Override
            public void onResponse(Call<Posts> call, Response<Posts> response) {
                Log.d(TAG, "ACCESS_RESPONSE: " + "\nresponse : " + response.body()
                        + "\nstatus: " + response);
            }

            @Override
            public void onFailure(Call<Posts> call, Throwable t) {
                Log.d(TAG, "FAIL_RESPONSE: " + t.getMessage());
            }
        });
    }
}
