package com.example.vladislav.vkclient.Data.ProfilesPack;

import com.example.vladislav.vkclient.Data.MyInfo;

public class ProfileInfoRoot {
    private MyInfo response;

    public void setResponse(MyInfo response){
        this.response = response;
    }
    public MyInfo getResponse(){
        return this.response;
    }
}
