package uet.vnu.quizlet.Intro;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
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
import uet.vnu.quizlet.Main.MainActivity;
import uet.vnu.quizlet.R;

public class SignInActivity extends AppCompatActivity {

  private EditText emailEditText;
  private EditText passwordEditText;
  private ImageButton backImageButton;
  private Button googleSignInButton;
  private Button facebookSignInButton;
  private LoginButton loginButton;
  private Button signInButton;
  private TextView forgotPasswordTextView;
  private ProgressBar progressBar;
  private CallbackManager callbackManager;
  private FirebaseAuth auth;
  private GoogleSignInClient googleSignInClient;
  int RC_SIGN_IN = 007;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sign_in);

    backImageButton = (ImageButton) findViewById(R.id.backImageButton);

    googleSignInButton = (Button) findViewById(R.id.googleSignInButton);
    facebookSignInButton = (Button) findViewById(R.id.facebookLoginButton);
    loginButton = (LoginButton) findViewById(R.id.facebookLogin);

    emailEditText = (EditText) findViewById(R.id.emailEditText);
    passwordEditText = (EditText) findViewById(R.id.passwordEditText);
    signInButton = (Button) findViewById(R.id.loginButton);
    forgotPasswordTextView = (TextView) findViewById(R.id.forgotPassword);
    progressBar = (ProgressBar) findViewById(R.id.progressBar);

    //configure back button
    backImageButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        onBackPressed();
      }
    });


    signInButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String email = emailEditText.getText().toString();
        final String password = passwordEditText.getText().toString();

        if (TextUtils.isEmpty(email)) {
          Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
          return;
        }

        if (TextUtils.isEmpty(password)) {
          Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
          return;
        }

        progressBar.setVisibility(View.VISIBLE);

        //authenticate user
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(SignInActivity.this, new OnCompleteListener<AuthResult>() {
              @Override
              public void onComplete(@NonNull Task<AuthResult> task) {
                // If sign in fails, display a message to the user. If sign in succeeds
                // the auth state listener will be notified and logic to handle the
                // signed in user can be handled in the listener.
                progressBar.setVisibility(View.GONE);
                if (!task.isSuccessful()) {
                  // there was an error
                  if (password.length() < 6) {
                    passwordEditText.setError(getString(R.string.minimum_password));
                  } else {
                    Toast.makeText(SignInActivity.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
                  }
                } else {
                  Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                  startActivity(intent);
                  finish();
                }
              }
            });
      }
    });

    forgotPasswordTextView.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        dialogForgot();
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
    FacebookSdk.sdkInitialize(SignInActivity.this);
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
      startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
      finish();
    } else {
      Log.e("info","name "+account.getDisplayName()+", Uid "+account.getUid()+", ProviderID "+account.getProviderId()+", email "+account.getEmail()+", photo URL "+account.getPhotoUrl());
      Log.e("info",account.getDisplayName());
      android.content.Intent intent = new Intent(SignInActivity.this, MainActivity.class);
      intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
      startActivity(intent);
      SignInActivity.this.finish();
    }
  }

  private void dialogForgot(){
    final Dialog dialog = new Dialog(this);
    dialog.setContentView(R.layout.dialog_forgot_password);
    final EditText emailForgot = (EditText) dialog.findViewById(R.id.emailForgotEditText);
    TextView cancel = (TextView) dialog.findViewById(R.id.cancelTextView);
    TextView ok = (TextView) dialog.findViewById(R.id.okTextView);

    ok.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        String email = emailForgot.getText().toString().trim();

        auth.sendPasswordResetEmail(email)
            .addOnCompleteListener(new OnCompleteListener<Void>() {
              @Override
              public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                  Toast.makeText(SignInActivity.this, "We have sent you instructions to reset your password!", Toast.LENGTH_SHORT).show();
                } else {
                  Toast.makeText(SignInActivity.this, "Failed to send reset email!", Toast.LENGTH_SHORT).show();
                }
              }
            });
      }
    });

    cancel.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        dialog.dismiss();
      }
    });

    dialog.show();
  }
}