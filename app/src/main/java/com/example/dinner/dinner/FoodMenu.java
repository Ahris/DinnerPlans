package com.example.dinner.dinner;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ImageView;

import com.fortysevendeg.swipelistview.BaseSwipeListViewListener;
import com.fortysevendeg.swipelistview.SwipeListView;

import java.util.ArrayList;
import java.util.List;

public class FoodMenu extends Activity {

    SwipeListView swipelistview;
    ItemAdapter adapter;
    List<ItemRow> itemData;
    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_food_menu);

        this.context = this;

        swipelistview=(SwipeListView)findViewById(R.id.example_swipe_lv_list);
        itemData=new ArrayList<ItemRow>();
        adapter=new ItemAdapter(this,R.layout.custom_row,itemData);

        swipelistview.setSwipeListViewListener(new BaseSwipeListViewListener() {
            @Override
            public void onOpened(int position, boolean toRight) {
            }

            @Override
            public void onClosed(int position, boolean fromRight) {
            }

            @Override
            public void onListChanged() {
            }

            @Override
            public void onMove(int position, float x) {
            }

            @Override
            public void onStartOpen(int position, int action, boolean right) { //Here we need to replace the recipe
                Log.d("swipe", String.format("onStartOpen %d - action %d", position, action));
                itemData.get(position).setItemName("changed item " + position);
                try {
                    ImageView iv = new ImageView(context);
                    DownloadImageTask task = (DownloadImageTask) new DownloadImageTask(itemData.get(position), context,adapter).execute("https://lh4.ggpht.com/DlBzTKn3If-kNiBtZt9LjL7Dnt6u9MoP6UP_-LsM3c3R2jTIKPta67iEh3pfzFjme7u966lZnHve1mUbEpq8wrs=s400");
                }catch(Exception e){
                    e.printStackTrace();
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onStartClose(int position, boolean right) {
                Log.d("swipe", String.format("onStartClose %d", position));
            }

            @Override
            public void onClickFrontView(int position) {
                Log.d("swipe", String.format("onClickFrontView %d", position));

                //swipelistview.openAnimate(position); //when you touch front view it will open
                // Clicking the front view will open the recipe
                // get the URL from the item's property that holds the URL or something
                try {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                    startActivity(browserIntent);
                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onClickBackView(int position) {
                Log.d("swipe", String.format("onClickBackView %d", position));

                swipelistview.closeAnimate(position);//when you touch back view it will close
            }

            @Override
            public void onDismiss(int[] reverseSortedPositions) {

            }

        });

        //These are the swipe listview settings. you can change these
        //setting as your requrement
        swipelistview.setSwipeMode(SwipeListView.SWIPE_MODE_LEFT); // there are five swiping modes
        swipelistview.setSwipeActionLeft(SwipeListView.SWIPE_ACTION_CHOICE); //there are four swipe actions
        swipelistview.setSwipeActionRight(SwipeListView.SWIPE_ACTION_NONE);
        swipelistview.setOffsetLeft(convertDpToPixel(260f)); // left side offset //Was originally 260
        swipelistview.setOffsetRight(convertDpToPixel(0f)); // right side offset
        swipelistview.setAnimationTime(50); // animation time
        swipelistview.setSwipeOpenOnLongPress(true); // enable or disable SwipeOpenOnLongPress
        swipelistview.setAdapter(adapter);
        for(int i=0;i<7;i++)
        {
            itemData.add(new ItemRow("item"+i,getResources().getDrawable(R.drawable.ic_launcher) ));

        }

        adapter.notifyDataSetChanged();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.food_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * This method is used to convert “dp” values to “pixel” values.
     * @param dp
     * @return
     */
    public int convertDpToPixel(float dp) {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return (int) px;
    }

//    public static Drawable LoadImageFromWebOperations(String url) {
//        try {
//            InputStream is = (InputStream) new URL(url).getContent();
//            Drawable d = Drawable.createFromStream(is, "src name");
//            return d;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

}


