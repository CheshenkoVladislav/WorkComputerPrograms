package com.example.vladislav.recycleapplication.Adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vladislav.recycleapplication.Data.Item;
import com.example.vladislav.recycleapplication.Data.ItemList;
import com.example.vladislav.recycleapplication.Interfaces.AdapterListenerInterface;
import com.example.vladislav.recycleapplication.ItemsListFragment;
import com.example.vladislav.recycleapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemsViewHolder> {
    public static List<Item>itemArrayList = new ArrayList<>();
    public SparseBooleanArray selections = new SparseBooleanArray();
    private static final String TAG = "ItemAdapter";
    private AdapterListenerInterface listener;

    public List<Item> getItemArrayList() {
        return itemArrayList;
    }

    @Override
    public ItemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_item,parent,false);
        view.setSelected(false);
        return new ItemsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemsViewHolder holder, int position) {
        Item item = itemArrayList.get(position);
        holder.applyData(item,position,listener,selections.get(position,false));
    }

    @Override
    public int getItemCount() {
        return itemArrayList.size();
    }

    public void setData(ItemList dataList){
        itemArrayList = dataList.getData();
        notifyDataSetChanged();
    }
    public void addItem(Item type) {
        itemArrayList.add(type);
        notifyItemInserted(itemArrayList.size()-1);
    }
    public void toggleSelection (int position){
        if (selections.get(position,false)){selections.delete(position);
        notifyItemChanged(position);}
        else {selections.put(position,true);
        notifyItemChanged(position);}
    }

    public void clearSelections(){
        selections.clear();
        notifyDataSetChanged();
    }
    public List<Integer>getSelectedItems(){
        List<Integer>selectedItems = new ArrayList<>(selections.size());
        for (int i = 0; i < selections.size(); i++) {
            selectedItems.add(selections.keyAt(i));
        }
        return selectedItems;
    }
    public Item remove(int pos){
        final Item item = itemArrayList.remove(pos);
        notifyItemRemoved(pos);
        return item;
    }
    public void setListener(AdapterListenerInterface listener){
        this.listener = listener;
    }

    class ItemsViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView price;

        public ItemsViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameView);
            price = itemView.findViewById(R.id.priceView);
        }

        public void applyData(final Item item, final int position, final AdapterListenerInterface listener, boolean selected){
            name.setText(item.getName());
            price.setText(String.valueOf(item.getPrice()));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClickListener(item,position);
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    listener.onLongClickListener(item, position);
                    return true;
                }
            });
            itemView.setActivated(selected);
        }
        }
    }

