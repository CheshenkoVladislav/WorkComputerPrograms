package com.example.vladislav.recycleapplication.Interfaces;

import com.example.vladislav.recycleapplication.Data.Item;

/**
 * Created by vladislav on 26.03.18.
 */

public interface AdapterListenerInterface  {
    void onClickListener(Item item, int position);
    void onLongClickListener(Item item, int position);
}
