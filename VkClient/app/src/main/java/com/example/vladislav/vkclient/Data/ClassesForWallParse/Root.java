package com.example.vladislav.vkclient.Data.ClassesForWallParse;

public class Root {
    ==================================
            package ;
    public class Photo
    {

    }

==================================
        package ;
    public class Attachments
    {
    }

==================================
        package ;
    public class Post_source
    {

    }

==================================
        package ;
    public class Comments
    {

    }

==================================
        package ;
    public class Likes
    {
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

==================================
        package ;
    public class Reposts
    {

    }

==================================
        package ;
    public class Views
    {

    }

==================================
        package ;
import java.util.ArrayList;
import java.util.List;
    public class Items
    {

    }

==================================
        package ;
    public class Groups
    {
        private int id;

        private String name;

        private String screen_name;

        private int is_closed;

        private String type;

        private int is_admin;

        private int is_member;

        private String photo_50;

        private String photo_100;

        private String photo_200;

        public void setId(int id){
            this.id = id;
        }
        public int getId(){
            return this.id;
        }
        public void setName(String name){
            this.name = name;
        }
        public String getName(){
            return this.name;
        }
        public void setScreen_name(String screen_name){
            this.screen_name = screen_name;
        }
        public String getScreen_name(){
            return this.screen_name;
        }
        public void setIs_closed(int is_closed){
            this.is_closed = is_closed;
        }
        public int getIs_closed(){
            return this.is_closed;
        }
        public void setType(String type){
            this.type = type;
        }
        public String getType(){
            return this.type;
        }
        public void setIs_admin(int is_admin){
            this.is_admin = is_admin;
        }
        public int getIs_admin(){
            return this.is_admin;
        }
        public void setIs_member(int is_member){
            this.is_member = is_member;
        }
        public int getIs_member(){
            return this.is_member;
        }
        public void setPhoto_50(String photo_50){
            this.photo_50 = photo_50;
        }
        public String getPhoto_50(){
            return this.photo_50;
        }
        public void setPhoto_100(String photo_100){
            this.photo_100 = photo_100;
        }
        public String getPhoto_100(){
            return this.photo_100;
        }
        public void setPhoto_200(String photo_200){
            this.photo_200 = photo_200;
        }
        public String getPhoto_200(){
            return this.photo_200;
        }
    }

==================================
        package ;
import java.util.ArrayList;
import java.util.List;
    public class Response
    {
        private int count;

        private List<Items> items;

        private List<String> profiles;

        private List<Groups> groups;

        public void setCount(int count){
            this.count = count;
        }
        public int getCount(){
            return this.count;
        }
        public void setItems(List<Items> items){
            this.items = items;
        }
        public List<Items> getItems(){
            return this.items;
        }
        public void setProfiles(List<String> profiles){
            this.profiles = profiles;
        }
        public List<String> getProfiles(){
            return this.profiles;
        }
        public void setGroups(List<Groups> groups){
            this.groups = groups;
        }
        public List<Groups> getGroups(){
            return this.groups;
        }
    }

==================================
        package ;
    public class Root
    {
        private Response response;

        public void setResponse(Response response){
            this.response = response;
        }
        public Response getResponse(){
            return this.response;
        }
    }

}
