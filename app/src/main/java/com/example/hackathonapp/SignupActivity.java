package com.example.hackathonapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    private Button btnRegister;
    private EditText email;
    private EditText password;
    private FirebaseAuth mAuth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        //Firebase initialization
        mAuth = FirebaseAuth.getInstance();

        //Setting the title text
        TextView txtTopTitle = (TextView) findViewById(R.id.txtTopTitle);
        txtTopTitle.setText("Sign Up Below to Use Our Services");

        email=findViewById(R.id.txtEmailBox);
        password=findViewById(R.id.txtPasswordBox);
        btnRegister=findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                String txt_email = email.getText().toString();
                String txt_password = password.getText().toString();

                if (TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)) {
                    Toast.makeText(SignupActivity.this, "Please fill out both boxes", Toast.LENGTH_SHORT).show();
                } else if (txt_password.length()<8) {
                    Toast.makeText(SignupActivity.this, "Password too short, please enter at least 8 characters", Toast.LENGTH_SHORT).show();
                } else {
                    registerUser(txt_email, txt_password);
                }
            }
        });

    }

    private void registerUser(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    Toast.makeText(SignupActivity.this, "Success! You're in!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SignupActivity.this, "Registration failed. You're account may already exist! Try logging in :)", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
