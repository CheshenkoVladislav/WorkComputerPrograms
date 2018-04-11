package com.example.vladislav.task.Data;

import java.util.List;
public class Root {

    private List<Posts> posts;

    public void setPosts(List<Posts> posts){
        this.posts = posts;
    }
    public List<Posts> getPosts(){
        return this.posts;
    }
}
