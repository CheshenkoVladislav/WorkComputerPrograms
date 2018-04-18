package com.example.vladislav.vkclient.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.vladislav.vkclient.Data.Photo.PhotoItems;
import com.example.vladislav.vkclient.Data.UrlsForRecycleItem;
import com.example.vladislav.vkclient.Interfaces.LoadMorePhotos;
import com.example.vladislav.vkclient.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.FotoItemsViewHolder> {
    public List<String> imageUrls = new ArrayList<>();
    public List<UrlsForRecycleItem>packageUrls = new ArrayList<>();
    public List<PhotoItems>photos = new ArrayList<>();
    private LoadMorePhotos loadMorePhotos;
    public HashSet<String> urlsNoRepetitive = new HashSet<>();
    private static final String TAG = "RecyclerViewAdapter";

    public void setLoadMorePhotos(LoadMorePhotos loadMorePhotos) {
        this.loadMorePhotos = loadMorePhotos;
    }

    @NonNull
    @Override
    public FotoItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.foto_item,parent,false);
        FotoItemsViewHolder holder = new FotoItemsViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FotoItemsViewHolder holder, int position) {
        String image;
        String image2;
        if (packageUrls.get(position).getUrl2() != null) {
           image = packageUrls.get(position).getUrl1();
           image2 = packageUrls.get(position).getUrl2();
           holder.applyData(image,image2);
        }else {
            image = packageUrls.get(position).getUrl1();
            holder.applyData(image);
        }
        if (position == packageUrls.size()-1){
            loadMorePhotos.loadPhotos();
        }


    }

    @Override
    public int getItemCount() {
        return packageUrls.size();
    }

    public void setData(List<PhotoItems> photoItems){
        if (packageUrls.size() != 0){
            Log.d(TAG, "before remove items: " + packageUrls.size());
            packageUrls.clear();
            imageUrls.clear();
        }
        Log.d(TAG, "after remove items: " + packageUrls.size());
        catchingUrls(photoItems);
        packUrlsInRecycleItem(imageUrls);
        notifyDataSetChanged();
    }

    public void loadMore(List<PhotoItems> newItems) {
        catchingUrls(newItems);
        packUrlsInRecycleItem(imageUrls);
        notifyDataSetChanged();
    }
    private void packUrlsInRecycleItem(List<String> imageUrls) {
        for (int i = 0; i < imageUrls.size(); i+=2) {
            UrlsForRecycleItem photo = new UrlsForRecycleItem();
            if (i == imageUrls.size() || i+1 == imageUrls.size()) {
                photo.setUrl1(imageUrls.get(i));
            }else {
                photo.setUrl1(imageUrls.get(i));
                photo.setUrl2(imageUrls.get(i + 1));
            }
            packageUrls.add(photo);
        }
    }

    //TODO: Return 7/10 ; need correct cycle

    private void catchingUrls(List<PhotoItems>photoItems) {
        removeRepeatItems(photoItems);
        for (int i = 0; i < photoItems.size(); i++) {
            imageUrls.add(photoItems.get(i).getPhoto_604());
        }
    }

    private void removeRepeatItems(List<PhotoItems> newItems) {
        for (int i = 0; i < newItems.size(); i++) {
            for (int j = 0; j < imageUrls.size(); j++) {

            }
        }
    }

    //    }
    //        }
    //            else attachmentPhotos.add(new ImageData(R.drawable.dr_123,a));
    //            if (a == 0) attachmentPhotos.add(new ImageData(R.drawable.dr_123,R.drawable.vk_clear_shape));
    //        for (int i = 0; i < 5; i++) {
    //        int a = 0;
    //    public void fillingList(){
    class FotoItemsViewHolder extends RecyclerView.ViewHolder{

        ImageView image1;
        ImageView image2;

        public FotoItemsViewHolder(View itemView) {
            super(itemView);
            image1 = itemView.findViewById(R.id.imageView4);
            image2 = itemView.findViewById(R.id.imageView5);
        }
        public void applyData(String image,String image2){
            Picasso.get().load(image).into(this.image1);
            Picasso.get().load(image2).into(this.image2);
        }

        public void applyData(String image) {
            Picasso.get().load(image).into(this.image1);
        }
//        public void applyData(ImageData image1,ImageData image2){
//            Picasso.get().load(image1.getImageDrawable()).resize(150,150).into(this.image1);
//            Picasso.get().load(image2.getImageDrawable()).resize(150,150).into(this.image2);
//        }
    }
}
