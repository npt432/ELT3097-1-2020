package uet.vnu.quizlet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

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
                Intent backScreen = new Intent(TestActivity_summary.this, SetSelectedActivity.class);
                startActivity(backScreen);
            }
        });

        button_retake = (Button)findViewById(R.id.buttonAnswer1);
        button_retake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(TestActivity_summary.this, TestActivity.class);
                startActivity(nextScreen);
            }
        });
    }
}