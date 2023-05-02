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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreference preference = new SharedPreference();

        myPreferenceRef = preference.getMyPreferenceRef();
        myPreferenceRef = getPreferences(MODE_PRIVATE);
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

    protected void onResume(Bundle savedInstanceState) {
        updatePreferenceText();
    }

    private void updatePreferenceText() {
        TextView preferenceView = findViewById(R.id.preferenceText);
        preferenceView.setText(myPreferenceRef.getString("MyPersistentData", "No preference found."));
        System.out.println("persistent data: " + myPreferenceRef.getString("MyPersistentData", "No preference found."));
    }

    protected SharedPreferences getMyPreferenceRef() {
        return this.myPreferenceRef;
    }
}