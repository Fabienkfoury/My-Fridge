package com.example.fabien.fridgeandrecipies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FirstLauncher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_launcher);
    }

    public void CreateFridge(View v) {
        startActivity(new Intent(this, MainActivity.class));
    }
}
