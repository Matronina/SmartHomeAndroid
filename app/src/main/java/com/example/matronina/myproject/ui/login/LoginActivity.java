package com.example.matronina.myproject.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.matronina.myproject.R;
import com.example.matronina.myproject.ui.alerts.AlertsActivity;

public class LoginActivity extends AppCompatActivity {

    // Hardcoded valid user name and password:
    private static final String USER_NAME = "admin";
    private static final String PASSWORD = "admin";

    private EditText mUserText;
    private EditText mPasswordText;
    private Button mSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUserText = findViewById(R.id.userNameEditText);
        mPasswordText = findViewById(R.id.passwordEditText);
        mSubmitButton = findViewById(R.id.submitButton);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = mUserText.getText().toString();
                String pass = mPasswordText.getText().toString();
                if (USER_NAME.equals(user) &&
                        PASSWORD.equals(pass)) {
                    // Proceed to alerts activity
                    Intent intent = new Intent(getApplicationContext(), AlertsActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(),
                            R.string.invalid_login, Toast.LENGTH_SHORT).show();
                    mUserText.setText("");
                    mPasswordText.setText("");
                }
            }
        });
    }
}
