package fr.livero.livero;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;

import java.util.Arrays;

/**
 * Created by Rohit on 4/28/2018.
 */

public class Login extends AppCompatActivity{
    static final int PICK_CONTACT_REQUEST = 1;
    TextView signup; //Sign up Text View
    CallbackManager callbackManager;//required for Facebook Login
    ImageButton fblogin,googlesignInButton;
    private static final String EMAIL = "email";
    GoogleSignInClient mGoogleSignInClient;


    private void initializeControls()
    {
        callbackManager = CallbackManager.Factory.create();
        fblogin = (ImageButton) findViewById(R.id.fblogin_button);

        //fblogin.setReadPermissions(Arrays.asList(EMAIL));
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.login);
        initializeControls();
        loginwithFB();
        loginwithGoogle();


        signup=(TextView) findViewById(R.id.signupbutton);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent int1= new Intent(Login.this,Signup.class);
                startActivity(int1);
            }
        });
    }

    private void loginwithFB()
    {
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(Login.this,
                        "Login Successful !", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancel() {
                Toast.makeText(Login.this,
                        "Login Failed !", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(FacebookException error) {

            }
        });
    }
private void loginwithGoogle()
{
    GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail().build();
    mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

    // Check for existing Google Sign In account, if the user is already signed in
    // the GoogleSignInAccount will be non-null.
    GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
    //updateUI(account); //if account is not null the user has already logged in with google. if null its the first time.
    googlesignInButton = findViewById(R.id.googlesign_in_button);


    // Google Sign up.
    googlesignInButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent signInIntent = mGoogleSignInClient.getSignInIntent();
            startActivityForResult(signInIntent, PICK_CONTACT_REQUEST);
        }
    });
}

}
