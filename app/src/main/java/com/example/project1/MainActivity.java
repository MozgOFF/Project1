package com.example.project1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener {

    private TextView mGreetingMsg;
    private Button mLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initUI();
    }

    private void initUI() {
        mGreetingMsg = findViewById(R.id.greetingMsg);

        mLogout = findViewById(R.id.logout);
        String login = PreferencesWrapper.getLogin(this);
        String password = PreferencesWrapper.getPassword(this);

        mLogout.setOnClickListener(this);
        mGreetingMsg.setText(getString(R.string.greeting, login, password));
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, Login.class);

        switch (v.getId()) {
            case (R.id.logout):
                PreferencesWrapper.logout(this);
                startActivity(intent);
                break;
        }

    }
}
