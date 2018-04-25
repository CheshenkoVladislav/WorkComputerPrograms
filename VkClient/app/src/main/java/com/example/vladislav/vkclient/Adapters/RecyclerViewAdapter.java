package com.example.vladislav.vkclient.Adapters;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.vladislav.vkclient.Data.Photo.PhotoItems;
import com.example.vladislav.vkclient.Data.UrlsForRecycleItem;
import com.example.vladislav.vkclient.Interfaces.additionalFunctions;
import com.example.vladislav.vkclient.R;
import com.example.vladislav.vkclient.helper.CropSquareTransform;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.FotoItemsViewHolder> {
    public List<String> imageUrls = new ArrayList<>();
    public List<String> bigImageUrls = new ArrayList<>();
    public List<UrlsForRecycleItem> packageUrls = new ArrayList<>();
    private additionalFunctions additionalFunctions;
    private static final String TAG = "RecyclerViewAdapter";

    //set realisation interface additionalFunctions
    public void setAdditionalFunctions(additionalFunctions additionalFunctions) {
        this.additionalFunctions = additionalFunctions;
    }
    @NonNull
    @Override
    public FotoItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.foto_item, parent, false);
        FotoItemsViewHolder holder = new FotoItemsViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FotoItemsViewHolder holder, int position) {
        holder.applyData(position);
        if (position == imageUrls.size() - 4) {
            Log.d(TAG, "onBindViewHolder: LAST HOLDER");
            additionalFunctions.loadPhotos();
        }
    }

    @Override
    public int getItemCount() {
        return imageUrls.size();
    }

    public void setData(List<PhotoItems> photoItems) {
        if (packageUrls.size() != 0) {
            Log.d(TAG, "before remove items: " + packageUrls.size());
//            packageUrls.clear();
//            imageUrls.clear();
//            bigImageUrls.clear();
        }
        Log.d(TAG, "after remove items: " + packageUrls.size());
        catchingUrls(photoItems);
//        packUrlsInRecycleItem(imageUrls, bigImageUrls);
        notifyDataSetChanged();
        Log.d(TAG, "IMAGE URLS: " + imageUrls);
        Log.d(TAG, "BIG IMAGE URLS: " + bigImageUrls);
    }

    public void loadMore(List<PhotoItems> newItems) {
//        imageUrls.clear();
//        bigImageUrls.clear();
        Log.d(TAG, "loadMore: " + imageUrls.size());
        catchingUrls(newItems);
//        packUrlsInRecycleItem(imageUrls, bigImageUrls);
//        notifyDataSetChanged();
    }

    //package to class recycleViewItem
    //filling photo array
    private void packUrlsInRecycleItem(List<String> imageUrls, List<String> bigImageUrls) {
        Log.d(TAG, "packUrlsInRecycleItem: START CYCLE");
        Log.d(TAG, "packUrlsInRecycleItem: " + imageUrls.size());
        for (int i = 0; i < imageUrls.size(); i++) {
            UrlsForRecycleItem photo = new UrlsForRecycleItem();
            photo.setUrl1(imageUrls.get(i));
            photo.setBigUrl1(bigImageUrls.get(i));
            packageUrls.add(photo);
        }
        Log.d(TAG, "packUrlsInRecycleItem: " + packageUrls.size());
    }

    //catch url of items in imageUrls and bigImageUrls arrays
    private void catchingUrls(List<PhotoItems> photoItems) {
        for (int i = 0; i < photoItems.size(); i++) {
            imageUrls.add(photoItems.get(i).getPhoto_604());
            notifyItemChanged(imageUrls.size()-1);
            if (photoItems.get(i).getPhoto_1280() != null)
                bigImageUrls.add(photoItems.get(i).getPhoto_1280());
            else if (photoItems.get(i).getPhoto_807() != null)
                bigImageUrls.add(photoItems.get(i).getPhoto_807());
            else if (photoItems.get(i).getPhoto_604() != null)
                bigImageUrls.add(photoItems.get(i).getPhoto_604());
        }
    }

    class FotoItemsViewHolder extends RecyclerView.ViewHolder {

        ImageView image1;

        private FotoItemsViewHolder(View itemView) {
            super(itemView);
            image1 = itemView.findViewById(R.id.imageView4);
        }

        private void applyData(int position) {
            Picasso.get()
                    .load(imageUrls.get(position))
                    .transform(new CropSquareTransform())
                    .into(this.image1);
            infoPhoto(position);
        }

        //onClick at photo handler
        void infoPhoto(final int position) {
            this.image1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    additionalFunctions.moreInfoAboutPhoto(bigImageUrls,position);
                }
            });
        }
    }
}
