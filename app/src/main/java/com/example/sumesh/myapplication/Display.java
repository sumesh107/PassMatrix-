package com.example.sumesh.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by sumesh on 08/04/17.
 */

public class Display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent = getIntent();
        Bitmap var = intent.getParcelableExtra("merged_image");
        //Log.i("in display","kuttananeee");
        ImageView images = (ImageView) findViewById(R.id.imageView);
        images.setImageBitmap(var);

    }
}