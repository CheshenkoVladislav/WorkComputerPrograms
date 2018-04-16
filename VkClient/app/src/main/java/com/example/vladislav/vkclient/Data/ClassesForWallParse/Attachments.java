package com.example.vladislav.vkclient.Data.ClassesForWallParse;

public class Attachments {
    private String type;

    private Photo photo;

    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public void setPhoto(Photo photo){
        this.photo = photo;
    }
    public Photo getPhoto(){
        return this.photo;
    }
}
