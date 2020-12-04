package uet.vnu.quizlet;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import java.text.SimpleDateFormat;

public class SignUpActivity extends AppCompatActivity {

  private EditText dateOfBirthEditText;
  private EditText emailEditText;
  private EditText usernameEditText;
  private EditText passwordEditText;
  private ImageButton backImageButton;
  private Button googleSignInButton;
  private Button facebookSignInButton;
  private LoginButton loginButton;
  private CallbackManager callbackManager;
  private FirebaseAuth auth;
  private GoogleSignInClient googleSignInClient;
  int RC_SIGN_IN = 007;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sign_up);

    backImageButton = (ImageButton) findViewById(R.id.backImageButton);

    googleSignInButton = (Button) findViewById(R.id.googleSignInButton);
    facebookSignInButton = (Button) findViewById(R.id.facebookLoginButton);
    loginButton = (LoginButton) findViewById(R.id.facebookLogin);

    dateOfBirthEditText = (EditText) findViewById(R.id.dateOfBirthEditText);
    emailEditText = (EditText) findViewById(R.id.emailEditText);
    usernameEditText = (EditText) findViewById(R.id.emailEditText);
    passwordEditText = (EditText) findViewById(R.id.passwordEditText);

    //configure back button
    backImageButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        onBackPressed();
      }
    });

    // Configure Google Sign In
    GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken(getString(R.string.default_web_client_id))
        .requestEmail()
        .build();
    googleSignInClient = GoogleSignIn.getClient(this, gso);

    //Get Firebase auth instance
    auth = FirebaseAuth.getInstance();

    // Configure Facebook Login
    FacebookSdk.sdkInitialize(SignUpActivity.this);
    callbackManager = CallbackManager.Factory.create();
    loginButton.setReadPermissions("email", "public_profile");
    loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
      @Override
      public void onSuccess(LoginResult loginResult) {
        Log.e("success","success");
        handleFacebookAccessToken(loginResult.getAccessToken());
      }

      @Override
      public void onCancel() {
        Log.e("cancel","cancel");
      }

      @Override
      public void onError(FacebookException error) {
        Log.e("error","error");
      }
    });

    googleSignInButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        signIn();
      }
    });

    facebookSignInButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        loginButton.performClick();
      }
    });

    dateOfBirthEditText.setOnClickListener(new OnClickListener() {
      @RequiresApi(api = VERSION_CODES.N)
      @Override
      public void onClick(View v) {
        pickDate();
      }
    });

    emailEditText.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {

      }
    });


  }

  //Google Sign In -> start sign in Intent
  private void signIn() {
    Intent signInIntent = googleSignInClient.getSignInIntent();
    startActivityForResult(signInIntent, RC_SIGN_IN);
  }

  //After done sign in Intent, return Result
  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    callbackManager.onActivityResult(requestCode,resultCode,data);
    // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
    if (requestCode == RC_SIGN_IN) {
      Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
      try {
        // Google Sign In was successful, authenticate with Firebase
        GoogleSignInAccount account = task.getResult(ApiException.class);
        Log.d("tag", "firebaseAuthWithGoogle:" + account.getId());
        firebaseAuthWithGoogle(account.getIdToken());
      } catch (ApiException e) {
        // Google Sign In failed, update UI appropriately
        Log.w("tag", "Google sign in failed", e);
      }
    }
  }

  // Handle Token
  private void firebaseAuthWithGoogle(String idToken) {
    AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
    auth.signInWithCredential(credential)
        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
          @Override
          public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()) {
              // Sign in success, update UI with the signed-in user's information
              Log.d("tag", "signInWithCredential:success");
              FirebaseUser user = auth.getCurrentUser();
              updateUI(user);
            } else {
              // If sign in fails, display a message to the user.
              Log.w("tag", "signInWithCredential:failure", task.getException());
              // Snackbar.make(mBinding.mainLayout, "Authentication Failed.", Snackbar.LENGTH_SHORT).show();
              updateUI(null);
            }
          }
        });
  }

  //Handle Token Facebook Login
  private void handleFacebookAccessToken(AccessToken token) {
    Log.d("fb", "handleFacebookAccessToken:" + token);

    AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
    auth.signInWithCredential(credential)
        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
          @Override
          public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()) {
              // Sign in success, update UI with the signed-in user's information
              Log.d("fb", "signInWithCredential:success");
              FirebaseUser user = auth.getCurrentUser();
              updateUI(user);
            } else {
              // If sign in fails, display a message to the user.
              Log.w("fb", "signInWithCredential:failure", task.getException());
              updateUI(null);
            }
          }
        });
  }

  //Update User Interface
  private void updateUI(FirebaseUser account) {
    Log.e("acc", "account: "+ account);
    if (account == null) {
      startActivity(new Intent(SignUpActivity.this, SignUpActivity.class));
      finish();
    } else {
      Log.e("info","name "+account.getDisplayName()+", Uid "+account.getUid()+", ProviderID "+account.getProviderId()+", email "+account.getEmail()+", photo URL "+account.getPhotoUrl());
      Log.e("info",account.getDisplayName());
      Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
      intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
      startActivity(intent);
      SignUpActivity.this.finish();
    }
  }

  //Function used to pick date from calendar popup
  @RequiresApi(api = VERSION_CODES.N)
  private void pickDate(){
    final Calendar calendar = Calendar.getInstance();
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH);
    int day = calendar.get(Calendar.DAY_OF_MONTH);

    DatePickerDialog datePickerDialog = new DatePickerDialog(SignUpActivity.this, new OnDateSetListener() {
      @Override
      public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        calendar.set(year, month, dayOfMonth);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd yyyy");
        dateOfBirthEditText.setText(simpleDateFormat.format(calendar.getTime()));
      }
    }, year, month, day);
    datePickerDialog.show();
  }

}