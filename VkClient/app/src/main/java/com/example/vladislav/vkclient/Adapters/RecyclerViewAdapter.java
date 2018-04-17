package com.example.vladislav.vkclient.Adapters;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.vladislav.vkclient.Data.ClassesForWallParse.Attachments;
import com.example.vladislav.vkclient.Data.ClassesForWallParse.CopyHistory;
import com.example.vladislav.vkclient.Data.ClassesForWallParse.Items;
import com.example.vladislav.vkclient.Data.ImageData;
import com.example.vladislav.vkclient.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.FotoItemsViewHolder> {
    public List<Attachments> attachmentPhotos = new ArrayList<>();
    public List<CopyHistory> histories = new ArrayList<>();
    public List<ImageData> images = new ArrayList<>();
    public List<String> imageUrls = new ArrayList<>();
    private static final String TAG = "RecyclerViewAdapter";

    @NonNull
    @Override
    public FotoItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.foto_item,parent,false);
        FotoItemsViewHolder holder = new FotoItemsViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FotoItemsViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: " + histories.size());
        String image = imageUrls.get(position);
        holder.applyData(image);

    }

    public void setData(List<Items> photoItems){
        catchingUrls(photoItems);
        notifyDataSetChanged();
    }

    //TODO: Return 7/10 ; need correct cycle
    private void catchingUrls(List<Items>photoItems) {
        for (int i = 0; i < photoItems.size(); i++) {
            Items items = photoItems.get(i);
            if (items.getCopy_history()!=null) {
                for (int j = 0; j < items.getCopy_history().size(); j++) {
                    System.out.println(items.getCopy_history().size());
                    CopyHistory copyHistory = items.getCopy_history().get(j);
                    for (int k = 0; k < copyHistory.getAttachments().size(); k++) {
                        if (copyHistory.getAttachments().get(k).getPhoto() != null)
                            imageUrls.add(copyHistory.getAttachments().get(k).getPhoto().getPhoto_604());
                    }
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return imageUrls.size();
    }

//    public void fillingList(){
//        int a = 0;
//        for (int i = 0; i < 5; i++) {
//            if (a == 0) attachmentPhotos.add(new ImageData(R.drawable.dr_123,R.drawable.vk_clear_shape));
//            else attachmentPhotos.add(new ImageData(R.drawable.dr_123,a));
//        }
//    }
   class FotoItemsViewHolder extends RecyclerView.ViewHolder{
        ImageView image1;
        ImageView image2;

        public FotoItemsViewHolder(View itemView) {
            super(itemView);
            image1 = itemView.findViewById(R.id.imageView4);
            image2 = itemView.findViewById(R.id.imageView5);
        }
        public void applyData(String image){
            Picasso.get().load(image).resize(200,200).into(this.image1);
            Picasso.get().load(R.drawable.dr_123).resize(200,200).into(this.image2);
        }
//        public void applyData(ImageData image1,ImageData image2){
//            Picasso.get().load(image1.getImageDrawable()).resize(150,150).into(this.image1);
//            Picasso.get().load(image2.getImageDrawable()).resize(150,150).into(this.image2);
//        }
    }
}
