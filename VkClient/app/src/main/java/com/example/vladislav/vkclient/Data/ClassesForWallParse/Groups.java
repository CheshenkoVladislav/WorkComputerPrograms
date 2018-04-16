package com.example.vladislav.vkclient.Data.ClassesForWallParse;

public class Groups {
    private int id;

    private String name;

    private String screen_name;

    private int is_closed;

    private String type;

    private int is_admin;

    private int is_member;

    private String photo_50;

    private String photo_100;

    private String photo_200;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setScreen_name(String screen_name){
        this.screen_name = screen_name;
    }
    public String getScreen_name(){
        return this.screen_name;
    }
    public void setIs_closed(int is_closed){
        this.is_closed = is_closed;
    }
    public int getIs_closed(){
        return this.is_closed;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public void setIs_admin(int is_admin){
        this.is_admin = is_admin;
    }
    public int getIs_admin(){
        return this.is_admin;
    }
    public void setIs_member(int is_member){
        this.is_member = is_member;
    }
    public int getIs_member(){
        return this.is_member;
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
    public void setPhoto_200(String photo_200){
        this.photo_200 = photo_200;
    }
    public String getPhoto_200(){
        return this.photo_200;
    }
}
