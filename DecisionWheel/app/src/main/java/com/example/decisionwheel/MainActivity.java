package com.example.decisionwheel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createNewDice(View view) {
        Intent intent = new Intent(getApplicationContext(),MakeNewDice.class);
        startActivity(intent);
    }

    public void createNewWheel(View view) {
        Intent intent = new Intent(getApplicationContext(),wheelOptions.class);
        startActivity(intent);
    }

    public void createNewCoin(View view) {
        Intent intent = new Intent(getApplicationContext(), MakeNewCoin.class);
        startActivity(intent);
    }
}
