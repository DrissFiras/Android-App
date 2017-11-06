package com.example.yasmine.myapp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.facebook.login.widget.LoginButton;

public class LoginActivity extends AppCompatActivity {
private Button signup ;
    private Button login ;
    private LoginButton loginButton ;
    private CallbackManager callbackManager ;
    @InjectView(R.id.input_email)
    EditText _emailText;
    @InjectView(R.id.input_password)
    EditText _passwordText;
    @InjectView(R.id.btn_login)
    Button _loginButton;

    private FacebookCallback<LoginResult> callback = new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
        //GotoHomepage Save coordonnées
        }

        @Override
        public void onCancel() {
            //Rester dans LoginActivity

        }

        @Override
        public void onError(FacebookException error) {


        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText inputemail = (EditText) findViewById (R.id.input_email);
        String email = inputemail.getText().toString();
        EditText inputpassword = (EditText) findViewById (R.id.input_password);
        String password = inputpassword.getText().toString();
        signup=(Button) findViewById(R.id.btn_signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(s);

            }

        });
        login=(Button) findViewById(R.id.btn_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(getApplicationContext(), Home.class);
                startActivity(s);

            }});

        callbackManager= CallbackManager.Factory.create();
        loginButton= (LoginButton) findViewById(R.id.login_button);
        loginButton.registerCallback(callbackManager,callback);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }


}


