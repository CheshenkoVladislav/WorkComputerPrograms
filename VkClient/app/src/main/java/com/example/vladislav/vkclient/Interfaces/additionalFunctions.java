package com.example.vladislav.vkclient.Interfaces;

import com.example.vladislav.vkclient.Data.UrlsForRecycleItem;

import java.util.List;

public interface additionalFunctions {
    void loadPhotos();

    void moreInfoAboutPhoto(List<String>bigImageUrl,int position);
}
