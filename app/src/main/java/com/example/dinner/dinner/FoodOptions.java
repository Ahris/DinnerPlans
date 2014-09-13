package com.example.dinner.dinner;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;

public class FoodOptions extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_food_options);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.food_options, menu);
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
     * Saves the information of which check box is clicked
     * @param view
     */
    // Is the view now checked?
    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        if(checked) {
            editor.putBoolean(view.getId()+"", true);
            editor.commit();
        }else{
            editor.putBoolean(view.getId()+"", false);
            editor.commit();
        }
        //To retrieve these variables, do something like this:
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        //if (prefs.getBoolean(PREF_NAME, false)) {
        //    // etc
        //}
    }

    public void openMenu(View view) {
        // Open up the options page
        Intent intent = new Intent(this, Menu.class);
    }
}