package uet.vnu.quizlet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class TestActivity_summary extends AppCompatActivity {

    private DatabaseReference databaseReference;
    private ViewPager viewPager;
    private View view;
    private ArrayList<DataOfSet> dataOfSetArrayList;
    private TestSummaryFragment testSummaryFragment;
    private TestSummaryAdapter testSummaryAdapter;
    ImageButton Ibutton_back;
    Button button_retake;


    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle saveInstanceState){
        view = inflater.inflate(R.layout.activity_test_summary, container, false);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        getData();

        viewPager = (ViewPager) view.findViewById(R.id.viewPager);

        Ibutton_back = (ImageButton)findViewById(R.id.imageButtonBack);
        Ibutton_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backScreen = new Intent(TestActivity_summary.this, SetSelectedActivity.class);
                startActivity(backScreen);
            }
        });

        button_retake = (Button)findViewById(R.id.buttonAnswer1);
        button_retake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(TestActivity_summary.this, TestActivity.class);
                startActivity(nextScreen);
            }
        });
    }
    }

    public void getData(){
        //khai báo gốc của firebase
        final DatabaseReference root = FirebaseDatabase.getInstance().getReference();
        // .child để truy cập nhánh con
        // .addChildEventListener để duyệt tất cả dữ liệu trong nhánh child đang trỏ đến
        root.child("dataOfSet").addChildEventListener(new ChildEventListener() {
            @Override
            //Khi có một nhánh con trong child mà ta đang xét, firebase trả về 1 data snapshot
            public void onChildAdded(@androidx.annotation.NonNull DataSnapshot snapshot,
                                     @Nullable String previousChildName) {
                // từ data snapshot có thể đổ dữ liệu ra
                DataOfSet dataOfSet = snapshot.getValue(DataOfSet.class); //tạo 1 biến kiểu DataOfSet để lưu giá trị đổ về tự firebase...
                //....getValue("ép kiểu dữ liệu");
                dataOfSetArrayList.add(dataOfSet);  //thêm dữ liệu nhánh con đọc được vào List dataOfSet để sử dụng

                //Vì hàm đổ dữ liệu của firebase không được luồng chính chờ đến lúc hoàn thành mà sẽ được chạy song song với các lệnh khác
                // nên phải kiểm tra điều kiện, khi nào đọc đủ dữ liệu mới thực hiện các lệnh xử lí dữ liệu và giao diện
                if (dataOfSetArrayList.size() > snapshot.getChildrenCount()){   // snapshot.getChildrenCount trả về chỉ số của nhánh con cuối cùng
                    InitView(); //nếu đọc đủ thực hiện khởi tạo các view
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot,
                                       @Nullable String previousChildName) {
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    private void InitView() {
        testSummaryAdapter = new TestSummaryAdapter(getSupportFragmentManager()); //Khỏi tạo adapter. Nếu dùng activity thì...
        //... thay getChildFragmentManager() thành getSupportFragmentManager()
        //testSummaryAdapter.DataInput(databaseReference); //Truyền List dataOfSet để tạo các view theo dữ liệu dataOfSet đổ vào

        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        //Custom viewpager (cách lề, thò thụt view bên phải sang view bên trái,...) bình thường không cần
        viewPager.setPadding(50, 0, 50, 0);
        viewPager.setClipToPadding(false);
        viewPager.setPageMargin(25);
        //set adapter với setInfoAdapter đã khởi tạo bên trên
        viewPager.setAdapter(testSummaryAdapter);
    }
}
