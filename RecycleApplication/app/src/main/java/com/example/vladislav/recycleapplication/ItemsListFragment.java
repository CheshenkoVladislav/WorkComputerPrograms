package com.example.vladislav.recycleapplication;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vladislav.recycleapplication.Adapter.ItemAdapter;
import com.example.vladislav.recycleapplication.Adapter.MainPageAdapter;
import com.example.vladislav.recycleapplication.Data.Item;
import com.example.vladislav.recycleapplication.Data.ItemList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class ItemsListFragment extends Fragment {
    public static List<Item> itemList = new ArrayList<>();
    private static final String TAG = "ItemsListFragment";
    private ItemAdapter adapter = new ItemAdapter();
    RecyclerView recycler;
    Api api;
    private String type;
    private static final String TYPE_KEY = "type";
    FloatingActionButton fab;
    int REQUEST_CODE = 123;
    SwipeRefreshLayout refresh;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: I am");
        super.onCreate(savedInstanceState);
        api = App.getApi();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_items_list,container,false);
        return view;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recycler = view.findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recycler.setAdapter(adapter);
        addItems();
        fab = view.findViewById(R.id.fab);
        if (type == MainPageAdapter.TYPE_BALANCE)fab.hide();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),AddItemActivity.class);
                intent.putExtra(AddItemActivity.TYPE_KEY,type);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });
        refresh = view.findViewById(R.id.refresh);
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                addItems();
            }
        });
    }

    private void putItems() {
        for (int i = 0; i < 30; i++) {
            itemList.add(new Item());
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            Item newItem = (Item) data.getSerializableExtra("item");
            adapter.addItem(newItem);
            Log.d(TAG, "onActivityResult: " + newItem);
        }
    }

    public static ItemsListFragment createFragment(String type){
        ItemsListFragment fragment = new ItemsListFragment();
        fragment.type = type;
        return fragment;
    }
    private void addItems() {
        retrofit2.Call<ItemList> item = api.getItems(type); {
            item.enqueue(new Callback<ItemList>() {
                @Override
                public void onResponse(@NonNull retrofit2.Call<ItemList> call, @NonNull Response<ItemList> response) {
                    Log.d(TAG, "onResponse: " + response.body());
                    adapter.setData(response.body());
                    refresh.setRefreshing(false);
                }

                @Override
                public void onFailure(retrofit2.Call<ItemList>call, Throwable t) {
                    Log.d(TAG, "onFailure: FFFFAAAAIIILLL" + call.request() + t);
                }
            });
        }
    }
}
