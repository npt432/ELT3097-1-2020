package uet.vnu.quizlet.Main.HomeTab.DirectSet.Learn;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import java.util.ArrayList;
import java.util.Random;
import uet.vnu.quizlet.R;

public class LearnActivity extends AppCompatActivity {

  TextView question;
  TextView amountQuestion;
  TextView familiarCheck;
  TextView masteredCheck;
  TextView wrongAnswer;
  TextView rightAnswer;
  ImageButton undo;
  ImageButton menu;
  Button answer1;
  Button answer2;
  Button answer3;
  Button answer4;
  ProgressBar progressBar;
  int numOfFamiliarCheck = 0;
  int numOfMasterCheck = 0;
  int numOfQuestion = 50;
  int keyIndex;
  ArrayList<String> setOfData;
  ArrayList<String> setOfMeaning;

  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_learn);

    setOfData = new ArrayList<>();
    setOfMeaning = new ArrayList<>();

    mapping();
    loadData();
    setRandomQuestion();
    updateResult();

    answer1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (keyIndex == 0){
          rightAns();

        } else {
          int choosedIndex = 0;
          wrongAns(choosedIndex);
        }
      }
    });
    answer2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (keyIndex == 1){
          rightAns();
        } else {
          int choosedIndex = 1;
          wrongAns(choosedIndex);
        }
      }
    });
    answer3.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (keyIndex == 2){
          rightAns();
        } else {
          int choosedIndex = 2;
          wrongAns(choosedIndex);
        }
      }
    });
    answer4.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (keyIndex == 3){
          rightAns();
        } else {
          int choosedIndex = 3;
          wrongAns(choosedIndex);
        }
      }
    });

    undo.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        onBackPressed();
      }
    });
    menu.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Toast.makeText(LearnActivity.this,"Chức năng chưa hoàn thiện!",Toast.LENGTH_SHORT).show();
      }
    });

  }

  private void mapping(){
    question = (TextView) findViewById(R.id.questionTextView);
    amountQuestion = (TextView) findViewById(R.id.amoutQuestionTextView);
    familiarCheck = (TextView) findViewById(R.id.familiarTextView);
    masteredCheck = (TextView) findViewById(R.id.masteredTextView);
    undo  = (ImageButton) findViewById(R.id.undoImageButton);
    menu = (ImageButton) findViewById(R.id.tuneImageButton);
    answer1 = (Button) findViewById(R.id.answer1Button);
    answer2 = (Button) findViewById(R.id.answer2Button);
    answer3 = (Button) findViewById(R.id.answer3Button);
    answer4 = (Button) findViewById(R.id.answer4Button);
    progressBar = (ProgressBar) findViewById(R.id.progressBar);
  }

  private void loadData(){
    setOfData.add(getString(R.string.word_1));
    setOfData.add(getString(R.string.word_2));
    setOfData.add(getString(R.string.word_3));
    setOfData.add(getString(R.string.word_4));

    setOfMeaning.add(getString(R.string.meaning_word_1));
    setOfMeaning.add(getString(R.string.meaning_word_2));
    setOfMeaning.add(getString(R.string.meaning_word_3));
    setOfMeaning.add(getString(R.string.meaning_word_4));
  }

  private void setRandomQuestion(){
    Random random = new Random();
    keyIndex = random.nextInt(4);
    question.setText(setOfMeaning.get(keyIndex));
    answer1.setText(setOfData.get(0));
    answer2.setText(setOfData.get(1));
    answer3.setText(setOfData.get(2));
    answer4.setText(setOfData.get(3));
  }

  private void updateResult(){
    masteredCheck.setText(String.valueOf(numOfMasterCheck));
    familiarCheck.setText(String.valueOf(numOfFamiliarCheck));
    amountQuestion.setText(String.valueOf(numOfQuestion));
  }

  private void setINVISIBLE(){
    question.setVisibility(View.INVISIBLE);
    answer1.setVisibility(View.INVISIBLE);
    answer2.setVisibility(View.INVISIBLE);
    answer3.setVisibility(View.INVISIBLE);
    answer4.setVisibility(View.INVISIBLE);
  }

  private void setVISIBLE(){
    question.setVisibility(View.VISIBLE);
    answer1.setVisibility(View.VISIBLE);
    answer2.setVisibility(View.VISIBLE);
    answer3.setVisibility(View.VISIBLE);
    answer4.setVisibility(View.VISIBLE);
  }

  public void wrongAns(int choosedIndex){
    setINVISIBLE();

    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    LearnWrongAnswerFragment wrongFragment = new LearnWrongAnswerFragment();

    Bundle dataToShow = new Bundle();
    dataToShow.putStringArrayList("data", setOfData);
    dataToShow.putStringArrayList("meaning",setOfMeaning);
    dataToShow.putInt("keyIndex", keyIndex);
    dataToShow.putInt("choosedIndex", choosedIndex);
    wrongFragment.setArguments(dataToShow);

    fragmentTransaction.add(R.id.frameContent, wrongFragment);
    fragmentTransaction.commit();
  }

  private void rightAns(){
    setINVISIBLE();
    numOfFamiliarCheck++;
    numOfQuestion--;
    progressBar.setProgress(progressBar.getProgress() + 10);
    updateResult();

    androidx.fragment.app.FragmentManager fragmentManager = getSupportFragmentManager();
    androidx.fragment.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    final LearnRightAnswerFragment rightFragment = new LearnRightAnswerFragment();
    fragmentTransaction.add(R.id.frameContent,rightFragment,"right");
    fragmentTransaction.commit();

    new CountDownTimer(1000, 1000) {
      public void onFinish() {
        removeFragment(rightFragment);
        setVISIBLE();
      }

      public void onTick(long millisUntilFinished) {}
    }.start();
  }

  private void removeFragment(LearnRightAnswerFragment rightFragment){
    androidx.fragment.app.FragmentManager fragmentManager = getSupportFragmentManager();
    androidx.fragment.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    fragmentTransaction.remove(rightFragment);
    fragmentTransaction.commit();
  }

}