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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "EmailPassword";

    private Button btnProductivity;
    private Button btnPhysicalWellness;
    private Button btnMentalWellness;
    private EditText name;
    private Button add;
    //Button btnSignup;


    // [START declare_auth]
    //private FirebaseAuth mAuth;
    // [END declare_auth]



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.txtEnterNameBox);
        add = findViewById(R.id.btnAddName);

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






    //FirebaseDatabase.getInstance().getReference().child("ProgrammingKnowledge").child("Android").setValue("abcd");

        
}