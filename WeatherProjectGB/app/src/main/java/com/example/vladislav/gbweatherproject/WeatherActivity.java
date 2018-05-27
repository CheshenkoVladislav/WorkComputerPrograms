package com.example.vladislav.gbweatherproject;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherActivity extends AppCompatActivity {
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
    private String KEY_WEATHER = "status";
    private String city;
    private String PREFS_NAME = "saveState";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
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
        getCurrentCityWeather();
    }
    private void getCurrentCityWeather() {
        if (getIntent().getStringExtra(SearchCityDialog.CITY_KEY) != null) {
            city = getIntent().getStringExtra(SearchCityDialog.CITY_KEY);
            renderJsonObj(city);
        }
        else if (!TextUtils.isEmpty(getState())){
            city = getState();
            renderJsonObj(city);
        }
    }
    private void saveState() {
            getSharedPreferences(PREFS_NAME,MODE_PRIVATE)
                    .edit()
                    .putString(SearchCityDialog.CITY_KEY,city)
                    .apply();
    }
    private String getState() {
        return getSharedPreferences(PREFS_NAME,MODE_PRIVATE)
                .getString(SearchCityDialog.CITY_KEY,null);
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
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
        showSearchDialog();
        return true;
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
                setTextView(Objects.requireNonNull(response), tempTv, cityTv, weatherTv);
                downloadImage(imageView, response.getWeather().get(0).getIcon());
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
            }
        }.start();
    }
    @SuppressLint("SetTextI18n")
    private void setTextView(Response response, TextView tempTv, TextView cityTv, TextView weatherTv) {
        tempTv.setText(String.valueOf(response.getMain().getTemp()) + " °C");
        cityTv.setText(response.getName());
        weatherTv.setText(response.getWeather().get(0).getDescription());
    }
}
