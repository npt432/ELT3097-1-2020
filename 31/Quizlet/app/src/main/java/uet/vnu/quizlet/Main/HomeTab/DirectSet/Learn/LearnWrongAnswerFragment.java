package uet.vnu.quizlet.Main.HomeTab.DirectSet.Learn;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import uet.vnu.quizlet.R;

public class LearnWrongAnswerFragment extends Fragment {

  TextView correctAnswerText;
  TextView choosedAnswerText;
  TextView questionText;
  Button continueButton;
  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_learn_wrong_answer,container,false);
    correctAnswerText = (TextView) view.findViewById(R.id.correctAnswerTextView);
    choosedAnswerText = (TextView) view.findViewById(R.id.choosedAnswerTextView);
    questionText = (TextView) view.findViewById(R.id.questionTextView);
    continueButton = (Button) view.findViewById(R.id.continueButton);
    Bundle dataToShow = getArguments();
    ArrayList<String> setOfData = dataToShow.getStringArrayList("data");
    ArrayList<String> setOfMeaning = dataToShow.getStringArrayList("meaning");
    int keyIndex = dataToShow.getInt("keyIndex");
    int choosedIndex = dataToShow.getInt("choosedIndex");

    correctAnswerText.setText(setOfData.get(keyIndex));
    choosedAnswerText.setText(setOfData.get(choosedIndex));
    questionText.setText(setOfMeaning.get(keyIndex));

    continueButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
      }
    });

    return view;
  }

}
