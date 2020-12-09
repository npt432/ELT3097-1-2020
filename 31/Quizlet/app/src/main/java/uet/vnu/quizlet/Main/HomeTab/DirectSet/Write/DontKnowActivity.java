package uet.vnu.quizlet.Main.HomeTab.DirectSet.Write;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import uet.vnu.quizlet.R;

public class DontKnowActivity extends AppCompatActivity {
    EditText editTextDataEntry;
    TextView textViewWordInput;
    ProgressBar  progressBarProgressRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dont_know);
        editTextDataEntry = (EditText) findViewById(R.id.editTextDataEntry);
        textViewWordInput = (TextView) findViewById(R.id.textViewWordInput);
        progressBarProgressRegister = (ProgressBar) findViewById(R.id. progressBarProgressRegister);
        Intent pbCurrent = getIntent();
        int current = pbCurrent.getIntExtra("progressBarCurrent",0);
        //cong them 20 khi dung
        progressBarProgressRegister.setProgress( current);
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
    }

    public void correctAnswer() {
        String str = null;
        editTextDataEntry.setText(str);// set lai editText
        Intent intent =new Intent(DontKnowActivity.this, WriteCorrectActivity.class);
        startActivity(intent);
    }
    public void incorrectAnswer() {
        Intent intent =new Intent(DontKnowActivity.this, WriteIncorrectActivity.class);
        String dapAn = editTextDataEntry.getText().toString();
        intent.putExtra("dataEntry",dapAn);
        startActivity(intent);
    }
}