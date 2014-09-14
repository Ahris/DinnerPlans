package com.example.dinner.dinner;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by ahris on 9/13/14.
 */
class DownloadImageTask extends AsyncTask<String, Void, Drawable> {
    ItemRow bmImage;
    ItemAdapter adapter;
    private static Context context;

    public DownloadImageTask(ItemRow bmImage, Context context,ItemAdapter ia) {
        this.bmImage = bmImage;
        this.context = context;
        this.adapter=ia;
    }

    protected Drawable doInBackground(String... urls) {
        String urldisplay = urls[0];
        Drawable d = null;
        try {
            InputStream is = (InputStream) new URL(urldisplay).getContent();
            d = Drawable.createFromStream(is, "src name");
            return d;

            // BEFORE
//            InputStream in = new java.net.URL(urldisplay).openStream();
//            mIcon11 = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return d;
    }

    protected void onPostExecute(Drawable result) {
        //Drawable d = new BitmapDrawable(context.getResources(),result);
        bmImage.setIcon(result);
        adapter.notifyDataSetChanged();
        //bmImage.setImageBitmap(result);
    }
}