package uet.vnu.quizlet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import java.util.Random;

public class TestActivity_choose_answer extends AppCompatActivity {

    private Class[] classes = new Class[3];
    ImageButton Ibutton_back;
    Button button_answer_1;
    Button button_answer_2;
    Button button_answer_3;
    Button button_answer_4;
    ProgressBar progressBarRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_choose_answer);

        classes[0] = TestActivity_choose_answer_true_false.class;
        classes[1] = TestActivity_type_answer.class;
        Random random = new Random();
        final int r = random.nextInt(2);

        progressBarRegister = (ProgressBar) findViewById(R.id.progressBarRegister);
        Intent intent = getIntent();
        int data = intent.getIntExtra("progressBarCurrent",0);
        progressBarRegister.setProgress(data);

        Ibutton_back = (ImageButton)findViewById(R.id.imageButtonBack);
        Ibutton_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backScreen = new Intent(TestActivity_choose_answer.this, TestActivity.class);
                startActivity(backScreen);
            }
        });

        button_answer_1 = (Button) findViewById(R.id.buttonAnswer_1);
        button_answer_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(TestActivity_choose_answer.this, classes[r]);
                int current  = progressBarRegister.getProgress();
                nextScreen.putExtra("progressBarCurrent",current);
                startActivity(nextScreen);
            }
        });

        button_answer_2 = (Button) findViewById(R.id.buttonAnswer_2);
        button_answer_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(TestActivity_choose_answer.this, classes[r]);
                int current  = progressBarRegister.getProgress();
                nextScreen.putExtra("progressBarCurrent",current);
                startActivity(nextScreen);
            }
        });

        button_answer_3 = (Button) findViewById(R.id.buttonAnswer_3);
        button_answer_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(TestActivity_choose_answer.this, classes[r]);
                int current  = progressBarRegister.getProgress();
                nextScreen.putExtra("progressBarCurrent",current);
                startActivity(nextScreen);
            }
        });

        button_answer_4 = (Button) findViewById(R.id.buttonAnswer_4);
        button_answer_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(TestActivity_choose_answer.this, TestActivity_summary.class);
                int current  = progressBarRegister.getProgress();
                nextScreen.putExtra("progressBarCurrent",current);
                startActivity(nextScreen);
            }
        });
    }
}