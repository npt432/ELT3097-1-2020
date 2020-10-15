package com.example.myapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    ImageButton Ibutton_back;
    Button button_toikhongbiet;
    EditText dapAn;

    @SuppressLint("ClickableViewAccessibility")
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        Ibutton_back = (ImageButton)findViewById(R.id.imageButton2);
        Ibutton_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backScreen = new Intent(MainActivity2.this, MainActivity1.class);
                startActivity(backScreen);
            }
        });

        button_toikhongbiet = (Button)findViewById(R.id.button3);
        button_toikhongbiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent nextScreen = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(nextScreen);
            }
        });

        dapAn = (EditText) findViewById(R.id.editTextTextPersonName);
        dapAn.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                button_toikhongbiet.setVisibility(View.INVISIBLE);
                return false;
            }
        });
        dapAn.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
                return false;
            }
        });

    }
}