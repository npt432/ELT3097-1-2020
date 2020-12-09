package uet.vnu.quizlet.Main.AccountTab;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import uet.vnu.quizlet.Intro.IntroActivity;
import uet.vnu.quizlet.R;

public class AccountFragment extends Fragment {
  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_account,container,false);
    ImageView avatarImage = view.findViewById(R.id.avatarImageView);
    TextView username = view.findViewById(R.id.usernameTextView);
    Button signOutButton = view.findViewById(R.id.signOutButton);

    signOutButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        signOut();

      }
    });

    return view;
  }
  public void signOut() {
    AuthUI.getInstance()
        .signOut(getContext())
        .addOnCompleteListener(new OnCompleteListener<Void>() {
          @Override
          public void onComplete(@androidx.annotation.NonNull Task<Void> task) {
            startActivity(new Intent(getActivity(), IntroActivity.class));
            getActivity().finish();
          }
        });

  }

}
