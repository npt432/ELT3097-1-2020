package com.example.writeapp;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
  EditText editDataEntry;
  TextView tvWordInput;
  Button btnCheck;
  ProgressBar pbProgressRegister;
  Button btnAnswer;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    editDataEntry = (EditText) findViewById(R.id.editDataEntry);
    btnAnswer = (Button) findViewById(R.id.btnAnswer);
    btnCheck = (Button) findViewById(R.id.btnCheck);
    tvWordInput = (TextView) findViewById(R.id.tvWordInput);
    pbProgressRegister = (ProgressBar) findViewById(R.id.pbProgressRegister);
    btnCheck.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String dapAn = editDataEntry.getText().toString();
        if(!dapAn.isEmpty()){
          if(dapAn.equals("Converge")){
            correctAnswer();
          }
          else
            incorrectAnswer();
        }
        else
          incorrectAnswer();
      }
    });

  }


  private void correctAnswer() {
    Intent intent =new Intent(MainActivity.this,CorrectActivity.class);
    startActivity(intent);
  }
  public void incorrectAnswer() {
    Intent intent =new Intent(MainActivity.this,IncorrectActivity.class);
    String dapAn = editDataEntry.getText().toString();
    intent.putExtra("data",dapAn);
    startActivity(intent);
  }
}
