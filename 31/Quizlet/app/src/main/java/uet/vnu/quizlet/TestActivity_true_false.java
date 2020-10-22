package uet.vnu.quizlet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class TestActivity_true_false extends AppCompatActivity {

    Button button_true;
    Button button_false;
    ImageButton Ibutton_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_true_false);

        button_true = (Button) findViewById(R.id.button);
        button_true.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(TestActivity_true_false.this, TestActivity_write.class);
                startActivity(nextScreen);
            }
        });

        button_false = (Button)findViewById(R.id.button2);
        button_false.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(TestActivity_true_false.this, TestActivity_write.class);
                startActivity(nextScreen);
            }
        });

        Ibutton_back = (ImageButton)findViewById(R.id.imageButton2);
        Ibutton_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backScreen = new Intent(TestActivity_true_false.this, TestActivity.class);
                startActivity(backScreen);
            }
        });

    }
}