package uet.vnu.quizlet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import java.util.Random;

public class TestActivity_choose_answer_true_false extends AppCompatActivity {

    private Class[] classes = new Class[3];
    Button button_true;
    Button button_false;
    ImageButton Ibutton_back;
    ProgressBar progressBarRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_choose_answer_true_false);

        classes[0] = TestActivity_choose_answer.class;
        classes[1] = TestActivity_type_answer.class;
        Random random = new Random();
        final int r = random.nextInt(2);

        progressBarRegister = (ProgressBar) findViewById(R.id.progressBarRegister);
        Intent intent = getIntent();
        int data = intent.getIntExtra("progressBarCurrent",0);
        progressBarRegister.setProgress(data);

        button_true = (Button) findViewById(R.id.buttonTrue);
        button_true.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(TestActivity_choose_answer_true_false.this, classes[r]);
                int current  = progressBarRegister.getProgress();
                nextScreen.putExtra("progressBarCurrent",current);
                startActivity(nextScreen);
            }
        });

        button_false = (Button)findViewById(R.id.buttonFalse);
        button_false.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(TestActivity_choose_answer_true_false.this, classes[r]);
                int current  = progressBarRegister.getProgress();
                nextScreen.putExtra("progressBarCurrent",current);
                startActivity(nextScreen);
            }
        });

        Ibutton_back = (ImageButton)findViewById(R.id.imageButtonBack);
        Ibutton_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backScreen = new Intent(TestActivity_choose_answer_true_false.this, TestActivity.class);
                startActivity(backScreen);
            }
        });

    }
}