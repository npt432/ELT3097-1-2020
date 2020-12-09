package uet.vnu.quizlet.Main.HomeTab;

import android.content.Intent;
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
import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import uet.vnu.quizlet.ClassData.DataOfSet;
import uet.vnu.quizlet.R;

public class SetInfoFragment extends Fragment {
  private String dataID;
  private String uid;
  private DatabaseReference databaseReference;
  private DataOfSet dataOfSet;

    //khởi tạo constructor
    public SetInfoFragment() {
    }

    //nhận dữ liệu để khởi tạo 1 fragment
    public static SetInfoFragment newInstance(DataOfSet mdataOfSet) {
      SetInfoFragment fragment = new SetInfoFragment(); //khởi tạo SetInfoFragment
      Bundle args = new Bundle(); //khởi tạo bundle
      args.putSerializable("data", mdataOfSet); // truyền class vào bundle
      fragment.setArguments(args);  //set Arguments cho fragment
      return fragment;  //trả về fragment
    }

    @Override
    //khởi tạo fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
      //ánh xạ với layout fragment cần tạo
      final View rootView = inflater.inflate(R.layout.item_set_info, container, false);

      //ánh xạ các thành phần trong layout fragment
      LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.linearLayout);
      dataOfSet = (DataOfSet) getArguments().getSerializable("data");
      linearLayout.setBackgroundColor(getResources().getColor(R.color.colorWhite));
      linearLayout.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
          Intent intent = new Intent(getActivity(), SetSelectedActivity.class);
          intent.putExtra("data",dataOfSet.getDataID());
          Log.e("tag", "onClick: "+dataOfSet.getTitle());
          startActivity(intent);
        }
      });
      TextView title = (TextView) rootView.findViewById(R.id.titleTextView);
      TextView numOfTerms = (TextView) rootView.findViewById(R.id.numOfTermTextView);
      ImageView avatar = (ImageView) rootView.findViewById(R.id.avatarImageView);
      TextView userName = (TextView) rootView.findViewById(R.id.userNameTextView);

      title.setText(dataOfSet.getTitle());
      numOfTerms.setText(dataOfSet.getDataList().size()+ " " +getString(R.string.num_of_terms));
      Glide.with(this).load(getResources().getString(R.string.default_avatar_uri)).into(avatar);
      return rootView;
    }

}
