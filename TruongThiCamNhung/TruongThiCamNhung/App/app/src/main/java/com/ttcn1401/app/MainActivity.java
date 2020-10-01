package com.ttcn1401.app;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b11;
    Button b12;
    Button b21;
    Button b22;
    Button b31;
    Button b32;
    Button b41;
    Button b42;
    Button b51;
    Button b52;
    Button b61;
    Button b62;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b11 = (Button) findViewById(R.id.b11);
        b12 = (Button) findViewById(R.id.b12);
        b21 = (Button) findViewById(R.id.b21);
        b22 = (Button) findViewById(R.id.b22);
        b31 = (Button) findViewById(R.id.b31);
        b32 = (Button) findViewById(R.id.b32);
        b41 = (Button) findViewById(R.id.b41);
        b42 = (Button) findViewById(R.id.b42);
        b51 = (Button) findViewById(R.id.b51);
        b52 = (Button) findViewById(R.id.b52);
        b61 = (Button) findViewById(R.id.b61);
        b62 = (Button) findViewById(R.id.b62);

        
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b11.setBackgroundColor(Color.YELLOW);
                b11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        b11.setBackgroundColor(Color.WHITE);
                    }
                });
            }
        });
        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b21.setBackgroundColor(Color.YELLOW);
            }
        });
        b31.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                b31.setBackgroundColor(Color.YELLOW);
            }
        });
        b41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b41.setBackgroundColor(Color.YELLOW);
            }
        });
        b51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b51.setBackgroundColor(Color.YELLOW);
            }
        })
        ;b61.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b61.setBackgroundColor(Color.YELLOW);
            }
        });


        /*CheckBox cb = new CheckBox("yellow/white");
        puplic bsk1(){
            add(cb);
            cb.addItemListener(this);
            this.setLayout(new FlowLayout());
        }
        private void onlClick(View v){
            if(v==b12) {
                b11.setBackgroundColor(Color.GREEN);
                b12.setBackgroundColor(Color.GREEN);

                b11.hide();
                b12.hide();
                return;
            }
            else{
                v.setBackgroundColor(Color.RED);
                b11.setBackgroundColor(Color.RED);
                b11.setBackgroundColor(Color.WHITE);
            }
        }
    */
    }
}