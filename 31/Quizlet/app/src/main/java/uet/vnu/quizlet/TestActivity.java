package uet.vnu.quizlet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class TestActivity extends AppCompatActivity {

    Button button_start;
    ImageButton Ibutton_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_start = (Button)findViewById(R.id.button4);
        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(MainActivity.this, TestActivity_true_false.);
                startActivity(nextScreen);
            }
        });
        Ibutton_back = (ImageButton)findViewById(R.id.imageButton2);
        Ibutton_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backScreen = new Intent(TestActivity.this, MainActivity.class);
                startActivity(backScreen);
            }
        });


    }
}