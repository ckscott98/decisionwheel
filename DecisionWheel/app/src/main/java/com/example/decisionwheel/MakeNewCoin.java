package com.example.decisionwheel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MakeNewCoin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_coin);
    }

    public void cancelCoin(View view) {
        finish();
    }

    public void flipCoin(View view) {
        EditText text1 = findViewById(R.id.coinHead);
        EditText text2 = findViewById(R.id.coinTail);

        String[] s = {text1.getText().toString(), text2.getText().toString()};

        Intent intent = new Intent(getApplicationContext(),coinDecision.class);
        intent.putExtra("coinOptions", s);
        startActivity(intent);

    }

}
