package com.example.hackathonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class UserInfoRegistration extends AppCompatActivity {

    private Button btnSubmitUserInfo;
    private EditText txtNameBoxUserReg, txtAgeBoxUserReg;
    private CheckBox chkStudent, chkEmployee, chkNeither;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_registration);

        btnSubmitUserInfo = findViewById(R.id.btnSubmitUserInfo);
        txtNameBoxUserReg = findViewById(R.id.txtNameBoxUserReg);
        txtAgeBoxUserReg = findViewById(R.id.txtAgeBoxUserReg);
        chkStudent = findViewById(R.id.chkStudent);
        chkEmployee = findViewById(R.id.chkEmployee);
        chkNeither = findViewById(R.id.chkNeither);



        btnSubmitUserInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_txtNameBoxUserReg = txtNameBoxUserReg.getText().toString();
                String txt_txtAgeBoxUserReg = txtAgeBoxUserReg.getText().toString();

                if (txt_txtNameBoxUserReg.isEmpty() || txt_txtAgeBoxUserReg.isEmpty() || (!chkStudent.isChecked() && !chkEmployee.isChecked() && !chkNeither.isChecked())) {
                    Toast.makeText(UserInfoRegistration.this, "Looks like you're missing something...is everything filled out?", Toast.LENGTH_SHORT).show();
                } else {
                    String occupation;
                    if (chkStudent.isChecked()) {
                        occupation = "Student";
                    } else if (chkEmployee.isChecked()) {
                        occupation = "Employee";
                    } else  {
                        occupation = "Nothing";
                    }
                    /*HashMap<String, Object> map = new HashMap<>();
                    map.put("Name", txt_txtNameBoxUserReg);
                    map.put("Age", txt_txtAgeBoxUserReg);
                    map.put("Occupation", occupation);*/
                    String tempChild="testing";
                    User user = new User (txt_txtNameBoxUserReg, txt_txtAgeBoxUserReg, occupation);
                    FirebaseDatabase.getInstance().getReference().child("Info").push().setValue(user);
                    startActivity(new Intent(UserInfoRegistration.this, MainActivity.class));
                    finish();
                }
            }
        });
    }


}