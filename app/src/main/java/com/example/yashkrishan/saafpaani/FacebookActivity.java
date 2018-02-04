package com.example.yashkrishan.saafpaani;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.firebase.auth.FirebaseAuth;

public class FacebookActivity extends AppCompatActivity {
    CallbackManager mCallBackManager;
    LoginButton loginButton;
    TextView textView;
    private boolean isAccountStarted = false;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);
        final Button button = findViewById(R.id.next);
        button.setVisibility(View.INVISIBLE);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent account = new Intent(FacebookActivity.this, Account.class);
                startActivity(account);
            }
        });
        mAuth = FirebaseAuth.getInstance();
        mCallBackManager = CallbackManager.Factory.create();
        textView = (TextView) findViewById(R.id.textView);
        textView.setVisibility(View.INVISIBLE);
        final LoginButton loginButton = findViewById(R.id.login_button);
        loginButton.setReadPermissions("email", "public_profile");
        loginButton.registerCallback(mCallBackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                button.setVisibility(View.VISIBLE);
                loginButton.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCancel() {
                textView.setVisibility(View.VISIBLE);
                textView.setText("Login Failed..Try Again!!");
            }

            @Override
            public void onError(FacebookException error) {
                textView.setVisibility(View.VISIBLE);
                textView.setText("Error..Retry!!");
            }
        });
    }
// ...

        @Override
        protected void onActivityResult ( int requestCode, int resultCode, Intent data){
            mCallBackManager.onActivityResult(requestCode, resultCode, data);
            super.onActivityResult(requestCode, resultCode, data);

        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

        @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent ko = new Intent(FacebookActivity.this, ContaminationAllert.class);
                startActivity(ko);
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.action_favorite:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                Intent ki = new Intent(FacebookActivity.this, Details1.class);
                startActivity(ki);
                return true;

            case R.id.profile:
                Intent kela = new Intent(FacebookActivity.this, AccountDetails.class);
                startActivity(kela);

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    // Initialize Facebook Login button

}
