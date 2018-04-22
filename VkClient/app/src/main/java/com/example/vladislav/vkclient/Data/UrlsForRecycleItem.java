package com.example.vladislav.vkclient.Data;

import android.support.annotation.Nullable;

public class UrlsForRecycleItem {
    @Nullable
    private String url1;
    @Nullable
    private String url2;
    @Nullable
    private String bigUrl1;
    @Nullable
    private String bigUrl2;

    @Nullable
    public String getBigUrl1() {
        return bigUrl1;
    }

    public void setBigUrl1(@Nullable String bigUrl1) {
        this.bigUrl1 = bigUrl1;
    }

    @Nullable
    public String getBigUrl2() {
        return bigUrl2;
    }

    public void setBigUrl2(@Nullable String bigUrl2) {
        this.bigUrl2 = bigUrl2;
    }

    public String getUrl1() {
        return url1;
    }

    public void setUrl1(String url1) {
        this.url1 = url1;
    }

    public String getUrl2() {
        return url2;
    }

    public void setUrl2(String url2) {
        this.url2 = url2;
    }
}
