package uet.vnu.quizlet.Main;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener;
import com.google.android.material.tabs.TabLayout.Tab;
import uet.vnu.quizlet.Main.AccountTab.AccountFragment;
import uet.vnu.quizlet.Main.CreateTab.CreateBottomSheet;
import uet.vnu.quizlet.Main.HomeTab.HomeFragment;
import uet.vnu.quizlet.R;
import uet.vnu.quizlet.Main.SearchTab.SearchFragment;

public class MainActivity extends AppCompatActivity {
  private TabLayout tabLayout;
  private int previousPosition;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    tabLayout = (TabLayout) findViewById(R.id.tabLayout);
    previousPosition = tabLayout.getSelectedTabPosition();
    addFragment(tabLayout.getSelectedTabPosition());
    tabLayout.addOnTabSelectedListener(new OnTabSelectedListener() {
      @Override
      public void onTabSelected(Tab tab) {
        int position = tab.getPosition();
        if(position != 2){
          Log.e("pre1",""+previousPosition);
          previousPosition = position;
          Log.e("pre2",""+previousPosition);
          addFragment(position);
        }
        else{
          tabLayout.getTabAt(previousPosition).select();
          Log.e("pre3",""+previousPosition);
          toggleBottomSheet();
        }

      }

      @Override
      public void onTabUnselected(Tab tab) {

      }

      @Override
      public void onTabReselected(Tab tab) {

      }
    });


  }

  private void toggleBottomSheet() {
    CreateBottomSheet createBottomSheet = new CreateBottomSheet();
    createBottomSheet.show(getSupportFragmentManager(),"tag");
  }

  public void addFragment(int position){
    Log.e("pos",""+position);
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    Fragment fragment = null;
    switch (position){
      case 0:
        Log.e("tag","0");
        fragment = new HomeFragment();
        break;
      case 1:
        Log.e("tag","1");
        fragment = new SearchFragment();
        break;
      case 3:
        Log.e("tag","3");
        fragment = new AccountFragment();
        break;
      default:
        Log.e("tag","df");
        break;
    }
    fragmentTransaction.add(R.id.frameLayout,fragment).commit();
  }
}