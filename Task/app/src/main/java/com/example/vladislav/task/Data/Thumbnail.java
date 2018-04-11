/* Copyright 2018 freecodeformat.com */
package com.example.vladislav.task.Data;

import com.fasterxml.jackson.annotation.JsonProperty;
/* Time: 2018-04-06 14:48:54 @author freecodeformat.com @website http://www.freecodeformat.com/json2javabean.php */
public class Thumbnail {

    private int id;
    @JsonProperty("media_type")
    private String mediaType;
    @JsonProperty("image_url")
    private String imageUrl;
    private Metadata metadata;
    public void setId(int id) {
         this.id = id;
     }
     public int getId() {
         return id;
     }

    public void setMediaType(String mediaType) {
         this.mediaType = mediaType;
     }
     public String getMediaType() {
         return mediaType;
     }

    public void setImageUrl(String imageUrl) {
         this.imageUrl = imageUrl;
     }
     public String getImageUrl() {
         return imageUrl;
     }

    public void setMetadata(Metadata metadata) {
         this.metadata = metadata;
     }
     public Metadata getMetadata() {
         return metadata;
     }

}