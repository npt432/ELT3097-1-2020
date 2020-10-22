package uet.vnu.quizlet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  Button learnButton;
  Button flashCardButton;
  Button writeButton;
  Button matchButton;
  Button testButton;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    learnButton = (Button) findViewById(R.id.learnButton);
    flashCardButton = (Button) findViewById(R.id.flashCardButton);
    writeButton = (Button) findViewById(R.id.writeButton);
    matchButton = (Button) findViewById(R.id.matchButton);
    testButton = (Button) findViewById(R.id.testButton);

    learnButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent learnActivity = new Intent(MainActivity.this, LearnActivity.class);
        startActivity(learnActivity);
      }
    });

    writeButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent writeActivity = new Intent(MainActivity.this, WriteActivity.class);
        startActivity(writeActivity);
      }
    });

    testButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent testActivity = new Intent(MainActivity.this, TestActivity.class);
        startActivity(testActivity);
      }
    });

  }
}