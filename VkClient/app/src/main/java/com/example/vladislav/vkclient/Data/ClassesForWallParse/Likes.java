package com.example.vladislav.vkclient.Data.ClassesForWallParse;

public class Likes {
    private int count;

    private int user_likes;

    private int can_like;

    private int can_publish;

    public void setCount(int count){
        this.count = count;
    }
    public int getCount(){
        return this.count;
    }
    public void setUser_likes(int user_likes){
        this.user_likes = user_likes;
    }
    public int getUser_likes(){
        return this.user_likes;
    }
    public void setCan_like(int can_like){
        this.can_like = can_like;
    }
    public int getCan_like(){
        return this.can_like;
    }
    public void setCan_publish(int can_publish){
        this.can_publish = can_publish;
    }
    public int getCan_publish(){
        return this.can_publish;
    }
}
