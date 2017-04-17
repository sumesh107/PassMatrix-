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
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.id.button1;
import static android.R.id.button2;
import static android.R.id.switch_widget;


public class Pass_Activity extends AppCompatActivity {

    private GestureDetectorCompat mDetector;
    Button btn;
    String sr;
    int num;
    int row , col , s;
    int x , y;
    ScrollView scroll;
    TextView t_a,t_b,t_c,t_d,t_e,t_f,n_a,n_b,n_c,n_d,n_e,n_f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_);

        Intent intent3 = getIntent();
        num = intent3.getIntExtra("speak",0);
        sr = intent3.getStringExtra("speak1");

        Log.d("num",": "+num);
        Log.d("str",sr);

       // int width = intent.getIntExtra("width", 0);
        //int hieght = intent.getIntExtra("hieght", 0);

        final int width = MainActivity.chunkWidth;
        final int hieght = MainActivity.chunkHeight;

        scroll = (ScrollView) findViewById(R.id.scrollView3);
        ImageView img = (ImageView) findViewById(R.id.imageView2);
        img.setImageBitmap(MainActivity.bit);


        /*mDetector = new GestureDetectorCompat(this, new MainActivity.MyGestureListener());
        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mDetector.onTouchEvent(event);
                return true;
            }
        });*/

        TextView t_aa = (TextView) findViewById(R.id._aa);
        t_a = (TextView) findViewById(R.id.aalpha);
        t_b = (TextView) findViewById(R.id.balpha);
        t_c = (TextView) findViewById(R.id.calpha);
        t_d = (TextView) findViewById(R.id.dalpha);
        t_e = (TextView) findViewById(R.id.ealpha);
        t_f = (TextView) findViewById(R.id.falpha);
        TextView t_g = (TextView) findViewById(R.id.galpha);
        TextView t_h = (TextView) findViewById(R.id.halpha);
        TextView n_aa = (TextView) findViewById(R.id._0);
        n_a = (TextView) findViewById(R.id._1);
        n_b = (TextView) findViewById(R.id._2);
        n_c = (TextView) findViewById(R.id._3);
        n_d = (TextView) findViewById(R.id._4);
        n_e = (TextView) findViewById(R.id._5);
        n_f = (TextView) findViewById(R.id._6);



        t_aa.setMinWidth(width+100);
        t_a.setMaxWidth(width);
        t_b.setMaxWidth(width);
        t_c.setMaxWidth(width);
        t_d.setMaxWidth(width);
        t_e.setMaxWidth(width);
        t_f.setMaxWidth(width);
        t_g.setMaxWidth(width);
        t_h.setMaxWidth(width);

        n_aa.setMinHeight(hieght+100);
        n_a.setMaxHeight(hieght);
        n_b.setMaxHeight(hieght);
        n_c.setMaxHeight(hieght);
        n_d.setMaxHeight(hieght);
        n_e.setMaxHeight(hieght);
        n_f.setMaxHeight(hieght);


        btn = (Button) findViewById(R.id.button2);


        /*switch(sr) {

            case "A":
                        t_a.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                            public void onGlobalLayout() {

                            }
                        });
                        t_a.getViewTreeObserver();
                        btn.getViewTreeObserver();

                        int[] locations_1 = new int[2];
                        t_a.getLocationOnScreen(locations_1);
                        x = locations_1[0];
                        int col = (int) (x / width);
                        Log.d("TAG","col : "+col);
                        Log.d("TAG", "but");
                break;

            case "B":
                        t_b.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                            public void onGlobalLayout() {

                            }
                        });
                        t_b.getViewTreeObserver();
                        btn.getViewTreeObserver();

                locations_1 = new int[2];
                        t_b.getLocationOnScreen(locations_1);
                x = locations_1[0];
                col = (int) (x / width);
                        Log.d("TAG","col : "+col);
                        Log.d("TAG", "but");
                break;

            case "C":
                        t_c.getViewTreeObserver();
                        btn.getViewTreeObserver();

                locations_1 = new int[2];
                t_c.getLocationOnScreen(locations_1);
                x = locations_1[0];
                col = (int) (x / width);
                        Log.d("TAG","col : "+col);
                        Log.d("TAG", "but");
                break;

            case "D":
                t_d.getViewTreeObserver();
                btn.getViewTreeObserver();

                locations_1 = new int[2];
                t_d.getLocationOnScreen(locations_1);
                x = locations_1[0];
                col = (int) (x / width);
                Log.d("TAG","col : "+col);
                Log.d("TAG", "but");
                break;

            case "E":
                t_e.getViewTreeObserver();
                btn.getViewTreeObserver();

                locations_1 = new int[2];
                t_e.getLocationOnScreen(locations_1);
                x = locations_1[0];
                col = (int) (x / width);
                Log.d("TAG","col : "+col);
                Log.d("TAG", "but");
                break;

            case "F":
                t_f.getViewTreeObserver();
                btn.getViewTreeObserver();

                locations_1 = new int[2];
                t_f.getLocationOnScreen(locations_1);
                x = locations_1[0];
                col = (int) (x / width);
                Log.d("TAG","col : "+col);
                Log.d("TAG", "but");
                break;

            default:t_d.getViewTreeObserver();
                btn.getViewTreeObserver();

                locations_1 = new int[2];
                t_d.getLocationOnScreen(locations_1);
                x = locations_1[0];
                col = (int) (x / width);
                Log.d("TAG","col : "+col);
                Log.d("TAG", "but");
                break;


        } //end of switch*/


        switch(num) {

            case 1:
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    n_a.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                        public void onGlobalLayout() {

                        }
                    });
                    t_e.getViewTreeObserver();
                    n_a.getViewTreeObserver();
                    btn.getViewTreeObserver();

                    int locations_1[] = new int[2];
                    t_e.getLocationOnScreen(locations_1);
                    x = locations_1[0];

                    int[] locations = new int[2];
                    n_a.getLocationOnScreen(locations);
                    y = locations[1];
                    y = y - 100;
                    //Log.d("x",String.valueOf(x));
                    //Log.d("y",String.valueOf(y));
                    row = (int) (y / hieght);
                    col = (int) (x/width);
                                //hardcode !!!

                    Log.d("Scroll Pass ", "Y= " + y + " X= " + x);
                    Log.d("Pass ", "row " + row + " &col " + col);
                    Log.d("TAG", "but");

                    int s = (col) + ((row) * 6);
                    Log.d("val",": "+s);
                    Intent intent2 = new Intent(view.getContext(),Result.class);
                    intent2.putExtra("result", s);
                    startActivity(intent2);
                    finish();

                }
            });
            break;

            case 2:
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        n_b.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                            public void onGlobalLayout() {

                            }
                        });
                        t_e.getViewTreeObserver();
                        n_b.getViewTreeObserver();
                        btn.getViewTreeObserver();

                        int locations_1[] = new int[2];
                        t_e.getLocationOnScreen(locations_1);
                        x = locations_1[0];

                        int[] locations = new int[2];
                        n_b.getLocationOnScreen(locations);
                        y = locations[1];
                        y = y - 100;
                        //Log.d("x",String.valueOf(x));
                        //Log.d("y",String.valueOf(y));
                        row = (int) (y / hieght);
                        col = (int) (x/width);
                        //hardcode !!!

                        Log.d("Scroll Pass ", "Y= " + y + " X= " + x);
                        Log.d("Pass ", "row " + row + " &col " + col);
                        Log.d("TAG", "but");

                        int s = (col) + ((row) * 6);
                        Log.d("val",": "+s);
                        Intent intent2 = new Intent(view.getContext(),Result.class);
                        intent2.putExtra("result", s);
                        startActivity(intent2);
                        finish();
                    }
                });
                break;

            case 3:
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        n_c.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                            public void onGlobalLayout() {

                            }
                        });
                        t_e.getViewTreeObserver();
                        n_b.getViewTreeObserver();
                        btn.getViewTreeObserver();

                        int locations_1[] = new int[2];
                        t_e.getLocationOnScreen(locations_1);
                        x = locations_1[0];

                        int[] locations = new int[2];
                        n_c.getLocationOnScreen(locations);
                        y = locations[1];
                        y = y - 100;
                        //Log.d("x",String.valueOf(x));
                        //Log.d("y",String.valueOf(y));
                        row = (int) (y / hieght);
                        col = (int) (x/width);
                        //hardcode !!!

                        Log.d("Scroll Pass ", "Y= " + y + " X= " + x);
                        Log.d("Pass ", "row " + row + " &col " + col);
                        Log.d("TAG", "but");

                        int s = (col) + ((row) * 6);
                        Log.d("val",": "+s);
                        Intent intent2 = new Intent(view.getContext(),Result.class);
                        intent2.putExtra("result", s);
                        startActivity(intent2);
                        finish();

                    }
                });
                break;

            case 4:
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        n_d.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                            public void onGlobalLayout() {

                            }
                        });

                        t_e.getViewTreeObserver();
                        n_d.getViewTreeObserver();
                        btn.getViewTreeObserver();

                        int locations_1[] = new int[2];
                        t_e.getLocationOnScreen(locations_1);
                        x = locations_1[0];

                        int[] locations = new int[2];
                        n_d.getLocationOnScreen(locations);
                        y = locations[1];
                        y = y - 100;
                        //Log.d("x",String.valueOf(x));
                        //Log.d("y",String.valueOf(y));
                        row = (int) (y / hieght);
                        col = (int) (x/width);
                        //hardcode !!!

                        Log.d("Scroll Pass ", "Y= " + y + " X= " + x);
                        Log.d("Pass ", "row " + row + " &col " + col);
                        Log.d("TAG", "but");

                        int s = (col) + ((row) * 6);
                        Log.d("val",": "+s);
                        Intent intent2 = new Intent(view.getContext(),Result.class);
                        intent2.putExtra("result", s);
                        startActivity(intent2);
                        finish();

                    }
                });
                break;

            case 5:
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        n_e.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                            public void onGlobalLayout() {

                            }
                        });
                        t_e.getViewTreeObserver();
                        n_e.getViewTreeObserver();
                        btn.getViewTreeObserver();

                        int locations_1[] = new int[2];
                        t_e.getLocationOnScreen(locations_1);
                        x = locations_1[0];

                        int[] locations = new int[2];
                        n_e.getLocationOnScreen(locations);
                        y = locations[1];
                        y = y - 100;
                        //Log.d("x",String.valueOf(x));
                        //Log.d("y",String.valueOf(y));
                        row = (int) (y / hieght);
                        col = (int) (x/width);
                        //hardcode !!!

                        Log.d("Scroll Pass ", "Y= " + y + " X= " + x);
                        Log.d("Pass ", "row " + row + " &col " + col);
                        Log.d("TAG", "but");

                        int s = (col) + ((row) * 6);
                        Log.d("val",": "+s);
                        Intent intent2 = new Intent(view.getContext(),Result.class);
                        intent2.putExtra("result", s);
                        startActivity(intent2);
                        finish();

                    }
                });
                break;

            case 6:
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        n_f.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                            public void onGlobalLayout() {

                            }
                        });
                        t_e.getViewTreeObserver();
                        n_f.getViewTreeObserver();
                        btn.getViewTreeObserver();

                        int locations_1[] = new int[2];
                        t_e.getLocationOnScreen(locations_1);
                        x = locations_1[0];

                        int[] locations = new int[2];
                        n_f.getLocationOnScreen(locations);
                        y = locations[1];
                        y = y - 100;
                        //Log.d("x",String.valueOf(x));
                        //Log.d("y",String.valueOf(y));
                        row = (int) (y / hieght);
                        col = (int) (x/width);
                        //hardcode !!!

                        Log.d("Scroll Pass ", "Y= " + y + " X= " + x);
                        Log.d("Pass ", "row " + row + " &col " + col);
                        Log.d("TAG", "but");

                        int s = (col) + ((row) * 6);
                        Log.d("val",": "+s);
                        Intent intent2 = new Intent(view.getContext(),Result.class);
                        intent2.putExtra("result", s);
                        startActivity(intent2);
                        finish();
                    }
                });
                break;

            default:btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    n_e.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                        public void onGlobalLayout() {

                        }
                    });
                    t_e.getViewTreeObserver();
                    n_e.getViewTreeObserver();
                    btn.getViewTreeObserver();

                    int locations_1[] = new int[2];
                    t_e.getLocationOnScreen(locations_1);
                    x = locations_1[0];

                    int[] locations = new int[2];
                    n_e.getLocationOnScreen(locations);
                    y = locations[1];
                    y = y - 100;
                    //Log.d("x",String.valueOf(x));
                    //Log.d("y",String.valueOf(y));
                    row = (int) (y / hieght);
                    col = (int) (x/width);
                    //hardcode !!!

                    Log.d("Scroll Pass ", "Y= " + y + " X= " + x);
                    Log.d("Pass ", "row " + row + " &col " + col);
                    Log.d("TAG", "but");

                    int s = (col) + ((row) * 6);
                    Log.d("val",": "+s);
                    Intent intent2 = new Intent(view.getContext(),Result.class);
                    intent2.putExtra("result", s);
                    startActivity(intent2);
                    finish();


                }
            });
                break;



        } //end of switch


    }



    /*@Override
    public boolean onTouchEvent(MotionEvent event) {
        this.mDetector.onTouchEvent(event);
        // Be sure to call the superclass implementation
        return super.onTouchEvent(event);
    }

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDoubleTap(MotionEvent event) {

            n_e.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    n_e.getViewTreeObserver().removeGlobalOnLayoutListener(this);

                    int[] locations = new int[2];
                    n_e.getLocationOnScreen(locations);
                    int x = locations[0];
                    int y = locations[1];
                    Log.d("x",String.valueOf(x));
                    Log.d("y",String.valueOf(y));
                    Log.d("TAG","double tapping");
                }
            });

            //Log.d("Ypos", " : "+a);
            //Log.d("Yscale", " : "+b);
            //Log.d("Ytop", " : "+c);*//**//*
           // Log.d("Yrect", " : "+d.centerX());
           // Log.d("Ypos"," : "+b);
            return true;
        }

    }*/

            /*  n_e.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                n_e.getViewTreeObserver();
                btn.getViewTreeObserver();

                int[] locations = new int[2];
                n_e.getLocationOnScreen(locations);
                int x = locations[0];
                int y = locations[1];
                Log.d("x",String.valueOf(x));
                Log.d("y",String.valueOf(y));
                Log.d("TAG","double tapping");
            }
        });*/
}
