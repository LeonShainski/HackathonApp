package com.example.hackathonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MentalWellness extends AppCompatActivity {

    private int mentalPercent;

    private Button finishedBoxMW;
    private CheckBox checkbox1MW;
    private CheckBox checkbox2MW;
    private CheckBox checkbox3MW;
    private CheckBox checkbox4MW;

    public static final String SHARED_PREFS_MW = "SharedPrefs_MW";
    public static final String CHECK1_MW = "Checkbox1_MW";
    public static final String CHECK2_MW = "Checkbox2_MW";
    public static final String CHECK3_MW = "Checkbox3_MW";
    public static final String CHECK4_MW = "Checkbox4_MW";

    private Boolean check1_MW;
    private Boolean check2_MW;
    private Boolean check3_MW;
    private Boolean check4_MW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental_wellness);

        finishedBoxMW = (Button) findViewById(R.id.btnMentalFinished);
        checkbox1MW = (CheckBox) findViewById(R.id.chkMental1);
        checkbox2MW = (CheckBox) findViewById(R.id.chkMental2);
        checkbox3MW = (CheckBox) findViewById(R.id.chkMental3);
        checkbox4MW = (CheckBox) findViewById(R.id.chkMental4);

        finishedBoxMW.setOnClickListener(new View.OnClickListener() {
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
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_MW, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean(CHECK1_MW, checkbox1MW.isChecked());
        editor.putBoolean(CHECK2_MW, checkbox2MW.isChecked());
        editor.putBoolean(CHECK3_MW, checkbox3MW.isChecked());
        editor.putBoolean(CHECK4_MW, checkbox4MW.isChecked());

        editor.apply();

        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
    }

    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_MW, MODE_PRIVATE);
        check1_MW = sharedPreferences.getBoolean(CHECK1_MW, false);
        check2_MW = sharedPreferences.getBoolean(CHECK2_MW, false);
        check3_MW = sharedPreferences.getBoolean(CHECK3_MW, false);
        check4_MW = sharedPreferences.getBoolean(CHECK4_MW, false);
    }

    public void updateViews(){
        checkbox1MW.setChecked(check1_MW);
        checkbox2MW.setChecked(check2_MW);
        checkbox3MW.setChecked(check3_MW);
        checkbox4MW.setChecked(check4_MW);
    }

    public int loadPercentage(){
        mentalPercent = 0;
        if (checkbox1MW.isChecked()){
            mentalPercent++;
        }
        if (checkbox2MW.isChecked()){
            mentalPercent++;
        }
        if (checkbox3MW.isChecked()){
            mentalPercent++;
        }
        if (checkbox4MW.isChecked()){
            mentalPercent++;
        }
        mentalPercent = mentalPercent * 25;
        return mentalPercent;
    }

    public void goToMain(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("mentalWellnessPercent", mentalPercent);
        startActivity(intent);
    }

}