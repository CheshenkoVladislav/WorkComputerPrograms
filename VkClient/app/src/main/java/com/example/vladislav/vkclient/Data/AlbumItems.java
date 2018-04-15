package com.example.vladislav.vkclient.Data;

import java.util.List;

public class AlbumItems {
    private int id;

    private int thumb_id;

    private int owner_id;

    private String title;

    private String description;

    private int created;

    private int updated;

    private int size;

    private int thumb_is_last;

    private List<String> privacy_view;

    private List<String> privacy_comment;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setThumb_id(int thumb_id){
        this.thumb_id = thumb_id;
    }
    public int getThumb_id(){
        return this.thumb_id;
    }
    public void setOwner_id(int owner_id){
        this.owner_id = owner_id;
    }
    public int getOwner_id(){
        return this.owner_id;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
    public void setCreated(int created){
        this.created = created;
    }
    public int getCreated(){
        return this.created;
    }
    public void setUpdated(int updated){
        this.updated = updated;
    }
    public int getUpdated(){
        return this.updated;
    }
    public void setSize(int size){
        this.size = size;
    }
    public int getSize(){
        return this.size;
    }
    public void setThumb_is_last(int thumb_is_last){
        this.thumb_is_last = thumb_is_last;
    }
    public int getThumb_is_last(){
        return this.thumb_is_last;
    }
    public void setPrivacy_view(List<String> privacy_view){
        this.privacy_view = privacy_view;
    }
    public List<String> getPrivacy_view(){
        return this.privacy_view;
    }
    public void setPrivacy_comment(List<String> privacy_comment){
        this.privacy_comment = privacy_comment;
    }
    public List<String> getPrivacy_comment(){
        return this.privacy_comment;
    }
}
