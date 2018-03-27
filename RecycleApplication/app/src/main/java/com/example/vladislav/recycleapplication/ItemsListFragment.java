package com.example.vladislav.recycleapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.vladislav.recycleapplication.Adapter.ItemAdapter;
import com.example.vladislav.recycleapplication.Adapter.MainPageAdapter;
import com.example.vladislav.recycleapplication.Data.Item;
import com.example.vladislav.recycleapplication.Data.ItemList;
import com.example.vladislav.recycleapplication.Interfaces.AdapterListenerInterface;
import com.example.vladislav.recycleapplication.Interfaces.Api;
import com.example.vladislav.recycleapplication.SupportClasses.App;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class ItemsListFragment extends Fragment {
    public static List<Item> itemList = new ArrayList<>();
    private static final String TAG = "ItemsListFragment";
    public static ItemAdapter adapter = new ItemAdapter();
    RecyclerView recycler;
    FloatingActionButton fab;
    SwipeRefreshLayout refresh;
    Api api;
    private String type;
    private static final String TYPE_KEY = "type";
    int REQUEST_CODE = 123;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: I am");
        super.onCreate(savedInstanceState);
        api = App.getApi();
        adapter.setListener(new AdapterListener());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_items_list, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recycler = view.findViewById(R.id.recycler);
        fab = view.findViewById(R.id.fab);
        refresh = view.findViewById(R.id.refresh);
        recycler.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recycler.setAdapter(adapter);
        addItems();
        if (type == MainPageAdapter.TYPE_BALANCE) fab.hide();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), AddItemActivity.class);
                intent.putExtra(AddItemActivity.TYPE_KEY, type);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
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

    public static ItemsListFragment createFragment(String type) {
        ItemsListFragment fragment = new ItemsListFragment();
        fragment.type = type;
        return fragment;
    }

    private void addItems() {
        retrofit2.Call<ItemList> item = api.getItems(type);
        {
            item.enqueue(new Callback<ItemList>() {
                @Override
                public void onResponse(@NonNull retrofit2.Call<ItemList> call, @NonNull Response<ItemList> response) {
                    Log.d(TAG, "onResponse: " + response.body());
                    adapter.setData(response.body());
                    refresh.setRefreshing(false);
                    if (actionMode != null)actionMode.finish();
                    adapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(retrofit2.Call<ItemList> call, Throwable t) {
                    Log.d(TAG, "onFailure: FFFFAAAAIIILLL" + call.request() + t);
                    refresh.setRefreshing(false);
                }
            });
        }
    }
                              /* ACTION MODE */


    public ActionMode getActionMode() {
        return actionMode;
    }

    ActionMode actionMode;
    Button deleteBtn;
    public class AdapterListener implements AdapterListenerInterface {
        private static final String TAG = "AdapterListener";

        @Override
        public void onClickListener(Item item, int position) {
            System.out.println("" + item + adapter.getItemArrayList());
            if (onActionMode()) toggleSelection(position);
        }

        @Override
        public void onLongClickListener(Item item, int position) {
            if (onActionMode()) return;
            toggleSelection(position);
            actionMode = ((AppCompatActivity)getActivity()).startSupportActionMode(callback);
        }
        private ActionMode.Callback callback = new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                actionMode = mode;
                MenuInflater inflater = new MenuInflater(getContext());
                inflater.inflate(R.menu.menu,menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.delete_ic:{removeSelectionsItem();
                            }
                        }
                        return true;
                    }
                });
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                actionMode = null;
                adapter.clearSelections();
            }
        };
        private boolean onActionMode() {
            return actionMode != null;
        }

        public void toggleSelection(int position) {
            adapter.toggleSelection(position);
        }
        public void removeSelectionsItem(){
            for (int i = adapter.getSelectedItems().size()-1; i >= 0; i--) {
                adapter.remove(adapter.getSelectedItems().get(i));
            }
        }
    }
}
