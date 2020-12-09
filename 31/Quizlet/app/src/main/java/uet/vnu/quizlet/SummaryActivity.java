package uet.vnu.quizlet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import uet.vnu.quizlet.adapter.CardAdapter;
import uet.vnu.quizlet.model.Card;

public class SummaryActivity extends AppCompatActivity {

    private ProgressBar pbRegister;
    private TextView tvPercent;
    private TextView tvNote;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        pbRegister = (ProgressBar) findViewById(R.id.pbRegister);
        tvPercent = (TextView) findViewById(R.id.tvPercent);
        tvNote = (TextView) findViewById(R.id.tvNote);


        int percent = pbRegister.getProgress();
        tvPercent.setText(percent +"%");

        if(percent == 100){
            tvNote.setText("Tốt lắm!");

        }
        else {
            tvNote.setText("Nỗ lực học thêm nữa bạn nhé!");
        }

    }
}



