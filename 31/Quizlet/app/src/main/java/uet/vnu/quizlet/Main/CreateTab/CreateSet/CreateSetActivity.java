package uet.vnu.quizlet.Main.CreateTab.CreateSet;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;
import uet.vnu.quizlet.ClassData.Data;
import uet.vnu.quizlet.ClassData.DataOfSet;
import uet.vnu.quizlet.R;
import uet.vnu.quizlet.Main.HomeTab.SetSelectedActivity;

public class CreateSetActivity extends AppCompatActivity {

  private ListView listView;
  private FloatingActionButton floatingActionButton;
  private ArrayList<Data> dataList;
  private CreateSetAdapter createSetAdapter;
  private ImageButton backImageButton;
  private ImageButton settingImageButton;
  private ImageButton createSetImageButton;
  private EditText createSetTitleEditText;
  private TextView scanTextView;
  private TextView descriptionTextView;
  private DatabaseReference mFirebaseDatabase;
  private FirebaseDatabase mFirebaseInstance;
  private FirebaseAuth auth;
  private String dataId;
  private RecyclerView recyclerView;
  private RecyclerView.Adapter adapter;
  private RecyclerView.LayoutManager layoutManager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_create_set);

    auth = FirebaseAuth.getInstance();  //Get instance of FirebaseAuth (a version of Firebase)
    mFirebaseInstance = FirebaseDatabase.getInstance();

    // get reference to 'users' node
    mFirebaseDatabase = mFirebaseInstance.getReference("dataOfSet");  //select "dataOfSet"

    // store app title to 'app_title' node
    recyclerView = (RecyclerView) findViewById(R.id.createSetInputRecycleView);
    backImageButton = (ImageButton) findViewById(R.id.backImageButton);
    settingImageButton = (ImageButton) findViewById(R.id.settingImageButton);
    createSetImageButton = (ImageButton) findViewById(R.id.createSetImageButton);
    createSetTitleEditText = (EditText) findViewById(R.id.createSetTitle);
    scanTextView = (TextView) findViewById(R.id.scanTextView);
    descriptionTextView = (TextView) findViewById(R.id.descriptionTextView);

    floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingButton);


    //Khởi tạo data list
    dataList = new ArrayList<Data>();
    firstLaunch();

    // Khởi tạo Adapter
    layoutManager = new LinearLayoutManager(this);
    adapter = new CreateSetAdapter(dataList);
    adapter.setHasStableIds(true);
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setAdapter(adapter);

    floatingActionButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        addNewBox();
        adapter.notifyItemInserted(dataList.size());
      }
    });

    backImageButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        onBackPressed();
      }
    });

    settingImageButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        startActivity(new Intent(CreateSetActivity.this, SetOptionActivity.class));
      }
    });

    createSetImageButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        createUser();
      }
    });

  }

  private void firstLaunch(){
    addNewBox();
    addNewBox();
  }

  private void addNewBox() {
    Data data = new Data();
    data.setData("","");
    Log.e("tag",data.getWord()+" "+data.getMeaning() );
    dataList.add(dataList.size(),data);
  }

  //create user firebase
  private void createUser() {
    if (TextUtils.isEmpty(dataId)) {
      dataId = mFirebaseDatabase.push().getKey(); //get key to push data into firebase
    }
    DataOfSet dataOfSet = new DataOfSet(createSetTitleEditText.getText().toString().trim(), dataList,
        auth.getCurrentUser().getUid(), dataId);
    // auth.getCurrentUser().getUid() to get UID (User ID) of current user sign in Firebase Auth
    mFirebaseDatabase.child(dataId).setValue(dataOfSet);  //set data to child dataID
    updateUI();
  }

  // update User Interface
  private void updateUI(){
    Intent intent = new Intent(CreateSetActivity.this, SetSelectedActivity.class);
    intent.putExtra("dataID",dataId);
    startActivity(intent);
    finish();
  }

}