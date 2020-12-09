package uet.vnu.quizlet;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.Random;

@SuppressLint("UseSwitchCompatOrMaterialCode")
public class TestActivity extends AppCompatActivity {

    Switch written;
    Switch multiplechoice;
    Switch trueFalse;
    Switch definition;
    Switch term;
    private ArrayList<DataOfSet> dataList;

    private Class[] classes = new Class[3];
    private ViewPager viewPager;
    private View view;
    Button button_start;
    ImageButton Ibutton_back;
    ProgressBar progressBarRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        viewPager = (ViewPager) view.findViewById(R.id.viewPager2);

//        progressBarRegister = (ProgressBar) findViewById(R.id.progressBarRegister);
//        int data = 0;
//        progressBarRegister.setProgress(data);

        final int[] a = new int[3];

        trueFalse = (Switch)findViewById(R.id.switchTrueFalse);
        trueFalse.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    a[0]=0;
                    classes[a[0]] = TestActivity_choose_answer_true_false.class;
                }
            }
        });

        multiplechoice = (Switch)findViewById(R.id.switchMultiplechoice);
        multiplechoice.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    a[1]=1;
                    classes[a[1]] = TestActivity_choose_answer.class;
                }
            }
        });

        written = (Switch)findViewById(R.id.switchWritten);
        written.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    a[2]=2;
                    classes[a[2]] = TestActivity_type_answer.class;
                }
            }
        });
        Random random = new Random();
        final int r = random.nextInt(3);

        button_start = (Button)findViewById(R.id.buttonStartTest);
        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent nextScreen = new Intent(this, classes[r.nextInt(classes.length)]);
                Intent nextScreen = new Intent(TestActivity.this, classes[r]);
//                int current  = progressBarRegister.getProgress();
//                nextScreen.putExtra("progressBarCurrent",current);
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