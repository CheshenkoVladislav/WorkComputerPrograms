package com.example.vladislav.vkclient.Adapters;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.vladislav.vkclient.Data.ImageData;
import com.example.vladislav.vkclient.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;
import java.util.List;

import retrofit2.http.POST;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.FotoItemsViewHolder> {
    public List<ImageData>images = new ArrayList<>();
    Context context;

//    public RecyclerViewAdapter() {
//        this.context = context;
//    }

    @NonNull
    @Override
    public FotoItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.foto_item,parent,false);
        FotoItemsViewHolder holder = new FotoItemsViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FotoItemsViewHolder holder, int position) {
        ImageData image = images.get(position);
        holder.applyData(image);

    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public void fillingList(){
        int a = 0;
        for (int i = 0; i < 5; i++) {
            if (a == 0) images.add(new ImageData(R.drawable.dr_123,R.drawable.vk_clear_shape));
            else images.add(new ImageData(R.drawable.dr_123,a));
        }
    }
    public class FotoItemsViewHolder extends RecyclerView.ViewHolder{
        ImageView image1;
        ImageView image2;

        public FotoItemsViewHolder(View itemView) {
            super(itemView);
            image1 = itemView.findViewById(R.id.imageView4);
            image2 = itemView.findViewById(R.id.imageView5);
        }
        public void applyData(ImageData image1){
            Picasso.get().load(image1.getImage1()).resize(150,150).into(this.image1);
            Picasso.get().load(image1.getImage2()).resize(150,150).into(this.image2);
        }
//        public void applyData(ImageData image1,ImageData image2){
//            Picasso.get().load(image1.getImageDrawable()).resize(150,150).into(this.image1);
//            Picasso.get().load(image2.getImageDrawable()).resize(150,150).into(this.image2);
//        }
    }
}
