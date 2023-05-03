package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private SharedPreferences myPreferenceRef;
    private SharedPreferences.Editor myPreferenceEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        myPreferenceRef = getSharedPreferences("preferences", MODE_PRIVATE);
        myPreferenceEditor = myPreferenceRef.edit();

        final TextView editText = findViewById(R.id.editText);
        Button saveButton = findViewById(R.id.saveButton);
        editText.setText(myPreferenceRef.getString("MyPersistentData", ""));

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myPreferenceEditor.putString("MyPersistentData", editText.getText().toString());
                myPreferenceEditor.apply();
                finish();
            }
        });
    }
}