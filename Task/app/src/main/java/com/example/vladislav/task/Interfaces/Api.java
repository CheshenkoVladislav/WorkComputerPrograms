package com.example.vladislav.task.Interfaces;

import com.example.vladislav.task.Data.Posts;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("v1/me/feed")
    Call<Posts>getAllPosts();
}
