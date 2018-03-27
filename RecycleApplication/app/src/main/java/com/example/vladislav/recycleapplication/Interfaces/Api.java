package com.example.vladislav.recycleapplication.Interfaces;

import com.example.vladislav.recycleapplication.Data.ItemList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by vladislav on 19.03.18.
 */

public interface Api {
    @GET("items")
    Call<ItemList> getItems(@Query("type")String type);
}
