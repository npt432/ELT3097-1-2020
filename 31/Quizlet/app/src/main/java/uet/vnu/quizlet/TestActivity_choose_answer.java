package uet.vnu.quizlet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class TestActivity_choose_answer extends AppCompatActivity {
    ImageButton Ibutton_back;
    Button button_answer_1;
    Button button_answer_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_choose_answer);

        Ibutton_back = (ImageButton)findViewById(R.id.imageButtonBack);
        Ibutton_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backScreen = new Intent(TestActivity_choose_answer.this, TestActivity_type_answer.class);
                startActivity(backScreen);
            }
        });

        button_answer_1 = (Button) findViewById(R.id.buttonRetake);
        button_answer_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(TestActivity_choose_answer.this, TestActivity_summary.class);
                startActivity(nextScreen);
            }
        });

        button_answer_2 = (Button) findViewById(R.id.button6);
        button_answer_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(TestActivity_choose_answer.this, TestActivity_summary.class);
                startActivity(nextScreen);
            }
        });

    }
}