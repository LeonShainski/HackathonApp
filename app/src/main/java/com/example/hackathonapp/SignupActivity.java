package com.example.hackathonapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        //Firebase initialization
        mAuth = FirebaseAuth.getInstance();

        //Setting the title text
        TextView txtTopTitle = (TextView) findViewById(R.id.txtTopTitle);
        txtTopTitle.setText("Sign Up Below to Use Our Services");
    }
}
