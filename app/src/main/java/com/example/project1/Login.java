package com.example.project1;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import jp.wasabeef.blurry.Blurry;

public class Login extends AppCompatActivity implements View.OnClickListener {

//    public static final String ARG_NAME = "login";

    private ImageView mImageView;

    private TextView mTextView;

    private Button mLoginButton;

    private EditText mLoginEdit;
    private EditText mPasswordEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        initUI();
    }

    private void initUI() {
        String login = PreferencesWrapper.getLogin(this);
        String password = PreferencesWrapper.getPassword(this);

        mLoginEdit = findViewById(R.id.login);
        mPasswordEdit = findViewById(R.id.password);

        mTextView = findViewById(R.id.notRegistered);
        mTextView.setOnClickListener(this);

        mLoginButton = findViewById(R.id.loginButton);
        mLoginButton.setOnClickListener(this);


        mImageView = findViewById(R.id.background);
//        Blurry.with(Login.this)
//                .radius(10)
//                .sampling(1)
//                .color(Color.argb(66, 255, 255, 0))
//                .async()
//                .animate(500)
//                .capture(findViewById(R.id.background))
//                .into((ImageView) findViewById(R.id.background));

        if (login != null && password != null) {
            mLoginEdit.setText(login);
            mPasswordEdit.setText(password);
        }
    }

    @Override
    public void onClick(View v) {
        String loginEdit = mLoginEdit.getText().toString();
        String passwordEdit = mPasswordEdit.getText().toString();

        Intent intent = new Intent(this, Registration.class);
        Intent intent2 = new Intent(this, MainActivity.class);

        switch (v.getId()) {
            case (R.id.loginButton):
                if (loginEdit.equals(PreferencesWrapper.getLogin(this))
                    && passwordEdit.equals(PreferencesWrapper.getPassword(this))
                        && PreferencesWrapper.getLogin(this) != null
                            && PreferencesWrapper.getPassword(this) != null) {
                    startActivity(intent2);
                }
                    mLoginEdit.setText("");
                    mPasswordEdit.setText("");

                    mLoginEdit.setHint("Your data is wrong");
                    mPasswordEdit.setHint("Try again!");
                break;

            case (R.id.notRegistered):
//                    intent.putExtra(ARG_NAME, loginEdit);
                startActivity(intent);
                break;
        }
    }
}