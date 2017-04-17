package com.example.sumesh.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // User name
        final EditText et_Username;
        // Sign In
        final Button bt_SignIn;
        Button bt_Register;
            // Initialization
            et_Username = (EditText) findViewById(R.id.et_Username);
            bt_SignIn = (Button) findViewById(R.id.bt_SignIn);
            bt_Register = (Button) findViewById(R.id.bt_Register);


            bt_SignIn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    String username = String.valueOf(et_Username.getText());

                    // Validates the User name and Password for admin, admin
                    if (username.equals("admin")) {
                        Toast.makeText(view.getContext(), "Username authenticated ! ",
                                Toast.LENGTH_LONG).show();
                        bt_SignIn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(view.getContext(),Speak.class);
                                startActivity(intent);
                                finish();
                            }
                        });
                    }
                    else {
                        et_Username.setText(" ");
                        et_Username.setBackgroundColor(2);
                    }
                }
            });

        bt_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
