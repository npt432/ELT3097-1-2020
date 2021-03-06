package uet.vnu.quizlet.Main.HomeTab.DirectSet.Test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import uet.vnu.quizlet.R;

public class TestActivity_choose_answer_true_false extends AppCompatActivity {

    Button button_true;
    Button button_false;
    ImageButton Ibutton_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_choose_answer_true_false);

        button_true = (Button) findViewById(R.id.buttonTrue);
        button_true.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(TestActivity_choose_answer_true_false.this, TestActivity_type_answer.class);
                startActivity(nextScreen);
            }
        });

        button_false = (Button)findViewById(R.id.buttonFalse);
        button_false.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(TestActivity_choose_answer_true_false.this, TestActivity_type_answer.class);
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