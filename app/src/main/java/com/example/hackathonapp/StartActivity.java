package com.example.hackathonapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {

    private Button register;
    private Button login;

    @Override
    protected void onCreate (Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        register = findViewById(R.id.btnRegisterStart);
        login = findViewById(R.id.btnLoginStart);

        register.setOnClickListener((v) -> {
            startActivity(new Intent(StartActivity.this, SignupActivity.class));
            finish();
        });

        login.setOnClickListener((v) -> {
            startActivity(new Intent(StartActivity.this, LoginActivity.class));
            finish();
        });
    }
}
