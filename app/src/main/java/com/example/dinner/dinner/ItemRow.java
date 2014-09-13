package com.example.dinner.dinner;

/**
 * Created by ahris on 9/13/14.
 */
import android.graphics.drawable.Drawable;

public class ItemRow {

    String itemName;
    Drawable icon;

    public ItemRow(String itemName, Drawable icon) {
        super();
        this.itemName = itemName;
        this.icon = icon;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public Drawable getIcon() {
        return icon;
    }
    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

}