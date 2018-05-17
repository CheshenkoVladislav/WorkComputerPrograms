package com.example.vladislav.gbweatherproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {
    private static final String TAG = "ListViewActivity";
    List<String> listViewData;
    ListView listView;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        setDataForListView();
        initListView();
    }
    private void initListView() {
        listView = findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(this,
                R.layout.item_listview, listViewData);
        listView.setAdapter(adapter);
        //Слушатель кликов по итемам
        listView.setOnItemClickListener((parent, view, position, id) -> {
            showPopupMenu(view); });
        //регистрация контекстного меню
//        registerForContextMenu(listView);

        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                Log.d(TAG, "onItemCheckedStateChanged: ");
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                getMenuInflater().inflate(R.menu.action_mode_menu,menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });

        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
    }

    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.inflate(R.menu.popup_menu);
        popupMenu.show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case (R.id.addItem) :
                addItem();
                return true;
            case (R.id.checkbox1) :
                Log.d(TAG, "onOptionsItemSelected: ");
                if (!item.isChecked()) item.setChecked(true);
                else item.setChecked(false);
                return true;
            case (R.id.checkbox2) :
                Log.d(TAG, "onOptionsItemSelected: ");
                if (!item.isChecked()) item.setChecked(true);
                else item.setChecked(false);
                return true;

            default : return super.onOptionsItemSelected(item);
        }
    }

    private void setDataForListView(){
        listViewData = new ArrayList<>();
        listViewData.add("ITEM_1");
        listViewData.add("ITEM_1");
        listViewData.add("ITEM_1");
        listViewData.add("ITEM_1");
        listViewData.add("ITEM_1");
        listViewData.add("ITEM_1");
        listViewData.add("ITEM_1");
        listViewData.add("ITEM_1");
        listViewData.add("ITEM_1");
    }

    private void addItem() {
        listViewData.add(listViewData.size(),"ITEM_1");
        adapter.notifyDataSetChanged();
    }
}
