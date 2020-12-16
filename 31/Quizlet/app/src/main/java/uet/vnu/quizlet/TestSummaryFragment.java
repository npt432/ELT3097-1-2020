package uet.vnu.quizlet;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.firebase.database.DatabaseReference;

public class TestSummaryFragment extends Fragment {
    private String dataID;
    private String uid;
    private DatabaseReference databaseReference;
    private DataOfSet dataOfSet;

    //khởi tạo constructor
    public TestSummaryFragment() {
    }

    //nhận dữ liệu để khởi tạo 1 fragment
    public static TestSummaryFragment newInstance(DataOfSet mdata) {
        TestSummaryFragment fragment = new TestSummaryFragment();
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
        final View rootView = inflater.inflate(R.layout.item_test_summary, container, false);

        //ánh xạ các thành phần trong layout fragment
        dataOfSet = (DataOfSet) getArguments().getSerializable("data");

        TextView question = (TextView) rootView.findViewById(R.id.questionTextView);
        TextView answer = (TextView) rootView.findViewById(R.id.answer);
        ImageView correctIcon = (ImageView) rootView.findViewById(R.id.correctIcon);
        ImageView wrongIcon = (ImageView) rootView.findViewById(R.id.wrongIcon);
        TextView label = (TextView) rootView.findViewById(R.id.label);

        return rootView;
    }
}


