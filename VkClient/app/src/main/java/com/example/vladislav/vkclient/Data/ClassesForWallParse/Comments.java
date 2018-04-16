package com.example.vladislav.vkclient.Data.ClassesForWallParse;

public class Comments {
    private int count;

    private boolean groups_can_post;

    private int can_post;

    public void setCount(int count){
        this.count = count;
    }
    public int getCount(){
        return this.count;
    }
    public void setGroups_can_post(boolean groups_can_post){
        this.groups_can_post = groups_can_post;
    }
    public boolean getGroups_can_post(){
        return this.groups_can_post;
    }
    public void setCan_post(int can_post){
        this.can_post = can_post;
    }
    public int getCan_post(){
        return this.can_post;
    }
}
