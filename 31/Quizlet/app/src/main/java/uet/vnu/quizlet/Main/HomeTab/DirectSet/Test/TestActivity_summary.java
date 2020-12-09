package uet.vnu.quizlet.Main.HomeTab.DirectSet.Test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import uet.vnu.quizlet.R;

public class TestActivity_summary extends AppCompatActivity {

    ImageButton Ibutton_back;
    Button button_retake;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_summary);

        Ibutton_back = (ImageButton)findViewById(R.id.imageButtonBack);
        Ibutton_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backScreen = new Intent(TestActivity_summary.this, TestActivity_choose_answer.class);
                startActivity(backScreen);
            }
        });

        button_retake = (Button)findViewById(R.id.buttonRetake);
        button_retake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(TestActivity_summary.this, TestActivity.class);
                startActivity(nextScreen);
            }
        });
    }
}