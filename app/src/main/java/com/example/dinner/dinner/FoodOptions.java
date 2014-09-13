package com.example.dinner.dinner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        //Boolean array values
        // Check which checkbox was clicked
        bool[]preferences = bool[9];
        switch(view.getId()) {
            case R.id.checkbox_american:
                if (checked) {
                    bool[0]=true;
                } else {
                    bool[0]=false;
                }
                break;
            case R.id.checkbox_chinese:
                if (checked){
                    bool[1]=true;
                } else {
                    bool[1]=false;
                }
                break;
            case R.id.checkbox_french:
                


            <CheckBox android:id="@+id/checkbox_french"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/food_french"
            android:onClick="onCheckboxClicked"/>
            <CheckBox android:id="@+id/checkbox_german"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/food_german"
            android:onClick="onCheckboxClicked"/>
            <CheckBox android:id="@+id/checkbox_indian"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/food_indian"
            android:onClick="onCheckboxClicked"/>
            <CheckBox android:id="@+id/checkbox_italian"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/food_italian"
            android:onClick="onCheckboxClicked"/>
            <CheckBox android:id="@+id/checkbox_japanese"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/food_japanese"
            android:onClick="onCheckboxClicked"/>
            <CheckBox android:id="@+id/checkbox_korean"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/food_korean"
            android:onClick="onCheckboxClicked"/>
            <CheckBox android:id="@+id/checkbox_mexican"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/food_mexican"
            android:onClick="onCheckboxClicked"/>
        }
    }

    public void openMenu(View view) {
        // Open up the options page
        Intent intent = new Intent(this, Menu.class);
    }
}
