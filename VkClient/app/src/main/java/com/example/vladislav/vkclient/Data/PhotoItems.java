package com.example.vladislav.vkclient.Data;

import java.util.List;

public class PhotoItems {
    private int id;

    private int album_id;

    private int owner_id;

    private List<PhotoSizes> sizes;

    private String text;

    private int date;

    private Likes likes;

    private int real_offset;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setAlbum_id(int album_id){
        this.album_id = album_id;
    }
    public int getAlbum_id(){
        return this.album_id;
    }
    public void setOwner_id(int owner_id){
        this.owner_id = owner_id;
    }
    public int getOwner_id(){
        return this.owner_id;
    }
    public void setSizes(List<PhotoSizes> sizes){
        this.sizes = sizes;
    }
    public List<PhotoSizes> getSizes(){
        return this.sizes;
    }
    public void setText(String text){
        this.text = text;
    }
    public String getText(){
        return this.text;
    }
    public void setDate(int date){
        this.date = date;
    }
    public int getDate(){
        return this.date;
    }
    public void setLikes(Likes likes){
        this.likes = likes;
    }
    public Likes getLikes(){
        return this.likes;
    }
    public void setReal_offset(int real_offset){
        this.real_offset = real_offset;
    }
    public int getReal_offset(){
        return this.real_offset;
    }
}
