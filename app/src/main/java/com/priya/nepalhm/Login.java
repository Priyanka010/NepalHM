package com.priya.nepalhm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by priyanka on 12/20/16.
 */

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);

        TextView textView = (TextView) findViewById(R.id.textview);
        textView.setText("helloooo");

    }
}
