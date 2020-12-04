package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity1 extends AppCompatActivity {

    Button button_đúng;
    Button button_sai;
    ImageButton Ibutton_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        button_đúng = (Button) findViewById(R.id.button);
        button_đúng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(MainActivity1.this, MainActivity2.class);
                nextScreen.putExtra("progressbar", 0);
                startActivity(nextScreen);
            }
        });

        button_sai = (Button)findViewById(R.id.button2);
        button_sai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(MainActivity1.this, MainActivity2.class);
                startActivity(nextScreen);
            }
        });

        Ibutton_back = (ImageButton)findViewById(R.id.imageButton2);
        Ibutton_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backScreen = new Intent(MainActivity1.this, MainActivity.class);
                startActivity(backScreen);
            }
        });

    }
}