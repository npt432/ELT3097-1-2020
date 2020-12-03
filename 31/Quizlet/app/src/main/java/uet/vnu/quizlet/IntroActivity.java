package uet.vnu.quizlet;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.firebase.auth.FirebaseAuth;

public class IntroActivity extends AppCompatActivity {
  private ViewPager viewPager;
  private int[] introsLayout; //array of Intro layout
  private PagerAdapter pagerAdapter;
  private Button signUpButton;
  private Button signInButton;
  private FirebaseAuth auth;

  //Dot Image
  private ImageView dot1ImageView;
  private ImageView dot2ImageView;
  private ImageView dot3ImageView;
  private ImageView dot4ImageView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_intro);

    dot1ImageView = (ImageView) findViewById(R.id.dot1);
    dot2ImageView = (ImageView) findViewById(R.id.dot2);
    dot3ImageView = (ImageView) findViewById(R.id.dot3);
    dot4ImageView = (ImageView) findViewById(R.id.dot4);

    viewPager = (ViewPager) findViewById(R.id.viewPager);
    introsLayout = new int[] {R.layout.intro1, R.layout.intro2, R.layout.intro3, R.layout.intro4};

    signInButton = (Button) findViewById(R.id.signInButton);
    signUpButton = (Button) findViewById(R.id.signUpButton);

    //configure Firebase Auth
    auth = FirebaseAuth.getInstance();

    //If signed
    if (auth.getCurrentUser() != null) {
      startActivity(new Intent(IntroActivity.this, MainActivity.class));
      finish();
    }

    changeStatusBarColor(); //set status bar color
    changeBottomDots(0);  //set dot

    pagerAdapter = new IntroViewPagerAdapter();
    viewPager.setAdapter(pagerAdapter);
    viewPager.addOnPageChangeListener(viewPagerChangeListener);
    signUpButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        launchSignUpScreen();
      }
    });
    signInButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        launchSignInScreen();
      }
    });
  }


  private ViewPager.OnPageChangeListener viewPagerChangeListener = new ViewPager.OnPageChangeListener() {
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
      changeBottomDots(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
  };

  private void changeBottomDots(int currentPage) {
    switch (currentPage) {
      case 0:
        dot1ImageView.setImageResource(R.drawable.dot_selected);
        dot2ImageView.setImageResource(R.drawable.dot);
        dot3ImageView.setImageResource(R.drawable.dot);
        dot4ImageView.setImageResource(R.drawable.dot);
        Log.e("tag","0");
        break;

      case 1:
        dot1ImageView.setImageResource(R.drawable.dot);
        dot2ImageView.setImageResource(R.drawable.dot_selected);
        dot3ImageView.setImageResource(R.drawable.dot);
        dot4ImageView.setImageResource(R.drawable.dot);
        break;

      case 2:
        dot1ImageView.setImageResource(R.drawable.dot);
        dot2ImageView.setImageResource(R.drawable.dot);
        dot3ImageView.setImageResource(R.drawable.dot_selected);
        dot4ImageView.setImageResource(R.drawable.dot);
        break;

      case 3:
        dot1ImageView.setImageResource(R.drawable.dot);
        dot2ImageView.setImageResource(R.drawable.dot);
        dot3ImageView.setImageResource(R.drawable.dot);
        dot4ImageView.setImageResource(R.drawable.dot_selected);
        break;

      default:
        break;
    }
  }

  @SuppressLint("Range")
  private void changeStatusBarColor() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      Window window = getWindow();
      window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
      window.setStatusBarColor(Color.parseColor("#FF6200EE"));
    }
  }

  private void launchSignInScreen() {
    Intent intent = new Intent(IntroActivity.this, SignInActivity.class);
    startActivity(intent);
  }

  private void launchSignUpScreen() {
    Intent intent = new Intent(IntroActivity.this, SignUpActivity.class);
    startActivity(intent);
  }

  public class IntroViewPagerAdapter extends PagerAdapter {
    private LayoutInflater mInflater;

    public IntroViewPagerAdapter() {
      super();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
      mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      View view = mInflater.inflate(introsLayout[position], container, false);
      container.addView(view);
      return view;
    }

    @Override
    public int getCount() {
      return introsLayout.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
      return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
      View view = (View) object;
      container.removeView(view);
    }
  }

}