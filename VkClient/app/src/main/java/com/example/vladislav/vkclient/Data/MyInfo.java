package com.example.vladislav.vkclient.Data;

import com.google.gson.annotations.SerializedName;

public class MyInfo {
    private String country;

    private int https_required;

    @SerializedName("2fa_required")
    private int fa2_required;

    private int own_posts_default;

    private int no_wall_replies;

    private int intro;

    private int lang;

    public void setCountry(String country){
        this.country = country;
    }
    public String getCountry(){
        return this.country;
    }
    public void setHttps_required(int https_required){
        this.https_required = https_required;
    }
    public int getHttps_required(){
        return this.https_required;
    }
    public void set2fa_required(int fa2_required){
        this.fa2_required = fa2_required;
    }
    public int get2fa_required(){
        return this.fa2_required;
    }
    public void setOwn_posts_default(int own_posts_default){
        this.own_posts_default = own_posts_default;
    }
    public int getOwn_posts_default(){
        return this.own_posts_default;
    }
    public void setNo_wall_replies(int no_wall_replies){
        this.no_wall_replies = no_wall_replies;
    }
    public int getNo_wall_replies(){
        return this.no_wall_replies;
    }
    public void setIntro(int intro){
        this.intro = intro;
    }
    public int getIntro(){
        return this.intro;
    }
    public void setLang(int lang){
        this.lang = lang;
    }
    public int getLang(){
        return this.lang;
    }
}