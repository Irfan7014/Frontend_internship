package com.example.frontend_internship;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {
    private Button bSignUp;
    private EditText eEmail,eUsername,ePassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Sign Up");
        bSignUp = (Button)findViewById(R.id.btnSignUp);
        eEmail = (EditText)findViewById(R.id.etEmail);
        eUsername = (EditText)findViewById(R.id.etUsername);
        ePassword = (EditText)findViewById(R.id.etPassword2);
        bSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = eEmail.getText().toString().trim();
                String username = eUsername.getText().toString().trim();
                String password = ePassword.getText().toString().trim();
                if (username.isEmpty()) {
                    eUsername.setError("Enter Full Name");
                    return;
                }
                if (email.isEmpty()) {
                    eEmail.setError("Enter Email");
                    return;
                }
                if (password.isEmpty()) {
                    ePassword.setError("Enter Password");
                    return;
                }

                if (!isValidEmail(email)) {
                    eEmail.setError("Enter Valid Email Address");
                    return;
                }
                if(!isValidPassword(password)){
                    ePassword.setError("-The Password must be of 8 to 20 characters in length\n-must contain one digit, one uppercase character and one lowercase character\n-must contain one special character {!@#$%&*()-+=^}");
                    return;
                }
            }
        });
    }
    private boolean isValidEmail(CharSequence email) {
        if (!TextUtils.isEmpty(email)) {
            return Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
        return false;
    }
    public boolean isValidPassword(String password)
    {

        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the password is empty
        // return false
        if (password == null) {
            return false;
        }

        // Pattern class contains matcher() method
        // to find matching between given password
        // and regular expression.
        Matcher m = p.matcher(password);

        // Return if the password
        // matched the ReGex
        return m.matches();
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent1 = new Intent(getApplicationContext(), HomePage.class);
                startActivity(intent1);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}