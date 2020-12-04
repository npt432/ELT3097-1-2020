package uet.vnu.quizlet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class WriteIncorrectActivity extends AppCompatActivity {
    TextView textViewWrongAnswer;
    TextView textViewRightAnswer;
    EditText editTextDataEntry;
    Button buttonRight;
    ProgressBar progressBarProgressRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_incorrect);
        textViewRightAnswer = (TextView) findViewById(R.id.textViewRightAnswer);
        //textViewWrongAnswer =  (TextView) findViewById(R.id.textViewWrongAnswer);
        editTextDataEntry = (EditText) findViewById(R.id.editTextDataEntry);
        //buttonRight = (Button) findViewById(R.id.buttonRight);
        progressBarProgressRegister = (ProgressBar) findViewById(R.id.progressBarProgressRegister);
        // lay gia tri progress bar hien tai
        Intent pbCurrent = getIntent();
        int current = pbCurrent.getIntExtra("progressBarCurrent",0);
        //cong them 20 khi dung
        progressBarProgressRegister.setProgress( current);
        //lay chuoi da nhap
        Intent strInput = getIntent();
        String dataEntry = strInput.getStringExtra("dataEntry");
        textViewWrongAnswer.setText(dataEntry);
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
        // Tu nhap vao da dung nhung khong giong voi dap an
        buttonRight.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // tang progress bar
                int current = progressBarProgressRegister.getProgress();
                progressBarProgressRegister.setProgress( current +20);
                //chuyen activity
                Intent intent = new Intent (WriteIncorrectActivity.this, WriteActivity.class);
                //chuyen progress bar vao write
                int current1  = progressBarProgressRegister.getProgress();
                intent.putExtra("progressBarCurrent",current1);
                startActivity(intent);
            }
        });

    }

    public void correctAnswer() {
        String str = null;
        editTextDataEntry.setText(str);// set lai editText
        Intent intent =new Intent(WriteIncorrectActivity.this,WriteCorrectActivity.class);
        startActivity(intent);
    }
    public void incorrectAnswer() {
        Intent intent =new Intent(WriteIncorrectActivity.this,WriteIncorrectActivity.class);
        String dapAn = editTextDataEntry.getText().toString();
        intent.putExtra("dataEntry",dapAn);
        startActivity(intent);
    }
}