package com.example.androidpractice;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ItemLab {
    private static ItemLab sItemLab;

    private List<Item> mItems;

    public static ItemLab get(Context context)
    {
        if (sItemLab == null )
        { sItemLab = new ItemLab(context); }

        return sItemLab;
    }

    public ItemLab(Context context)
    {
        mItems = new ArrayList<>() ;
        for(int i=0 ; i<100 ; i++){
                Item item = new Item();
                item.setString("#"+ i);
                mItems.add(item);
        }
    }

    public List<Item> getItems()
    { return mItems; }

}
