package uet.vnu.quizlet.Main.HomeTab.DirectSet.Write;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ProgressBar;
import uet.vnu.quizlet.R;

public class WriteCorrectActivity extends AppCompatActivity {
    ProgressBar progressBarProgressRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_correct);
        progressBarProgressRegister = (ProgressBar) findViewById(R.id. progressBarProgressRegister);
        Intent pbCurrent = getIntent();
        int current = pbCurrent.getIntExtra("progressBarCurrent",0);
        //cong them 20 khi dung
        progressBarProgressRegister.setProgress( current + 20);
        CountDownTimer countDownTimer = new CountDownTimer(2000,500) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(WriteCorrectActivity.this, WriteActivity.class);
                int current  = progressBarProgressRegister.getProgress();
                intent.putExtra("progressBarCurrent",current);
                startActivity(intent);
                onBackPressed();
            }
        };
        countDownTimer.start();
    }

}