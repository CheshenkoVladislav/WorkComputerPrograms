/* Copyright 2018 freecodeformat.com */
package com.example.vladislav.task.Data;
import java.util.Date;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
/* Time: 2018-04-06 14:48:54 @author freecodeformat.com @website http://www.freecodeformat.com/json2javabean.php */
public class User {

    private int id;
    @JsonProperty("created_at")
    private Date createdAt;
    private String name;
    private String username;
    private String headline;
    @JsonProperty("twitter_username")
    private String twitterUsername;
    @JsonProperty("website_url")
    private String websiteUrl;
    @JsonProperty("profile_url")
    private String profileUrl;
    @JsonProperty("image_url")
    private ImageUrl imageUrl;
    public void setId(int id) {
         this.id = id;
     }
     public int getId() {
         return id;
     }

    public void setCreatedAt(Date createdAt) {
         this.createdAt = createdAt;
     }
     public Date getCreatedAt() {
         return createdAt;
     }

    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setUsername(String username) {
         this.username = username;
     }
     public String getUsername() {
         return username;
     }

    public void setHeadline(String headline) {
         this.headline = headline;
     }
     public String getHeadline() {
         return headline;
     }

    public void setTwitterUsername(String twitterUsername) {
         this.twitterUsername = twitterUsername;
     }
     public String getTwitterUsername() {
         return twitterUsername;
     }

    public void setWebsiteUrl(String websiteUrl) {
         this.websiteUrl = websiteUrl;
     }
     public String getWebsiteUrl() {
         return websiteUrl;
     }

    public void setProfileUrl(String profileUrl) {
         this.profileUrl = profileUrl;
     }
     public String getProfileUrl() {
         return profileUrl;
     }

    public void setImageUrl(ImageUrl imageUrl) {
         this.imageUrl = imageUrl;
     }
     public ImageUrl getImageUrl() {
         return imageUrl;
     }

}