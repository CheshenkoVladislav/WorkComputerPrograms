package com.example.vladislav.vkclient.Data;

public class NewsFeed1Item {
    private int id;

    private int album_id;

    private int owner_id;

    private String photo_75;

    private String photo_130;

    private String photo_604;

    private String photo_807;

    private String photo_1280;

    private String photo_2560;

    private int width;

    private int height;

    private String text;

    private int date;

    private String access_key;

    private Likes likes;

    private Reposts reposts;

    private Comments comments;

    private int can_comment;

    private int can_repost;

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
    public void setPhoto_75(String photo_75){
        this.photo_75 = photo_75;
    }
    public String getPhoto_75(){
        return this.photo_75;
    }
    public void setPhoto_130(String photo_130){
        this.photo_130 = photo_130;
    }
    public String getPhoto_130(){
        return this.photo_130;
    }
    public void setPhoto_604(String photo_604){
        this.photo_604 = photo_604;
    }
    public String getPhoto_604(){
        return this.photo_604;
    }
    public void setPhoto_807(String photo_807){
        this.photo_807 = photo_807;
    }
    public String getPhoto_807(){
        return this.photo_807;
    }
    public void setPhoto_1280(String photo_1280){
        this.photo_1280 = photo_1280;
    }
    public String getPhoto_1280(){
        return this.photo_1280;
    }
    public void setPhoto_2560(String photo_2560){
        this.photo_2560 = photo_2560;
    }
    public String getPhoto_2560(){
        return this.photo_2560;
    }
    public void setWidth(int width){
        this.width = width;
    }
    public int getWidth(){
        return this.width;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public int getHeight(){
        return this.height;
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
    public void setAccess_key(String access_key){
        this.access_key = access_key;
    }
    public String getAccess_key(){
        return this.access_key;
    }
    public void setLikes(Likes likes){
        this.likes = likes;
    }
    public Likes getLikes(){
        return this.likes;
    }
    public void setReposts(Reposts reposts){
        this.reposts = reposts;
    }
    public Reposts getReposts(){
        return this.reposts;
    }
    public void setComments(Comments comments){
        this.comments = comments;
    }
    public Comments getComments(){
        return this.comments;
    }
    public void setCan_comment(int can_comment){
        this.can_comment = can_comment;
    }
    public int getCan_comment(){
        return this.can_comment;
    }
    public void setCan_repost(int can_repost){
        this.can_repost = can_repost;
    }
    public int getCan_repost(){
        return this.can_repost;
    }
}
