package com.example.hackathonapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "EmailPassword";

    private Button btnProductivity;
    private Button btnPhysicalWellness;
    private Button btnMentalWellness;
    //Button btnSignup;


    // [START declare_auth]
    private FirebaseAuth mAuth;
    // [END declare_auth]



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnProductivity = (Button) findViewById(R.id.btnProductivity);
        btnProductivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProductivity();
            }
        });

        btnPhysicalWellness = (Button) findViewById(R.id.btnPhysicalWellness);
        btnPhysicalWellness.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openPhysicalWellness();
            }
        });

        btnMentalWellness = (Button) findViewById(R.id.btnMentalWellness);
        btnMentalWellness.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openMentalWellness();
            }
        });


    }

    public void openProductivity(){
        Intent intent = new Intent(this, Productivity.class);
        startActivity(intent);
    }

    public void openPhysicalWellness(){
        Intent intent = new Intent(this, PhysicalWellness.class);
        startActivity(intent);
    }


    public void openMentalWellness(){
        Intent intent = new Intent(this, MentalWellness.class);
        startActivity(intent);
    }

        
}