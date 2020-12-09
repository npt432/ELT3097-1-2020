package uet.vnu.quizlet.Main.HomeTab;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.google.firebase.database.DatabaseReference;
import uet.vnu.quizlet.ClassData.Data;
import uet.vnu.quizlet.R;

public class SetCardFragment extends Fragment {
    private String dataID;
    private String uid;
    private DatabaseReference databaseReference;
    private Data data;

    //khởi tạo constructor
  public SetCardFragment() {
    }

    //nhận dữ liệu để khởi tạo 1 fragment
    public static SetCardFragment newInstance(Data mdata) {
      SetCardFragment fragment = new SetCardFragment();
      Bundle args = new Bundle(); //khởi tạo bundle
      args.putSerializable("data", mdata); // truyền class vào bundle
      fragment.setArguments(args);  //set Arguments cho fragment
      return fragment;  //trả về fragment
    }

    @Override
    //khởi tạo fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    //ánh xạ với layout fragment cần tạo
    final View rootView = inflater.inflate(R.layout.item_set_selected_pager, container, false);

    //ánh xạ các thành phần trong layout fragment
    LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.linearLayout);
    data = (Data) getArguments().getSerializable("data");
    linearLayout.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Log.e("click", data.getMeaning());
      }
    });
    TextView word = (TextView) rootView.findViewById(R.id.word);
    ImageView fullScreen = (ImageView) rootView.findViewById(R.id.fullScreen);
    TextView userName = (TextView) rootView.findViewById(R.id.userNameTextView);

    word.setText(data.getWord());
    return rootView;
  }
}
