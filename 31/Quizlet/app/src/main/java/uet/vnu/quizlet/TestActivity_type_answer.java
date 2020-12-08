package uet.vnu.quizlet;

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
import android.widget.ProgressBar;
import android.widget.TextView;

public class TestActivity_type_answer extends AppCompatActivity {

    EditText answer;
    ImageButton Ibutton_back;
    Button button_toikhongbiet;
    ProgressBar progressBarRegister;

    @SuppressLint("ClickableViewAccessibility")
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_type_answer);

        progressBarRegister = (ProgressBar) findViewById(R.id.progressBarRegister);
        Intent intent = getIntent();
        int data = intent.getIntExtra("progressBarCurrent",0);
        progressBarRegister.setProgress(data);

        Ibutton_back = (ImageButton)findViewById(R.id.imageButtonBack);
        Ibutton_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backScreen = new Intent(TestActivity_type_answer.this, TestActivity.class);
                startActivity(backScreen);
            }
        });

        button_toikhongbiet = (Button)findViewById(R.id.buttonIdontknow);
        button_toikhongbiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(TestActivity_type_answer.this, TestActivity_choose_answer.class);
                int current  = progressBarRegister.getProgress();
                nextScreen.putExtra("progressBarCurrent",current);
                startActivity(nextScreen);
            }
        });

        answer = (EditText) findViewById(R.id.editTextTextPersonName);
        answer.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                button_toikhongbiet.setVisibility(View.INVISIBLE);
                return false;
            }
        });
        answer.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                Intent nextScreen = new Intent(TestActivity_type_answer.this, TestActivity_choose_answer.class);
                int current  = progressBarRegister.getProgress();
                nextScreen.putExtra("progressBarCurrent",current);
                startActivity(nextScreen);
                return false;
            }
        });

    }
}