package com.example.vladislav.vkclient.Data.ClassesForWallParse;

import java.util.List;

public class CopyHistory {
    private int id;
    private int owner_id;
    private int from_id;
    private int date;
    private String post_type;
    private String text;
    private List<Attachments>attachments;
    private Post_source post_source;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public int getFrom_id() {
        return from_id;
    }

    public void setFrom_id(int from_id) {
        this.from_id = from_id;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getPost_type() {
        return post_type;
    }

    public void setPost_type(String post_type) {
        this.post_type = post_type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Attachments> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachments> attachments) {
        this.attachments = attachments;
    }

    public Post_source getPost_source() {
        return post_source;
    }

    public void setPost_source(Post_source post_source) {
        this.post_source = post_source;
    }

}
