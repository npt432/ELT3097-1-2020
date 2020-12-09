package uet.vnu.quizlet.Main.HomeTab.DirectSet.Write;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import uet.vnu.quizlet.R;

public class WriteActivity extends AppCompatActivity {

    EditText editTextDataEntry;
    TextView textViewWordInput;
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
        Intent intent = getIntent();
        int data = intent.getIntExtra("progressBarCurrent",0);
        progressBarProgressRegister.setProgress(data);
        editTextDataEntry.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
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
                return false;
            }
        });
        buttonHint.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(WriteActivity.this, DontKnowActivity.class);
                int current  = progressBarProgressRegister.getProgress();
                intent.putExtra("progressBarCurrent",current);
                startActivity(intent);
            }
        });

    }

    public void correctAnswer() {
        String str = null;
        editTextDataEntry.setText(str);// set lai editText
        Intent intent =new Intent(WriteActivity.this,WriteCorrectActivity.class);
        int current  = progressBarProgressRegister.getProgress();
        intent.putExtra("progressBarCurrent",current);
        startActivity(intent);
    }
    public void incorrectAnswer() {

        Intent intent =new Intent(WriteActivity.this,WriteIncorrectActivity.class);
        String dapAn = editTextDataEntry.getText().toString();
        intent.putExtra("dataEntry",dapAn);
        int current  = progressBarProgressRegister.getProgress();
        intent.putExtra("progressBarCurrent",current);
        startActivity(intent);
    }
}