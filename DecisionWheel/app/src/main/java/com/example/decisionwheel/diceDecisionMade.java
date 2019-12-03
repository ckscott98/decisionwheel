package com.example.decisionwheel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class diceDecisionMade extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_decision_made);

        Intent i = getIntent();
        String decision = i.getStringExtra("diceDecision");

        TextView txt = findViewById(R.id.diceResultText);
        txt.setText(decision);
    }

    public void goHome(View view) {
        startActivity(new Intent(getApplicationContext(),MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }
}
