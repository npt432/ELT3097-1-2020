package uet.vnu.quizlet.Main.HomeTab.DirectSet.Test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import uet.vnu.quizlet.Main.HomeTab.SetSelectedActivity;
import uet.vnu.quizlet.R;

public class TestActivity extends AppCompatActivity {

    Button button_start;
    ImageButton Ibutton_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        button_start = (Button)findViewById(R.id.buttonStartTest);
        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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