package com.example.vladislav.gbweatherproject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vladislav.gbweatherproject.DB.WeatherDataBaseConnector;
import com.example.vladislav.gbweatherproject.Data.Response;
import com.squareup.picasso.Picasso;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
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
    private static final String KEY_WEATHER = "status";
    Stater stater;
    private static final String TAG = "WeatherActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stater = new Stater();
        initUI();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
        stater.saveState();
    }

    private void initUI() {
        ButterKnife.bind(this);
        initToolbar();
        initDrawer();
        initNavView();
        initCurrentState();
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
            renderJsonObj(stater.getCity());
        } else if (stater.getCity() != null) {
            renderJsonObj(stater.getCity());
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

    @SuppressLint("HandlerLeak")
    private void renderJsonObj(String city) {
        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                Bundle bundle = msg.getData();
                Response response = (Response) bundle.getSerializable(KEY_WEATHER);
                if (response != null) {
                    setInputData(Objects.requireNonNull(response), tempTv, cityTv, weatherTv);
                }
            }
        };
        new Thread() {
            @Override
            public void run() {
                Bundle bundle = new Bundle();
                bundle.putSerializable(KEY_WEATHER, WeatherDataLoader.getJsonResponse(city));
                Message message = new Message();
                message.setData(bundle);
                handler.sendMessage(message);
                interrupt();
            }
        }.start();
    }

    @SuppressLint("SetTextI18n")
    private void setInputData(Response response, TextView tempTv, TextView cityTv, TextView weatherTv) {
        String city = response.getName();
        String description = response.getWeather().get(0).getDescription();
        double temp = response.getMain().getTemp();
        String icon = response.getWeather().get(0).getIcon();
        cityTv.setText(city);
        weatherTv.setText(description);
        tempTv.setText(String.valueOf(temp) + " °C");
        downloadImage(imageView, response.getWeather().get(0).getIcon());
        //Add to Data Base//
        addToDataBase(city, description, temp, icon);
    }

    private void addToDataBase(String city, String description, double temp, String icon) {
        WeatherDataBaseConnector connector = new WeatherDataBaseConnector(this);
        connector.open();
        connector.addWeather(city, description, temp, icon);
        connector.close();
    }

    private void showSearchDialog() {
        SearchCityDialog dialog = new SearchCityDialog();
        dialog.show(getSupportFragmentManager(), search_dialog);
    }

}