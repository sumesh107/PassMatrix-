package com.example.sumesh.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView t = (TextView) findViewById(R.id.result);
        ImageView i = (ImageView) findViewById(R.id.imageView4);

        Intent intent3 = getIntent();
        int res = intent3.getIntExtra("result",0);

        if (res == MainActivity.i)
        {
            t.setText(" Authentication successfull ");
           // i.set

        }
        else
        {
            t.setText(" Authentication Failed ");
        }
    }
}
