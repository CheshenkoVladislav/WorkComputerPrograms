package com.example.vladislav.recycleapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.vladislav.recycleapplication.Adapter.ItemAdapter;
import com.example.vladislav.recycleapplication.Api.Api;
import com.example.vladislav.recycleapplication.Api.App;
import com.example.vladislav.recycleapplication.Data.Item;
import com.example.vladislav.recycleapplication.Data.ItemList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class ItemsListActivity extends AppCompatActivity {
    public static List<Item> itemList = new ArrayList<>();
    private static final String TAG = "ItemsListActivity";
    private ItemAdapter adapter = new ItemAdapter();
    RecyclerView recycler;
    Api api;
    ItemList dataList = new ItemList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: I am");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.items_list);
        api = App.getApi();
        addItems();
        System.out.println(ItemAdapter.itemArrayList);
        recycler = findViewById(R.id.recycler);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));
    }

    private void addItems() {
        retrofit2.Call<ItemList> item = api.getItems(); {
            item.enqueue(new Callback<ItemList>() {
                @Override
                public void onResponse(retrofit2.Call<ItemList> call, Response<ItemList> response) {
                    Log.d(TAG, "onResponse: " + response.body());
                    adapter.setData(response.body());
                }

                @Override
                public void onFailure(retrofit2.Call<ItemList>call, Throwable t) {
                    Log.d(TAG, "onFailure: FFFFAAAAIIILLL" + call.request() + t);
                }
            });
        }
    }
}
