package uet.vnu.quizlet.Main.HomeTab;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;
import java.util.List;
import uet.vnu.quizlet.ClassData.DataOfSet;
import uet.vnu.quizlet.Main.HomeTab.DirectSet.Learn.LearnActivity;
import uet.vnu.quizlet.Main.HomeTab.DirectSet.Test.TestActivity;
import uet.vnu.quizlet.Main.HomeTab.DirectSet.Write.WriteActivity;
import uet.vnu.quizlet.R;

public class SetSelectedActivity extends AppCompatActivity {

  private DataOfSet dataOfSet;
  private RecyclerView recyclerView;
  private RecyclerView.Adapter adapter;
  private RecyclerView.LayoutManager layoutManager;
  private List<Object> objectList;
  private String dataID;
  private SetCardFragment setCardFragment;
  private SetCardViewPagerAdapter setCardViewPagerAdapter;
  private ViewPager viewPager;

  Button learnButton;
  Button flashCardButton;
  Button writeButton;
  Button matchButton;
  Button testButton;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_set_selected);
    Intent intent = getIntent();
    dataID = intent.getStringExtra("data");

    Log.e("tag", "onCreate: "+ dataID);
    objectList = new ArrayList<>();

    learnButton = (Button) findViewById(R.id.learnButton);
    flashCardButton = (Button) findViewById(R.id.flashCardButton);
    writeButton = (Button) findViewById(R.id.writeButton);
    matchButton = (Button) findViewById(R.id.matchButton);
    testButton = (Button) findViewById(R.id.testButton);

    learnButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent learnActivity = new Intent(SetSelectedActivity.this, LearnActivity.class);
        startActivity(learnActivity);
      }
    });
    writeButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent writeActivity = new Intent(SetSelectedActivity.this, WriteActivity.class);
        startActivity(writeActivity);
      }
    });

    testButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent testActivity = new Intent(SetSelectedActivity.this, TestActivity.class);
        startActivity(testActivity);
      }
    });

    getData();

  }

  public void initView(DataOfSet mdataOfSet){
    setCardViewPagerAdapter= new SetCardViewPagerAdapter(getSupportFragmentManager()); //Khỏi tạo adapter. Nếu dùng activity thì...
    //... thay getChildFragmentManager() thành getSupportFragmentManager()
    setCardViewPagerAdapter.DataInput(mdataOfSet); //Truyền List dataOfSet để tạo các view theo dữ liệu dataOfSet đổ vào

    viewPager = (ViewPager) findViewById(R.id.viewPager);
    //Custom viewpager (cách lề, thò thụt view bên phải sang view bên trái,...) bình thường không cần
    viewPager.setPadding(50, 0, 50, 0);
    viewPager.setClipToPadding(false);
    viewPager.setPageMargin(25);
    //set adapter với setInfoAdapter đã khởi tạo bên trên
    viewPager.setAdapter(setCardViewPagerAdapter);
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
        if (dataID.equals(dataOfSet.getDataID())){
          initView(dataOfSet);
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
}