/* Copyright 2018 freecodeformat.com */
package com.example.vladislav.task.Data;
import java.util.List;

/* Time: 2018-04-06 14:48:54 @author freecodeformat.com @website http://www.freecodeformat.com/json2javabean.php */
public class JsonRootBean {

    private List<Posts> posts;
    public void setPosts(List<Posts> posts) {
         this.posts = posts;
     }
     public List<Posts> getPosts() {
         return posts;
     }

}