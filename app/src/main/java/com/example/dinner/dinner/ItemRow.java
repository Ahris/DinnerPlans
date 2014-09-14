package com.example.dinner.dinner;

/**
 * Created by ahris on 9/13/14.
 */

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemRow {

    String itemName;
    Drawable icon;
    TextView tv;
    ImageView iv;

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
    public void setImageView(ImageView iv) { this.iv = iv;}
    public ImageView getImageView() {return iv;}
    public void setTextView(TextView tv) { this.tv = tv;}
    public TextView getTextView() {return tv;}
}