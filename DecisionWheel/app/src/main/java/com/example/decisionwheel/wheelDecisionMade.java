package com.example.decisionwheel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class wheelDecisionMade extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheel_decision_made);

        Intent i = getIntent();
        String decision = i.getStringExtra("wheelDecision");

        TextView txt = findViewById(R.id.wheelResultText);
        txt.setText(decision);
    }

    public void goHome(View view) {
        startActivity(new Intent(getApplicationContext(),MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }
}
