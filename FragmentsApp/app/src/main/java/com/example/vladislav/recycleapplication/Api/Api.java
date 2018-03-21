package com.example.vladislav.recycleapplication.Api;

import com.example.vladislav.recycleapplication.Data.ItemList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by vladislav on 19.03.18.
 */

public interface Api {
    @GET("items?type=expense")
    Call<ItemList> getItems();
}
