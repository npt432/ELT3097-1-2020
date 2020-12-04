package uet.vnu.quizlet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class TestActivity extends AppCompatActivity {
private Class[] classes = new Class[3];

    Button button_start;
    ImageButton Ibutton_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        classes[0] = TestActivity_choose_answer.class;
        classes[1] = TestActivity_choose_answer_true_false.class;
        classes[2] = TestActivity_type_answer.class;
        Random r = new Random();

        button_start = (Button)findViewById(R.id.buttonStartTest);
        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent nextScreen = new Intent(this, classes[r.nextInt(classes.length)]);
                Intent nextScreen = new Intent(TestActivity.this, TestActivity_choose_answer_true_false.class);
                startActivity(nextScreen);
            }
        });
        Ibutton_back = (ImageButton)findViewById(R.id.imageButtonBack);
        Ibutton_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backScreen = new Intent(TestActivity.this, SetSelectedActivity.class);
                startActivity(backScreen);
            }
        });


    }
}