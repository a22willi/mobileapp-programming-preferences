package com.example.project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences myPreferenceRef;
    private SharedPreferences.Editor myPreferenceEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myPreferenceRef = getSharedPreferences("preferences", MODE_PRIVATE);
        myPreferenceEditor = myPreferenceRef.edit();
        updatePreferenceText();

        Button editData = findViewById(R.id.editData);
        editData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }


    @Override
    public void onResume(){
        super.onResume();
        updatePreferenceText();
    }

    private void updatePreferenceText() {
        TextView preferenceView = findViewById(R.id.preferenceText);
        preferenceView.setText(myPreferenceRef.getString("MyPersistentData", "No preference found."));
        myPreferenceEditor.apply();
        System.out.println("persistent data: " + myPreferenceRef.getString("MyPersistentData", "No preference found."));
    }
}