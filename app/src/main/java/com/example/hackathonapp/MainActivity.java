package com.example.hackathonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "EmailPassword";

    private ProgressBar productivityProgress;
    private ProgressBar mentalProgress;
    private ProgressBar physicalProgress;

    private static int prgProductivity;
    private static int prgMentalWellness;
    private static int prgPhysicalWellness;

    private Button btnProductivity;
    private Button btnPhysicalWellness;
    private Button btnMentalWellness;


    //Button btnSignup;


    // [START declare_auth]
    //private FirebaseAuth mAuth;
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

       productivityProgress = (ProgressBar)findViewById(R.id.prgProductivityProgress);
        Intent mIntent = getIntent();
        prgProductivity = mIntent.getIntExtra("productivityPercent" , prgProductivity );
        productivityProgress.setProgress(prgProductivity);

        physicalProgress = (ProgressBar)findViewById(R.id.prgPhysicalProgress);
        Intent mIntent3 = getIntent();
        prgPhysicalWellness = mIntent3.getIntExtra("physicalWellnessPercent", prgPhysicalWellness);
        physicalProgress.setProgress(prgPhysicalWellness);

        mentalProgress = (ProgressBar)findViewById(R.id.prgMentalProgress);
        Intent mIntent2 = getIntent();
        prgMentalWellness = mIntent2.getIntExtra("mentalWellnessPercent", prgMentalWellness);
        mentalProgress.setProgress(prgMentalWellness);
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