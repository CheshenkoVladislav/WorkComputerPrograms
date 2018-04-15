package com.example.vladislav.vkclient.API;

import com.example.vladislav.vkclient.Data.AlbumRoot;
import com.example.vladislav.vkclient.Data.PhotoRoot;
import com.example.vladislav.vkclient.Data.ProfileInfoRoot;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Vk {
    @GET("photos.get")
    Call<String> getFoto(@Query("access_token")String token,@Query("v")String v,@Query("owner_id")int id,@Query("album_id")int idAlbum);

    @GET("account.getInfo")
    Call<ProfileInfoRoot>getInfo(@Query("access_token")String token, @Query("v")String v);

    //Не Работает
    @GET("photos.getAll")
    Call<PhotoRoot>getAllPhotos(@Query("access_token")String token,@Query("v")String v);

    @GET("photos.getAlbums")
    Call<AlbumRoot>getAlbums(@Query("access_token")String token,@Query("v")String v,@Query("owner_id")int id);
}
