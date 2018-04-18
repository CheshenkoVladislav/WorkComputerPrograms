package com.example.vladislav.vkclient.API;

import com.example.vladislav.vkclient.Data.Album.AlbumRoot;
import com.example.vladislav.vkclient.Data.ClassesForWallParse.Root;
import com.example.vladislav.vkclient.Data.NewsFeed.NewsfeedRoot;
import com.example.vladislav.vkclient.Data.Photo.PhotoRoot;
import com.example.vladislav.vkclient.Data.ProfilesPack.ProfileInfoRoot;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Vk {
    @GET("photos.get")
    Call<String> getFoto(@Query("owner_id")int id,@Query("album_id")int idAlbum, @Query("access_token")String token, @Query("v")String v);

    @GET("account.getInfo")
    Call<ProfileInfoRoot>getInfo(@Query("access_token")String token, @Query("v")String v);

    //Не Работает
    @GET("photos.getAll")
    Call<PhotoRoot>getAllPhotos(@Query("access_token")String token,@Query("v")String v);

    @GET("photos.getAlbums")
    Call<AlbumRoot>getAlbums(@Query("owner_id")int id, @Query("access_token")String token, @Query("v")String v);

    @POST("newsfeed.get")
    Call<NewsfeedRoot>getNewsFeed(@Query("filters")String[]filters, @Query("count")int count, @Query("access_token")String token, @Query("v")String v);
    @GET("wall.get")
    Call<Root>getWall(@Query("filters")String[]filters, @Query("count")int count, @Query("access_token")String token, @Query("v")String v);
}