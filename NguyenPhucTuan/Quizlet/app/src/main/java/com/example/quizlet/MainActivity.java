package com.example.quizlet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.Delayed;

public class MainActivity extends AppCompatActivity {

    TextView ques, amoutQues, exactOnce, exactTwice, wrong, right, ctn;
    ImageButton quit, adjust;
    Button ans1, ans2, ans3, ans4;
    ProgressBar bar;
    int numExactOnce = 0, numExactTwice = 0, numAmoutQues = 50;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();
        exactTwice.setText(String.valueOf(numExactTwice));
        exactOnce.setText(String.valueOf(numExactOnce));
        amoutQues.setText(String.valueOf(numAmoutQues));

        wrong.setVisibility(View.INVISIBLE);
        right.setVisibility(View.INVISIBLE);
        ctn.setVisibility(View.INVISIBLE);

        ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wrongAns();
            }
        });
        ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wrongAns();
            }
        });
        ans3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rightAns();
            }
        });
        ans4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wrongAns();
            }
        });

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Chức năng chưa hoàn thiện!",Toast.LENGTH_SHORT).show();
            }
        });
        adjust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Chức năng chưa hoàn thiện!",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void mapping(){
            ques = (TextView) findViewById(R.id.question_textView);
            amoutQues = (TextView) findViewById(R.id.amoutQuestion_textView);
            exactOnce = (TextView) findViewById(R.id.exactOnce_textView);
            exactTwice = (TextView) findViewById(R.id.exactTwice_textView);
            quit  = (ImageButton) findViewById(R.id.quit_imageButton);
            adjust = (ImageButton) findViewById(R.id.adjust_imageButton);
            ans1 = (Button) findViewById(R.id.answer1_button);
            ans2 = (Button) findViewById(R.id.answer2_button);
            ans3 = (Button) findViewById(R.id.answer3_button);
            ans4 = (Button) findViewById(R.id.answer4_button);
            bar = (ProgressBar) findViewById(R.id.progressBar);
            wrong = (TextView) findViewById(R.id.wrong_textView);
            right = (TextView) findViewById(R.id.right_textView);
            ctn = (TextView) findViewById(R.id.continue_textView);
    }

    private void visible(){
        ques.setVisibility(View.VISIBLE);
        ans1.setVisibility(View.VISIBLE);
        ans2.setVisibility(View.VISIBLE);
        ans3.setVisibility(View.VISIBLE);
        ans4.setVisibility(View.VISIBLE);
    }

    private void invisible(){
        ques.setVisibility(View.INVISIBLE);
        ans1.setVisibility(View.INVISIBLE);
        ans2.setVisibility(View.INVISIBLE);
        ans3.setVisibility(View.INVISIBLE);
        ans4.setVisibility(View.INVISIBLE);
    }

    private void wrongAns(){
        invisible();
        wrong.setVisibility(View.VISIBLE);
        ctn.setVisibility(View.VISIBLE);
        ctn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visible();
                wrong.setVisibility(View.INVISIBLE);
                ctn.setVisibility(View.INVISIBLE);
            }
        });
    }
    private void rightAns(){
        invisible();
        right.setVisibility(View.VISIBLE);
        ctn.setVisibility(View.VISIBLE);
        ctn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visible();
                right.setVisibility(View.INVISIBLE);
                ctn.setVisibility(View.INVISIBLE);
            }
        });
        numExactOnce += 1;
        numAmoutQues -= 1;
        exactOnce.setText(String.valueOf(numExactOnce));
        amoutQues.setText(String.valueOf(numAmoutQues));
    }

}