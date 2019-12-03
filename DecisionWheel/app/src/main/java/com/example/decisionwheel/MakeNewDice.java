package com.example.decisionwheel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MakeNewDice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_new_dice);
    }

    public void cancelDice(View view) {
        //Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        //startActivity(intent);
        finish();
    }

    public void rollDice(View view) {
        EditText text1 = findViewById(R.id.option1);
        EditText text2 = findViewById(R.id.option2);
        EditText text3 = findViewById(R.id.option3);
        EditText text4 = findViewById(R.id.option4);
        EditText text5 = findViewById(R.id.option5);
        EditText text6 = findViewById(R.id.option6);

        String[] s = {text1.getText().toString(), text2.getText().toString(), text3.getText().toString(),
                text4.getText().toString(), text5.getText().toString(), text6.getText().toString()};

        Intent intent = new Intent(getApplicationContext(),DiceDecision.class);
        intent.putExtra("diceOptions", s);
        startActivity(intent);
    }
}
