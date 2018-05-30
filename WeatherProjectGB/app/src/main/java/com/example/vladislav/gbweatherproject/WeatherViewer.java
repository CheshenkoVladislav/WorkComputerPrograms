package com.example.vladislav.gbweatherproject;

import android.os.Bundle;
import android.os.Message;

import com.example.vladislav.gbweatherproject.Data.WeatherDataLoader;

public class WeatherViewer extends Thread {

    @Override
    public void run() {
        super.run();
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_WEATHER, WeatherDataLoader.getJsonResponse(city));
        Message message = new Message();
        message.setData(bundle);
        handler.sendMessage(message);
        interrupt();
    }

    }
}
