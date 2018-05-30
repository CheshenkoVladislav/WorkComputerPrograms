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
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vladislav.gbweatherproject.Data.Response;
import com.example.vladislav.gbweatherproject.Data.WeatherDataLoader;
import com.squareup.picasso.Picasso;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Objects;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import butterknife.BindView;
import butterknife.ButterKnife;

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
    private String city ;
    private Coder coder = new Coder();

    private String PREFS_NAME = "saveState";
    private String KEY_WEATHER = "status";
    private String KEY_CHECKBOX = "checkbotStatus";

    private boolean checkbox1;
    private boolean checkbox2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
}
    @Override
    protected void onPause() {
        super.onPause();
        saveState();
    }
    private void initUI() {
        ButterKnife.bind(this);
        initToolbar();
        initDrawer();
        initNavView();
        getCurrentCityWeather();
    }
    private void initToolbar() {
        setSupportActionBar(toolbar);
    }
    private void initNavView() {
        navigationView.setNavigationItemSelectedListener(this);
        loadAvatar();
    }
    private void loadAvatar() {
        Handler handler = new Handler();
        handler.post(new Avatar(getApplicationContext(),
                navigationView.getHeaderView(0).findViewById(R.id.imageView)));
    }
    private void initDrawer() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }
    private void getCurrentCityWeather() {
        if (getIntent().getStringExtra(Coder.KEY_CITY) != null) {
            city = getIntent().getStringExtra(Coder.KEY_CITY);
            renderJsonObj(city);
        }
        else if (!TextUtils.isEmpty(getState())){
            city = coder.decryptCurrentState(getState());
            renderJsonObj(city);
        }
    }
    private void saveState() {
        if (city != null) {
            getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
                    .edit()
                    .putString(Coder.KEY_CITY, coder.encryptState(city))
                    .apply();
        }
    }
    private String getState() {
        return getSharedPreferences(PREFS_NAME,MODE_PRIVATE)
                .getString(Coder.KEY_CITY,null);
    }

    private void downloadImage(ImageView imageView, String imageId) {
        String IMAGE_URL = "http://openweathermap.org/img/w/%s.png";
        Picasso.get()
                .load(String.format(IMAGE_URL, imageId))
                .into(imageView);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.addItem : {
                showSearchDialog();
                return true;
            }
            case R.id.variate1 : {
                if (!item.isChecked()) item.setChecked(true);
                else item.setChecked(false);
                return true;
            }
            case R.id.variate2 : {
                if (!item.isChecked()) item.setChecked(true);
                else item.setChecked(false);
                return true;
            }
        }
        return false;
    }
    private void showSearchDialog() {
        SearchCityDialog dialog = new SearchCityDialog();
        dialog.show(getSupportFragmentManager(), search_dialog);
    }
    @SuppressLint("HandlerLeak")
    private void renderJsonObj(String city) {
        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                Bundle bundle = msg.getData();
                Response response = (Response) bundle.getSerializable(KEY_WEATHER);
                if (response != null) {
                    setTextView(Objects.requireNonNull(response), tempTv, cityTv, weatherTv);
                    downloadImage(imageView, response.getWeather().get(0).getIcon());
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
    private void setTextView(Response response, TextView tempTv, TextView cityTv, TextView weatherTv) {
        tempTv.setText(String.valueOf(response.getMain().getTemp()) + " °C");
        cityTv.setText(response.getName());
        weatherTv.setText(response.getWeather().get(0).getDescription());
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
}
