package com.example.hackathonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class AddTasks extends AppCompatActivity {

    private Button btnAddTaskSubmit;
    private RadioButton radioCategory1, radioCategory2, radioCategory3;
    private TextView txtTaskToAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tasks);


    }
}