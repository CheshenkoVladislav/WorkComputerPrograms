package com.example.vladislav.task.Interfaces;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface Api {
    @Headers({"Accept: application/json",
            "Content-Type: application/json",
            "Authorization: Bearer 591f99547f569b05ba7d8777e2e0824eea16c440292cce1f8dfb3952cc9937ff",
            "Host: api.producthunt.com"})
    @GET("v1/me/feed")
    Call<String>getAllPosts();

    @Headers({"Accept: application/json",
            "Content-Type: application/json",
            "Authorization: Bearer 591f99547f569b05ba7d8777e2e0824eea16c440292cce1f8dfb3952cc9937ff",
            "Host: api.producthunt.com"})
    @GET("v1/categories/topic-4/posts")
    Call<String>getPostsForCategory();
}
