package com.example.vladislav.recycleapplication;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vladislav.recycleapplication.Adapter.ItemAdapter;
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
    ItemList dataList = new ItemList();
    private String type = "expense";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: I am");
        super.onCreate(savedInstanceState);
        api = App.getApi();
        addItems();
        System.out.println(ItemAdapter.itemArrayList);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.items_list,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recycler = view.findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recycler.setAdapter(adapter);
    }

    public static ItemsListFragment createFragment(String type){
        ItemsListFragment fragment = new ItemsListFragment();
        fragment.type = type;
        return fragment;
    }

    private void addItems() {
        retrofit2.Call<ItemList> item = api.getItems("expense"); {
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
