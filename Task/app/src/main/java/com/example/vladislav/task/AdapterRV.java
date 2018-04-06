package com.example.vladislav.task;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterRV extends RecyclerView.Adapter<AdapterRV.ItemViewHolder> {
    Context context;
    public AdapterRV(){
        setThemeList();
    }

    public void setThemeList() {
        for (int i = 0; i < 10; i++) {
            themeList.add(new Theme(i + "",i + "12454", i + ""));
        }
    }

    List<Theme>themeList = new ArrayList<>();

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main_item,parent,false);
        ItemViewHolder holder = new ItemViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Theme theme = themeList.get(position);
        holder.applyData(theme);
    }

    @Override
    public int getItemCount() {
        return themeList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView text;
        TextView name;
        TextView numbers;
        ImageView imageView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.textAboutItem);
            name = itemView.findViewById(R.id.name);
            imageView = itemView.findViewById(R.id.imageView);
            numbers = itemView.findViewById(R.id.numbers);
        }

        public void applyData(Theme theme) {
            text.setText(theme.getText());
            name.setText(theme.getText());
            numbers.setText(theme.getText());
//            imageView.setImageBitmap(BitmapFactory.decodeResource(itemView.getResources(),R.drawable.png));
        }
    }
}
