package com.example.hackathonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PhysicalWellness extends AppCompatActivity {

    private int physicalPercent;

    private Button finishedBoxPW;
    private CheckBox checkbox1PW;
    private CheckBox checkbox2PW;
    private CheckBox checkbox3PW;
    private CheckBox checkbox4PW;
    private CheckBox checkbox5PW;
    private TextView textbox5PW;

    public static final String SHARED_PREFS_PW = "SharedPrefs_PW";
    public static final String CHECK1_PW = "Checkbox1_PW";
    public static final String CHECK2_PW = "Checkbox2_PW";
    public static final String CHECK3_PW = "Checkbox3_PW";
    public static final String CHECK4_PW = "Checkbox4_PW";
    public static final String CHECK5_PW = "Checkbox4_PW";

    private Boolean check1_PW;
    private Boolean check2_PW;
    private Boolean check3_PW;
    private Boolean check4_PW;
    private Boolean check5_PW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physical_wellness);

        finishedBoxPW = (Button) findViewById(R.id.btnPhysicalFinished);
        checkbox1PW = (CheckBox) findViewById(R.id.chkPhysical1);
        checkbox2PW = (CheckBox) findViewById(R.id.chkPhysical2);
        checkbox3PW = (CheckBox) findViewById(R.id.chkPhysical3);
        checkbox4PW = (CheckBox) findViewById(R.id.chkPhysical4);
        checkbox5PW = (CheckBox) findViewById(R.id.chkPhysical5);
        textbox5PW = findViewById(R.id.txtPhysicalBox5);

        checkbox5PW.setVisibility(View.GONE);
        //checkbox5PW.setText("Some text");
        textbox5PW.setVisibility(View.GONE);

        finishedBoxPW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
                loadPercentage();
                goToMain();
            }
        });
        loadData();
        updateViews();


    }


    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_PW, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean(CHECK1_PW, checkbox1PW.isChecked());
        editor.putBoolean(CHECK2_PW, checkbox2PW.isChecked());
        editor.putBoolean(CHECK3_PW, checkbox3PW.isChecked());
        editor.putBoolean(CHECK4_PW, checkbox4PW.isChecked());
        editor.putBoolean(CHECK5_PW, checkbox4PW.isChecked());

        editor.apply();

        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
    }

    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_PW, MODE_PRIVATE);
        check1_PW = sharedPreferences.getBoolean(CHECK1_PW, false);
        check2_PW = sharedPreferences.getBoolean(CHECK2_PW, false);
        check3_PW = sharedPreferences.getBoolean(CHECK3_PW, false);
        check4_PW = sharedPreferences.getBoolean(CHECK4_PW, false);
        check5_PW = sharedPreferences.getBoolean(CHECK5_PW, false);
    }

    public void updateViews(){
        checkbox1PW.setChecked(check1_PW);
        checkbox2PW.setChecked(check2_PW);
        checkbox3PW.setChecked(check3_PW);
        checkbox4PW.setChecked(check4_PW);
        checkbox4PW.setChecked(check5_PW);
    }

    public int loadPercentage(){
        physicalPercent = 0;
        if (checkbox1PW.isChecked()){
            physicalPercent++;
        }
        if (checkbox2PW.isChecked()){
            physicalPercent++;
        }
        if (checkbox3PW.isChecked()){
            physicalPercent++;
        }
        if (checkbox4PW.isChecked()){
            physicalPercent++;
        } if (checkbox5PW.isChecked()){
            physicalPercent++;
        }
        physicalPercent = physicalPercent * 25;
        return physicalPercent;
    }

    public void goToMain(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("physicalWellnessPercent", physicalPercent);
        startActivity(intent);
    }

    public void addNew (String name) {
        checkbox5PW.setVisibility(View.VISIBLE);
        checkbox5PW.setText("Some text");
        textbox5PW.setVisibility(View.VISIBLE);
    }
}