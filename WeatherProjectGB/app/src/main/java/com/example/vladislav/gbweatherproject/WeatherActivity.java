package com.example.vladislav.gbweatherproject;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vladislav.gbweatherproject.Services.BindLoadWeatherService;
import com.example.vladislav.gbweatherproject.Services.LoadWeatherService;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt;

public class WeatherActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{
    private static final String search_dialog = "search_dialog";
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.temperature_tv)
    TextView tempTv;
    @BindView(R.id.city_tv)
    TextView cityTv;
    @BindView(R.id.status_tv)
    TextView weatherTv;
    @BindView(R.id.icon_weather)
    ImageView imageView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    Stater stater;
    public static final String KEY_WEATHER = "status";
    private static final String TAG = "WeatherActivity";
    MyBroadcastReciever br;
    BindLoadWeatherService myservice;
    ServiceConnection service;
    private boolean bind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: MAIN");
        setContentView(R.layout.activity_main);
        stater = (Stater) getApplication();
        initUI();
        service = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                myservice = ((BindLoadWeatherService.MyBinder)service).getService();
                Log.d(TAG, "onServiceConnected: " + myservice);
                bind = true;
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                bind = false;
                Log.d(TAG, "onServiceDisconnected: ");
            }
        };
        onBindService();

    }
    public void onBindService(){
        Log.d(TAG, "onBindService: ");
        if (!bind){
            bindService(new Intent(this,BindLoadWeatherService.class),
                    service,BIND_AUTO_CREATE);
        }
    }
    public void onUnbindService(){
        Log.d(TAG, "onUnbindService: ");
        if (bind){
            unbindService(service);
        }
    }

    private void registerBroadcastReciever() {
        br = new MyBroadcastReciever();
        IntentFilter intentFilter = new IntentFilter(
                LoadWeatherService.MY_INTENT_SERVICE);
        intentFilter.addCategory(Intent.CATEGORY_DEFAULT);
        registerReceiver(br,intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
        stater.saveState();
        unregisterReceiver(br);
        onUnbindService();
    }

    private void initUI() {
        ButterKnife.bind(this);
        initToolbar();
        initDrawer();
        initNavView();
        registerBroadcastReciever();
        initCurrentState();
        setFabHandler();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setFabHandler() {
        MaterialTapTargetPrompt mtp = new MaterialTapTargetPrompt.Builder(WeatherActivity.this)
                .setTarget(fab)
                .setPrimaryText("Share weather with you friends")
                .setSecondaryText("You can send sms for you friend about weather, just click on the button")
                .setBackgroundColour(getResources().getColor(R.color.colorTargetPrompt))
                .create();
        fab.setOnClickListener(v -> {
            Log.d(TAG, "CLICK!");
            shareWeather();
        });
        fab.setOnLongClickListener(v ->{
            if (mtp != null) {
                mtp.show();
            }
            return true;
        });
        fab.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_UP && mtp != null) {
                mtp.finish();
            }
            return false;
        });
    }

    private void shareWeather() {
        String message = "Now in " + cityTv.getText()  + " " + tempTv.getText() + " and " +
                weatherTv.getText();
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("sms:"));
        intent.putExtra("sms_body", message);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_FROM_BACKGROUND);
        startActivity(intent);
    }

    private void loadAvatar() {
        Handler handler = new Handler();
        handler.post(new Avatar(getApplicationContext(),
                navigationView.getHeaderView(0).findViewById(R.id.imageView)));
    }

    private void downloadImage(ImageView imageView, String imageId) {
        String IMAGE_URL = "http://openweathermap.org/img/w/%s.png";
        Picasso.get()
                .load(String.format(IMAGE_URL, imageId))
                .into(imageView);
    }
    ///////////////////INITS///////////////////

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

    private void initNavView() {
        navigationView.setNavigationItemSelectedListener(this);
        loadAvatar();
    }

    private void initCurrentState() {
        if (getIntent().getStringExtra(Stater.KEY_CITY) != null) {
            stater.setCity(getIntent().getStringExtra(Stater.KEY_CITY));
            Intent intent = new Intent(getBaseContext(),LoadWeatherService.class);
            intent.putExtra(Stater.KEY_CITY, getIntent().getStringExtra(Stater.KEY_CITY));
            startService(intent);
        } else if (stater.getCity() != null) {
            startService(new Intent(getBaseContext(),LoadWeatherService.class));
        }
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
        getMenuInflater().inflate(R.menu.actionbar_menu, menu);
        menu.getItem(1).setChecked(stater.checkbox1);
        menu.getItem(2).setChecked(stater.checkbox2);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addItem: {
                showSearchDialog();
                return true;
            }
            case R.id.variate1: {
                if (!item.isChecked()) item.setChecked(true);
                else item.setChecked(false);
                stater.checkbox1 = item.isChecked();
                return true;
            }
            case R.id.variate2: {
                if (!item.isChecked()) item.setChecked(true);
                else item.setChecked(false);
                stater.checkbox2 = item.isChecked();
                return true;
            }
        }
        return false;
    }
    @SuppressLint("SetTextI18n")
    void setInputData(String city, double temp, String weather, String icon){
        cityTv.setText(city);
        weatherTv.setText(weather);
        tempTv.setText(String.valueOf(temp) + "°C");
        downloadImage(imageView,icon);
    }

    private void showSearchDialog() {
        SearchCityDialog dialog = new SearchCityDialog();
        dialog.show(getSupportFragmentManager(), search_dialog);
    }
    class MyBroadcastReciever extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "onReceive: DATA");
            setInputData(intent.getStringExtra("CITY"),
                    intent.getExtras().getDouble("TEMP"),
                    intent.getStringExtra("WEATHER"),
                    intent.getStringExtra("ICON"));
        }
    }
}
