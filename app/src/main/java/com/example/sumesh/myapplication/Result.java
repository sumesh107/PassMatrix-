package com.example.sumesh.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView t = (TextView) findViewById(R.id.result);
        Intent intent3 = getIntent();
        int res = intent3.getIntExtra("result",0);

        if (res == MainActivity.i)
        {
            t.setText(" Authentication successfull ");
        }
        else
        {
            t.setText(" Authentication Failed ");
        }
    }
}
