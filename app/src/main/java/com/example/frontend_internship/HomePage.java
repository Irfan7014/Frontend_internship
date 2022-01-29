package com.example.frontend_internship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {
    private Button bSignUpEmail,bSignUpGoogle;
    private TextView tLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        bSignUpEmail=(Button)findViewById(R.id.btnSignUpEmail);
        bSignUpGoogle=(Button)findViewById(R.id.btnSignUpGoogle);
        tLogin=(TextView)findViewById(R.id.tvLogin);
        tLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), LoginPage.class);
                startActivity(intent1);
                finish();
            }
        });
        bSignUpEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), SignUp.class);
                startActivity(intent1);
                finish();
            }
        });
    }
}