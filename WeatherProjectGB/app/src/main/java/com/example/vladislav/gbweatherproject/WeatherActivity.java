package com.example.vladislav.gbweatherproject;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.vladislav.gbweatherproject.Data.Response;
import com.example.vladislav.gbweatherproject.Data.WeatherDataLoader;
import com.example.vladislav.gbweatherproject.Data.WeatherItem;
import com.google.gson.Gson;

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
        Handler handler = new Handler(){
        @Override
         public void handleMessage(Message msg) {
         TextView temp = findViewById(R.id.temperature_tv);
         TextView city = findViewById(R.id.city_tv);
         TextView weather = findViewById(R.id.status_tv);

         Bundle bundle = msg.getData();
         temp.setText((int)((Response)bundle.getSerializable(KEY_WEATHER)).getMain().getTemp());
//         city.setText(bundle.getString(KEY_CITY));
//         weather.setText(bundle.getString(KEY_WEATHER));
        }};
        new Thread(){
            @Override
            public void run() {
                Response response = WeatherDataLoader.getJsonResponse(city);
                Bundle bundle = new Bundle();
                bundle.putSerializable(KEY_WEATHER,response);
                Message message = new Message();
                message.setData(bundle);
                handler.sendMessage(message);
            }
        }.start();
    }
}
