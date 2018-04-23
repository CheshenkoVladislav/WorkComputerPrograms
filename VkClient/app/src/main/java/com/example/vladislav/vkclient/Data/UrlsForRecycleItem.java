package com.example.vladislav.vkclient.Data;

import android.support.annotation.Nullable;

public class UrlsForRecycleItem {
    @Nullable
    private String url;

    @Nullable
    private String bigUrl;


    @Nullable
    public String getBigUrl1() {
        return bigUrl;
    }

    public void setBigUrl1(@Nullable String bigUrl1) {
        this.bigUrl = bigUrl1;
    }

    public String getUrl1() {
        return url;
    }

    public void setUrl1(String url1) {
        this.url = url1;
    }

}
