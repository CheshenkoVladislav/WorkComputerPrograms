package com.example.vladislav.vkclient.Data.ProfilesPack;

public class Profiles {
    private int id;

    private String first_name;

    private String last_name;

    private int sex;

    private String screen_name;

    private String photo_50;

    private String photo_100;

    private int online;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setFirst_name(String first_name){
        this.first_name = first_name;
    }
    public String getFirst_name(){
        return this.first_name;
    }
    public void setLast_name(String last_name){
        this.last_name = last_name;
    }
    public String getLast_name(){
        return this.last_name;
    }
    public void setSex(int sex){
        this.sex = sex;
    }
    public int getSex(){
        return this.sex;
    }
    public void setScreen_name(String screen_name){
        this.screen_name = screen_name;
    }
    public String getScreen_name(){
        return this.screen_name;
    }
    public void setPhoto_50(String photo_50){
        this.photo_50 = photo_50;
    }
    public String getPhoto_50(){
        return this.photo_50;
    }
    public void setPhoto_100(String photo_100){
        this.photo_100 = photo_100;
    }
    public String getPhoto_100(){
        return this.photo_100;
    }
    public void setOnline(int online){
        this.online = online;
    }
    public int getOnline(){
        return this.online;
    }
}
