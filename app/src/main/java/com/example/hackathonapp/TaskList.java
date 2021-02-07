package com.example.hackathonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TaskList extends AppCompatActivity {

    private String itemNameFinal ="";
    private CheckBox checkbox5PW;
    private TextView textbox5PW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        checkbox5PW = (CheckBox) findViewById(R.id.chkPhysical5);
        textbox5PW = findViewById(R.id.txtPhysicalBox5);

        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference scoreRef = rootRef.child("tasks");
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<String> list = new ArrayList<>();
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    String name = ds.child("name").getValue(String.class);
                    String category = ds.child("Category").getValue(String.class);
                    list.add(name + "/" +  category);
                    Log.d("TAG", name + " | " +  category);
                }
                ListView listView = (ListView) findViewById(R.id.list_view);
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(TaskList.this, android.R.layout.simple_list_item_1, list);
                listView.setAdapter(arrayAdapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //Toast.makeText(TaskList.this, "I will Buy: " + arrayAdapter.getItem(position), Toast.LENGTH_SHORT).show();
                        String itemName = arrayAdapter.getItem(position);
                        String finalName = sanitizeName(itemName);
                        String finalCategory = sanitizeCategory(itemName);
                        Toast.makeText(TaskList.this, finalName + " has been added to the " + finalCategory + " task list!", Toast.LENGTH_SHORT).show();
                        //Toast.makeText(this, finalName, Toast.LENGTH_SHORT).show();
                        //setVisibilityPhysical(finalName);
                        if (finalCategory.toString().equals("Physical")) {
                            setVisibilityPhysical(finalName);
                        }
                        if (finalCategory.toString().equals("Mental")) {
                            setVisibilityMental(finalName);
                        }
                        if (finalCategory.toString().equals("Productivity")) {
                            setVisibilityProductivity(finalName);
                        }



                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        };



        scoreRef.addListenerForSingleValueEvent(eventListener);
    }

    private void setVisibilityProductivity(String finalName) {
        Intent intent = new Intent(getBaseContext(), Productivity.class);
        intent.putExtra("finalName", finalName);
        startActivity(intent);
    }

    private void setVisibilityMental(String finalName) {
        Intent intent = new Intent(getBaseContext(), MentalWellness.class);
        intent.putExtra("finalName", finalName);
        startActivity(intent);
    }

    private void setVisibilityPhysical(String finalName) {
        Intent intent = new Intent(getBaseContext(), PhysicalWellness.class);
        intent.putExtra("finalName", finalName);
        startActivity(intent);
        //PhysicalWellness.chkPhysical5.setVisibility(View.VISIBLE);
        //textbox5PW.setVisibility(View.VISIBLE);
        //checkbox5PW.setText("Some text");
    }

    private String sanitizeCategory(String itemName) {
        String category = itemName.substring(itemName.indexOf("/")+1, itemName.length());
        return category;
    }

    private String sanitizeName(String itemName) {
        //String category = itemName.substring(itemName.indexOf("/"), -1);
        itemName = itemName.substring(0, itemName.indexOf("/"));
        return itemName;
    }
}