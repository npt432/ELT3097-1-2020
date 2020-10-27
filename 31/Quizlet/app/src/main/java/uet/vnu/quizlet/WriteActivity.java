package uet.vnu.quizlet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class WriteActivity extends AppCompatActivity {

    EditText editTextDataEntry;
    TextView textViewWordInput;
    Button buttonCheck;
    ProgressBar progressBarProgressRegister;
    Button buttonHint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        editTextDataEntry = (EditText) findViewById(R.id.editTextDataEntry);
        textViewWordInput = (TextView) findViewById(R.id.textViewWordInput);
        progressBarProgressRegister = (ProgressBar) findViewById(R.id.progressBarProgressRegister);
        buttonHint = (Button) findViewById(R.id.buttonHint);
        buttonCheck = (Button) findViewById(R.id.buttonCheck);
        buttonCheck.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dapAn = editTextDataEntry.getText().toString();
                if(!dapAn.isEmpty()){
                    if(dapAn.equals("Eat")){
                        correctAnswer();
                    }
                    else
                        incorrectAnswer();
                }
                else
                    incorrectAnswer();
            }
        }));
        buttonHint.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                incorrectAnswer();
            }
        });

    }

    public void correctAnswer() {
        String str = "dm";
        editTextDataEntry.setText(str,String);// set lai editText
        Intent intent =new Intent(WriteActivity.this,WriteCorrectActivity.class);
        startActivity(intent);
    }
    public void incorrectAnswer() {
        Intent intent =new Intent(WriteActivity.this,WriteIncorrectActivity.class);
        String dapAn = editTextDataEntry.getText().toString();
        intent.putExtra("data",dapAn);
        startActivity(intent);
    }
}