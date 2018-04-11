/* Copyright 2018 freecodeformat.com */
package com.example.vladislav.task.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

/* Time: 2018-04-06 14:48:54 @author freecodeformat.com @website http://www.freecodeformat.com/json2javabean.php */
public class CurrentUser {

    @JsonProperty("voted_for_post")
    private boolean votedForPost;
    @JsonProperty("commented_on_post")
    private boolean commentedOnPost;

    public void setVotedForPost(boolean votedForPost) {
         this.votedForPost = votedForPost;
     }
     public boolean getVotedForPost() {
         return votedForPost;
     }

    public void setCommentedOnPost(boolean commentedOnPost) {this.commentedOnPost = commentedOnPost;}
    public boolean getCommentedOnPost() {return commentedOnPost;}

}