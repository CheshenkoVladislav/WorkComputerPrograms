package com.example.vladislav.task;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    ListView listView;
    String[] themes;
    DrawerLayout drawer;
    String typeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: MAIN ACTIVITY CREATED");
        FragmentItems fragment = new FragmentItems();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.id.fragmentContainer, fragment);
        ft.commit();

        setContentView(R.layout.activity_main);
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView = findViewById(R.id.listView);
        themes = getResources().getStringArray(R.array.themes);
        listView.setAdapter(new ArrayAdapter<>(this, R.layout.activity_item, R.id.textView, themes));

        drawer = findViewById(R.id.drawer_layout);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked");
                if (drawer.isDrawerOpen(GravityCompat.START))
                    drawer.closeDrawer(GravityCompat.START);
                else drawer.openDrawer(GravityCompat.START);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "onItemClick: ITEM CLICKED");
                FragmentItems fragment = FragmentItems.createFragment("Tech");
                toolbar.setTitle(themes[position]);
                Log.d(TAG, "onItemClick: " + themes[position]);
                drawer.closeDrawer(GravityCompat.START);
            }
        });
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        Intent intent = new Intent(this,SignInActivity.class);
//        startActivity(intent);
//    }
}
