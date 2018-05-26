package com.example.vladislav.gbweatherproject;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vladislav.gbweatherproject.Data.Response;
import com.example.vladislav.gbweatherproject.Data.WeatherDataLoader;
import com.example.vladislav.gbweatherproject.Data.WeatherItem;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherActivity extends AppCompatActivity {

    private static final String search_dialog = "search_dialog";
    private String KEY_WEATHER = "status";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initUI();
    }

    private void initUI() {
        if (getIntent().getStringExtra(SearchCityDialog.CITY_KEY) != null){
            String city = getIntent().getStringExtra(SearchCityDialog.CITY_KEY);
            renderJsonObj(city);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_menu,menu);
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
    private void renderJsonObj(String city){
        TextView tempTv = findViewById(R.id.temperature_tv);
        TextView cityTv = findViewById(R.id.city_tv);
        TextView weatherTv = findViewById(R.id.status_tv);
        ImageView imageView = findViewById(R.id.icon_weather);

        Handler handler = new Handler(){
        @SuppressLint("SetTextI18n")
        @Override
         public void handleMessage(Message msg) {
            Bundle bundle = msg.getData();
            Response response = (Response) bundle.getSerializable(KEY_WEATHER);
            tempTv.setText(String.valueOf(response.getMain().getTemp()) + " °C");
            cityTv.setText(response.getName());
            weatherTv.setText(response.getWeather().get(0).getDescription());
            downloadImage(imageView,response.getWeather().get(0).getIcon());
            System.out.println(response.getWeather().get(0).getIcon());
        }};
        new Thread(){
            @Override
            public void run() {
                System.out.println(WeatherDataLoader.getJsonResponse(city).getId());
                Bundle bundle = new Bundle();
                bundle.putSerializable(KEY_WEATHER,WeatherDataLoader.getJsonResponse(city));
                Message message = new Message();
                message.setData(bundle);
                handler.sendMessage(message);
            }
        }.start();
    }

    private void downloadImage(ImageView imageView,String imageId) {
        Picasso.get()
                .load(String.format("http://openweathermap.org/img/w/%s.png",imageId))
                .into(imageView);
    }
}
