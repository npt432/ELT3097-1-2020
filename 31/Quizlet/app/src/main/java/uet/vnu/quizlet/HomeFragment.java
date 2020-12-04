package uet.vnu.quizlet;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_home, container, false);
    TextView set = (TextView) view.findViewById(R.id.set);
    set.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        goToAttract(v,  SetSelectedActivity.class);
      }
    });
    return view;
  }

  public void goToAttract(View v, Class destination)
  {
    Intent intent = new Intent(getActivity(), destination);
    startActivity(intent);
  }
}
