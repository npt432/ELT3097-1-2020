package com.ttcn1401.appviet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
     EditText edit;
     TextView tvIn;
     Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit = (EditText) findViewById(R.id.edit);
        tvIn = (TextView) findViewById(R.id.tvIn);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String DapAn = edit.getText().toString();
                if(!DapAn.isEmpty()){
                    if(DapAn.equals("Converge")){
                        CorrectAnswer();
                    }
                    else
                        IncorrectAnswer();
                }
                else
                    IncorrectAnswer();
            }
        });

    }


    public void CorrectAnswer() {
        Intent intent =new Intent(MainActivity.this,CorrectActivity.class);
        startActivity(intent);
    }
    public void IncorrectAnswer() {
        Intent intent =new Intent(MainActivity.this,IncorrectActivity.class);
        startActivity(intent);
    }
}
