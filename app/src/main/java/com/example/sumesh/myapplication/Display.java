package com.example.sumesh.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import static android.R.attr.delay;

/**
 * Created by sumesh on 08/04/17.
 */

public class Display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent = getIntent();
        Bitmap var = intent.getParcelableExtra("split_image");
        //Log.i("in display","kuttananeee");
        ImageView images = (ImageView) findViewById(R.id.imageView);
        images.setImageBitmap(var);

        Toast.makeText(Display.this, "Selected succesfullyy", Toast.LENGTH_LONG)
                .show();


        Intent intent2 = new Intent(this,Start.class);
        startActivity(intent2);
        finish();

    }
}