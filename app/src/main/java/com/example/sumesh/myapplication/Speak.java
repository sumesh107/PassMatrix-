package com.example.sumesh.myapplication;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

public class Speak extends AppCompatActivity {

    TextToSpeech t1;
    String str,str1;
    double j = 0.5;
    float h = (float) j;
    Random r = new Random();
    int range = r.nextInt(7);
    int range1 = r.nextInt(7);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speak);

        Button b1 = (Button) findViewById(R.id.play);
        Button b2 = (Button) findViewById(R.id.go);
        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }
            }
        });



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch(range){
                    case 1:str ="two";
                        break;

                    case 2:str ="two";
                        break;

                    case 3:str ="three";
                        break;

                    case 4:str="four";
                        break;

                    case 5:str="five";
                        break;

                    case 6:str="six";
                        break;

                    default:str="five";
                }

                switch(range1){
                    case 1:str1 ="B";
                        break;

                    case 2:str1 ="B";
                        break;

                    case 3:str1 ="C";
                        break;

                    case 4:str1 ="D";
                        break;

                    case 5:str1="E";
                        break;

                    case 6:str1="F";
                        break;

                    default:str1="E";
                }

                t1.setSpeechRate(h);
                String toSpeak = str1+" "+str;
                Toast.makeText(getApplicationContext(), "Playing...", Toast.LENGTH_SHORT).show();
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Pass_Activity.class);
                intent.putExtra("speak",range);
                intent.putExtra("speak1",str1);
                startActivity(intent);
                finish();

            }
        });
    }
}

