package com.example.decisionwheel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class wheelOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheel_options);
    }
    public void cancelWheel(View view){
        finish();
    }
    public void spinWheel(View view){
        EditText t1 = findViewById(R.id.option1);
        EditText t2 = findViewById(R.id.option2);
        EditText t3 = findViewById(R.id.option3);
        EditText t4 = findViewById(R.id.option4);
        EditText t5 = findViewById(R.id.option5);
        EditText t6 = findViewById(R.id.option6);
        EditText t7 = findViewById(R.id.option7);
        EditText t8 = findViewById(R.id.option8);

        String[] a = {t1.getText().toString(), t2.getText().toString(), t3.getText().toString(),t4.getText().toString(),
                t5.getText().toString(),t6.getText().toString(),t7.getText().toString(), t8.getText().toString() };

        Intent intent = new Intent(getApplicationContext(), spinningWheel.class);

        intent.putExtra("wheelOptions",a );

        startActivity(intent);
    }
}
