package com.example.vladislav.gbweatherproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.toolbar1)
    Toolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.listView)
    ListView listView;
    private List<String> listViewData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initUi();
    }

    private void initUi() {
        initToolbar();
        setDataForListView();
        initListView();
        initDrawer();
        initNavView();
    }

    private void initNavView() {
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
    }
    private void initDrawer() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }
    private void initListView() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.list_view_item, listViewData);
        listView.setAdapter(adapter);
//        registerForContextMenu(listView);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_menu_main_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case (R.id.checkbox1):
                if (!item.isChecked()) item.setChecked(true);
                else item.setChecked(false);
                return true;
            case (R.id.checkbox2):
                if (!item.isChecked()) item.setChecked(true);
                else item.setChecked(false);
                return true;
        }
        return false;
    }
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
}
