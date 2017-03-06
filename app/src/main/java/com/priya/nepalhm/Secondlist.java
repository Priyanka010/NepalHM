package com.priya.nepalhm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by priyanka on 12/21/16.
 */

public class Secondlist extends AppCompatActivity {
    public static final String KEY_LIST_TYPE = "list_type";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);

        String name = getIntent().getStringExtra(KEY_LIST_TYPE);
        Log.e("movie name", name);
        TextView textView = (TextView) findViewById(R.id.textview);
        textView.setText(name);
    }
}