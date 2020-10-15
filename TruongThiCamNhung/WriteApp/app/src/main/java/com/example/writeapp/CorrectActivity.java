package com.example.writeapp;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class CorrectActivity extends AppCompatActivity {
  EditText editDataEntry;
  TextView tvWordInput;
  ProgressBar pbProgressRegister;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_correct);
    editDataEntry = (EditText) findViewById(R.id.editDataEntry);
    tvWordInput = (TextView) findViewById(R.id.tvWordInput);
    pbProgressRegister = (ProgressBar) findViewById(R.id.pbProgressRegister);
    int current = pbProgressRegister.getProgress();
    pbProgressRegister.setProgress(current + 20); //tang thanh ghi tien do len 20

  }
}