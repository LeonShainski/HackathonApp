package com.example.hackathonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class AddTasks extends AppCompatActivity {

    private Button btnAddTaskSubmit;
    private RadioButton radioCategory1, radioCategory2, radioCategory3;
    private TextView txtTaskToAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tasks);

        btnAddTaskSubmit=findViewById(R.id.btnAddTaskSubmit);
        radioCategory1=findViewById(R.id.radioCategory1);
        radioCategory2=findViewById(R.id.radioCategory2);
        radioCategory3=findViewById(R.id.radioCategory3);
        txtTaskToAdd=findViewById(R.id.txtTaskToAdd);

        btnAddTaskSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_txtTaskToAdd = txtTaskToAdd.getText().toString();
                //String txt_txtAgeBoxUserReg = txtAgeBoxUserReg.getText().toString();

                if (txt_txtTaskToAdd.isEmpty()) {
                    Toast.makeText(AddTasks.this, "Looks like you're missing something...is the title filled out?", Toast.LENGTH_SHORT).show();
                } else {
                    String category;
                    if (radioCategory1.isChecked()) {
                        category = "Physical";
                    } else if (radioCategory2.isChecked()) {
                        category = "Mental";
                    } else  {
                        category = "Productivity";
                    }

                    //Declaring a new user and assigning it the proper parameters
                    Task task = new Task (txt_txtTaskToAdd, category);
                    //Getting the current user from firebase, and extracting their uid
                    FirebaseUser userInfo = FirebaseAuth.getInstance().getCurrentUser();
                    String uid = userInfo.getUid();
                    //Making a new entry under userInfo, with the id being the user's uid, and the entry being of type user.class
                    FirebaseDatabase.getInstance().getReference().child("tasks").child(uid).setValue(task);
                    startActivity(new Intent(AddTasks.this, MainActivity.class));
                    finish();
                }
            }
        });
    }
}