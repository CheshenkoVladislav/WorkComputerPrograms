package com.example.vladislav.recycleapplication.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vladislav.recycleapplication.Data.Item;
import com.example.vladislav.recycleapplication.Data.ItemList;
import com.example.vladislav.recycleapplication.ItemsListActivity;
import com.example.vladislav.recycleapplication.R;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemsViewHolder> {
    public static List<Item>itemArrayList = ItemsListActivity.itemList;

    @Override
    public ItemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_activity,parent,false);
        return new ItemsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemsViewHolder holder, int position) {
        Item item = itemArrayList.get(position);
        holder.applyData(item);
    }

    @Override
    public int getItemCount() {
        return itemArrayList.size();
    }

    public void setData(ItemList dataList){
        itemArrayList = dataList.getData();
        notifyDataSetChanged();
    }

    class ItemsViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView price;

        public ItemsViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameView);
            price = itemView.findViewById(R.id.priceView);
        }

        public void applyData(Item item){
            name.setText(item.getName());
            price.setText(String.valueOf(item.getPrice()));
        }
    }
}

