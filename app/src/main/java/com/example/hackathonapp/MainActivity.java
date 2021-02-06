package com.example.hackathonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnProductivity;
    private Button btnPhysicalWellness;
    private Button btnMentalWellness;
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