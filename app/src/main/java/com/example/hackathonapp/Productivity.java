package com.example.hackathonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Productivity extends AppCompatActivity {

    private int productivityPercent;

    private Button finishedBox;
    private CheckBox checkbox1;
    private CheckBox checkbox2;
    private CheckBox checkbox3;
    private CheckBox checkbox4;

    public static final String SHARED_PREFS = "SharedPrefs";
    public static final String CHECK1 = "Checkbox1";
    public static final String CHECK2 = "Checkbox2";
    public static final String CHECK3 = "Checkbox3";
    public static final String CHECK4 = "Checkbox4";

    private Boolean check1;
    private Boolean check2;
    private Boolean check3;
    private Boolean check4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productivity);

        finishedBox = (Button) findViewById(R.id.btnProductivityFinished);
        checkbox1 = (CheckBox) findViewById(R.id.chkProductivity1);
        checkbox2 = (CheckBox) findViewById(R.id.chkProductivity2);
        checkbox3 = (CheckBox) findViewById(R.id.chkProductivity3);
        checkbox4 = (CheckBox) findViewById(R.id.chkProductivity4);

        finishedBox.setOnClickListener(new View.OnClickListener() {
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
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean(CHECK1, checkbox1.isChecked());
        editor.putBoolean(CHECK2, checkbox2.isChecked());
        editor.putBoolean(CHECK3, checkbox3.isChecked());
        editor.putBoolean(CHECK4, checkbox4.isChecked());

        editor.apply();

        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
    }

    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        check1 = sharedPreferences.getBoolean(CHECK1, false);
        check2 = sharedPreferences.getBoolean(CHECK2, false);
        check3 = sharedPreferences.getBoolean(CHECK3, false);
        check4 = sharedPreferences.getBoolean(CHECK4, false);
    }

    public void updateViews(){
        checkbox1.setChecked(check1);
        checkbox2.setChecked(check2);
        checkbox3.setChecked(check3);
        checkbox4.setChecked(check4);
    }

    public int loadPercentage(){
        productivityPercent = 0;
        if (checkbox1.isChecked()){
            productivityPercent++;
        }
        if (checkbox2.isChecked()){
            productivityPercent++;
        }
        if (checkbox3.isChecked()){
            productivityPercent++;
        }
        if (checkbox4.isChecked()){
            productivityPercent++;
        }
        productivityPercent = productivityPercent * 25;
        return productivityPercent;
    }

    public void goToMain(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("productivityPercent", productivityPercent);
        startActivity(intent);
    }

}