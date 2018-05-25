package com.example.vladislav.gbweatherproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "ListViewActivity";
    List<String> listViewData;
    ListView listView;
    ArrayAdapter<String> adapter;
    DrawerLayout drawer;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        toolbar = findViewById(R.id.toolbar1);
//        setSupportActionBar(toolbar);
        setContentView(R.layout.activity_main);
        setDataForListView();
        initDrawer();
        initListView();
    }

    private void initDrawer() {
        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void initListView() {
        listView = findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(this,
                R.layout.list_view_item, listViewData);
        Log.d(TAG, "ADAPTER: " + adapter);
        listView.setAdapter(adapter);
        //Слушатель кликов по итемам
        listView.setOnItemClickListener((parent, view, position, id) -> showPopupMenu(view));
        //регистрация контекстного меню
//        registerForContextMenu(listView);

        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                Log.d(TAG, "onItemCheckedStateChanged: ");
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                getMenuInflater().inflate(R.menu.action_mode_menu, menu);
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_camera:
            case R.id.nav_gallery:
            case R.id.nav_manage:
            case R.id.nav_send:
            case R.id.nav_share:
            case R.id.nav_slideshow:
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.inflate(R.menu.popup_menu);
        popupMenu.show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_menu, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case (R.id.addItem):
//                addItem();
//                return true;
//            case (R.id.checkbox1):
//                Log.d(TAG, "onOptionsItemSelected: ");
//                if (!item.isChecked()) item.setChecked(true);
//                else item.setChecked(false);
//                return true;
//            case (R.id.checkbox2):
//                Log.d(TAG, "onOptionsItemSelected: ");
//                if (!item.isChecked()) item.setChecked(true);
//                else item.setChecked(false);
//                return true;
//
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

    private void setDataForListView() {
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
        listViewData.add(listViewData.size(), "ITEM_1");
        adapter.notifyDataSetChanged();
    }

}
