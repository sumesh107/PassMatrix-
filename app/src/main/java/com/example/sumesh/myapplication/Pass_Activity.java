package com.example.sumesh.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;



public class Pass_Activity extends AppCompatActivity {

    private GestureDetectorCompat mDetector;
    float a , b , c;
    Rect d;

    ScrollView scroll;
    TextView t_e , n_e ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_);


        Intent intent = getIntent();
        int width = intent.getIntExtra("width", 0);
        int hieght = intent.getIntExtra("hieght", 0);


        scroll = (ScrollView) findViewById(R.id.scrollView3);

        ImageView img = (ImageView) findViewById(R.id.imageView2);
        img.setImageBitmap(MainActivity.bit);

        mDetector = new GestureDetectorCompat(this, new MyGestureListener());
        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mDetector.onTouchEvent(event);
                return true;
            }
        });


        TextView t_a = (TextView) findViewById(R.id.aalpha);
        TextView t_b = (TextView) findViewById(R.id.balpha);
        TextView t_c = (TextView) findViewById(R.id.calpha);
        TextView t_d = (TextView) findViewById(R.id.dalpha);
        t_e = (TextView) findViewById(R.id.ealpha);
        TextView t_f = (TextView) findViewById(R.id.falpha);
        TextView t_g = (TextView) findViewById(R.id.galpha);
        TextView t_h = (TextView) findViewById(R.id.halpha);

        TextView n_a = (TextView) findViewById(R.id._1);
        TextView n_b = (TextView) findViewById(R.id._2);
        TextView n_c = (TextView) findViewById(R.id._3);
        TextView n_d = (TextView) findViewById(R.id._4);
        n_e = (TextView) findViewById(R.id._5);
        TextView n_f = (TextView) findViewById(R.id._6);




        t_a.setMinWidth(width);
        t_b.setMinWidth(width);
        t_c.setMinWidth(width);
        t_d.setMinWidth(width);
        t_e.setMinWidth(width);
        t_f.setMinWidth(width);
        t_g.setMinWidth(width);
        t_h.setMinWidth(width);

        n_a.setMinHeight(hieght);
        n_b.setMinHeight(hieght);
        n_c.setMinHeight(hieght);
        n_d.setMinHeight(hieght);
        n_e.setMinHeight(hieght);



       // Log.d("Xpos", " : " +a);
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.mDetector.onTouchEvent(event);
        // Be sure to call the superclass implementation
        return super.onTouchEvent(event);
    }

    public void pass(View v)
    {
       Log.d("T","clicked");
       a=v.getY();
       b = v.getScaleY();
       c = v.getTop();
       d= v.getClipBounds();

    }

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDoubleTap(MotionEvent event) {

           Log.d("Ypos", " : "+a);
            Log.d("Yscale", " : "+b);
            Log.d("Ytop", " : "+c);
           // Log.d("Yrect", " : "+d.centerX());
           // Log.d("Ypos"," : "+b);
            return true;
        }

    }
}
