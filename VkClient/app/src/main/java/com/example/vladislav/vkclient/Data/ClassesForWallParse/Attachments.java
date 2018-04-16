package com.example.vladislav.vkclient.Data.ClassesForWallParse;

public class Attachments {
    private String type;

    private Root.Photo photo;

    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public void setPhoto(Root.Photo photo){
        this.photo = photo;
    }
    public Root.Photo getPhoto(){
        return this.photo;
    }
}
