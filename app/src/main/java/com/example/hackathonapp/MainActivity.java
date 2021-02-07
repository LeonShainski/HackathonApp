package com.example.hackathonapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "EmailPassword";

    private ProgressBar productivityProgress;
    private ProgressBar mentalProgress;
    private ProgressBar physicalProgress;

    private ProgressBar personalLevel;
    private int prgPersonLevel;


    private static int prgProductivity;
    private static int prgMentalWellness;
    private static int prgPhysicalWellness;

    private Button btnProductivity;
    private Button btnPhysicalWellness;
    private Button btnMentalWellness;
    private Button btnEnterTesting;
    private Button btnAddTasksMain;
    private TextView txtUserName;
    private String userName;

    private EditText name;
    private Button add;
    private FirebaseAuth mAuth;
    DatabaseReference databaseUsers;


    //Button btnSignup;


    // [START declare_auth]
    //private FirebaseAuth mAuth;
    // [END declare_auth]

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //name = findViewById(R.id.txtEnterNameBox);
        //add = findViewById(R.id.btnAddName);

        FirebaseUser userInfo = FirebaseAuth.getInstance().getCurrentUser();
        String uid = userInfo.getUid();

        //userName = "Good to see you again";

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseUsers = database.getReference("userInfo");
        DatabaseReference username = databaseUsers.child(uid).child("name");

        username.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //Getting the name based on the uid
                userName = dataSnapshot.getValue().toString();
                //Setting the name of the user in the main activity for a personal greeting
                txtUserName.setText(userName);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        /*ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                User post = dataSnapshot.getValue(User.class);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        };*/



        txtUserName = findViewById(R.id.txtUserName);


        btnProductivity = (Button) findViewById(R.id.btnProductivity);

        btnProductivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProductivity();
            }
        });

        btnAddTasksMain = findViewById(R.id.btnAddTasksMain);

        btnAddTasksMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddTasks.class));
            }
        });

        //btnEnterTesting = findViewById(R.id.btnEnterTesting);
        /*btnEnterTesting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TestingActivity.class));
            }
        });*/



        btnPhysicalWellness = (Button) findViewById(R.id.btnPhysicalWellness);
        btnPhysicalWellness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPhysicalWellness();
            }
        });

        btnMentalWellness = (Button) findViewById(R.id.btnMentalWellness);
        btnMentalWellness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMentalWellness();
            }
        });


        //FirebaseDatabase database = FirebaseDatabase.getInstance();
        //DatabaseReference myRef = database.getReference("User");
        //myRef.child("bruv").setValue("Hello, World!");

        /*add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_name = name.getText().toString();
                if (txt_name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "No name entered!", Toast.LENGTH_SHORT).show();
                } else {
                    FirebaseDatabase.getInstance().getReference().child("userInfo").push().child("Name").setValue(txt_name);
                }
            }
        });

        HashMap<String, Object> map = new HashMap<>();
        map.put("Name", "Alex");
        map.put("Email", "hotdogs4life@gmail.com");

        FirebaseDatabase.getInstance().getReference().child("userInfo").child("MultipleValues").updateChildren(map);*/


        productivityProgress = (ProgressBar) findViewById(R.id.prgProductivityProgress);
        Intent mIntent = getIntent();
        prgProductivity = mIntent.getIntExtra("productivityPercent", prgProductivity);
        productivityProgress.setProgress(prgProductivity);

        physicalProgress = (ProgressBar) findViewById(R.id.prgPhysicalProgress);
        Intent mIntent3 = getIntent();
        prgPhysicalWellness = mIntent3.getIntExtra("physicalWellnessPercent", prgPhysicalWellness);
        physicalProgress.setProgress(prgPhysicalWellness);

        mentalProgress = (ProgressBar) findViewById(R.id.prgMentalProgress);
        Intent mIntent2 = getIntent();
        prgMentalWellness = mIntent2.getIntExtra("mentalWellnessPercent", prgMentalWellness);
        mentalProgress.setProgress(prgMentalWellness);

        personalLevel = (ProgressBar) findViewById(R.id.personLevel);
        prgPersonLevel = (prgPhysicalWellness + prgMentalWellness + prgProductivity) / 3;
        personalLevel.setProgress(prgPersonLevel);



    }

    public void openProductivity() {
        Intent intent = new Intent(this, Productivity.class);
        startActivity(intent);
    }

    public void openPhysicalWellness() {
        Intent intent = new Intent(this, PhysicalWellness.class);
        startActivity(intent);
    }


    public void openMentalWellness() {
        Intent intent = new Intent(this, MentalWellness.class);
        startActivity(intent);
    }


}   //FirebaseDatabase.getInstance().getReference().child("ProgrammingKnowledge").child("Android").setValue("abcd");


