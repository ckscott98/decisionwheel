package com.example.decisionwheel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
        Toast toastWheel = Toast.makeText(this, "Option not available yet!", Toast.LENGTH_SHORT);
        toastWheel.show();
    }

    public void createNewCoin(View view) {
        Toast toastCoin = Toast.makeText(this, "Option not available yet!", Toast.LENGTH_SHORT);
        toastCoin.show();
    }
}
