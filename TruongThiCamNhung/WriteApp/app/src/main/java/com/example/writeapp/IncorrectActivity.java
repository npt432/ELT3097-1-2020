package com.example.writeapp;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class
IncorrectActivity extends AppCompatActivity {
  EditText editDataEntry;
  TextView tvWordInput;
  TextView tvWrongAnswer;
  Button btnCheck;
  ProgressBar pbProgressRegister;
  Button btnAnswer;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_incorrect);
    editDataEntry = (EditText) findViewById(R.id.editDataEntry);
    btnAnswer = (Button) findViewById(R.id.btnAnswer);
    btnCheck = (Button) findViewById(R.id.btnCheck);
    tvWordInput = (TextView) findViewById(R.id.tvWordInput);
    tvWrongAnswer = (TextView) findViewById(R.id.tvWrongAnswer);
    pbProgressRegister = (ProgressBar) findViewById(R.id.pbProgressRegister);
    Intent intent = getIntent();
    String data = intent.getStringExtra("data");
    tvWrongAnswer.setText(data);

  }
}