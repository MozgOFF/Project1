package com.example.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//import static com.example.project1.Login.ARG_NAME;

public class Registration extends AppCompatActivity implements View.OnClickListener {

    private EditText mLoginField;
    private EditText mPasswordField;

    private TextView mAlreadyRegistered;
    private Button mRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getSupportActionBar().hide();

        initUI();
    }

    private void initUI() {
        mAlreadyRegistered = findViewById(R.id.haveAccount);
        mAlreadyRegistered.setOnClickListener(this);

        mRegister = findViewById(R.id.registrationButton);
        mRegister.setOnClickListener(this);

        mLoginField = findViewById(R.id.registrationLogin);
        mPasswordField = findViewById(R.id.registrationPassword);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this, Login.class);

        switch (v.getId()) {
            case (R.id.registrationButton):
                PreferencesWrapper.saveLogin(this, mLoginField.getText().toString());
                PreferencesWrapper.savePassword(this, mPasswordField.getText().toString());
                startActivity(intent);

                break;
            case (R.id.haveAccount):
                startActivity(intent);
                break;
        }

    }
}
