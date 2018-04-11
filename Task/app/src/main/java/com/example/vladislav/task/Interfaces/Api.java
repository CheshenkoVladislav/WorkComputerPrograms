package com.example.vladislav.task.Interfaces;

import com.example.vladislav.task.Data.Posts;
import com.example.vladislav.task.Data.TokenRequest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {
    @Headers({"Accept: application/json",
            "Content-Type: application/json",
            "Authorization: Bearer 591f99547f569b05ba7d8777e2e0824eea16c440292cce1f8dfb3952cc9937ff",
            "Host: api.producthunt.com"})
    @GET("v1/me/feed")
    Call<Posts>getAllPosts();

    @Headers({"Accept: application/json",
            "Content-Type: application/json",
            "Authorization: Bearer 591f99547f569b05ba7d8777e2e0824eea16c440292cce1f8dfb3952cc9937ff",
            "Host: api.producthunt.com"})
    @GET("v1/categories/topic-4/posts")
    Call<String>getPostsForCategory();

    @Headers({"Accept: application/json",
            "Content-Type: application/json",
            "Host: api.producthunt.com"})
    @POST("v1/oauth/token")
    Call<TokenRequest>getToken(@Query("client_id")String id,@Query("client_secret")String secret,@Query("grant_type")String type);


    @GET("v1/docs")
    Call<String>getDocs();
}
