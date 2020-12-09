package uet.vnu.quizlet.Main.CreateTab;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import uet.vnu.quizlet.Main.CreateTab.CreateClass.CreateClassActivity;
import uet.vnu.quizlet.Main.CreateTab.CreateFolder.CreateFolderActivity;
import uet.vnu.quizlet.Main.CreateTab.CreateSet.CreateSetActivity;
import uet.vnu.quizlet.R;

public class CreateBottomSheet extends BottomSheetDialogFragment {
  private Button createSet;
  private Button createFolder;
  private Button createClass;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.dialog_tab_create, container, false);
    createSet = (Button) view.findViewById(R.id.createSet);
    createClass = (Button) view.findViewById(R.id.createClass);
    createFolder = (Button) view.findViewById(R.id.createFolder);

    createSet.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        goToAttract(v, CreateSetActivity.class);
      }
    });

    createFolder.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        goToAttract(v,  CreateFolderActivity.class);
      }
    });

    createClass.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        goToAttract(v, CreateClassActivity.class);
      }
    });

    return view;
  }

  public void goToAttract(View v, Class destination)
  {
    Intent intent = new Intent(getActivity(), destination);
    startActivity(intent);
    dismiss();
  }
}
