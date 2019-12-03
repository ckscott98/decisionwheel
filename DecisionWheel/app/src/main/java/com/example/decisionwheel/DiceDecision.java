package com.example.decisionwheel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

//https://www.youtube.com/watch?v=D-qfVHvNQ8M

public class DiceDecision extends AppCompatActivity {

    private SensorManager shake;
    private float accelVal, accelLast, accelDiff;
    private String[] diceOptions;
    private String decision;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_decision);

        Intent i = getIntent();
        diceOptions = i.getStringArrayExtra("diceOptions");
        random = new Random();
        decision = diceOptions[random.nextInt(diceOptions.length)];

        shake = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        shake.registerListener(sensorListener, shake.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);

        accelVal = SensorManager.GRAVITY_EARTH;
        accelLast = SensorManager.GRAVITY_EARTH;
        accelDiff = 0.00f;

    }

    private final SensorEventListener sensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];

            accelLast = accelVal;
            accelVal = (float) Math.sqrt((double) (x*x + y*y + z*z));
            accelDiff = accelDiff * 0.9f + (accelVal - accelLast);

            if(accelDiff > 12) {
                diceShook();
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        shake.registerListener(sensorListener, shake.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        shake.unregisterListener(sensorListener);
        super.onPause();

    }

    public void diceShook() {
        if(accelDiff > 12) {
            Toast toast = Toast.makeText(this, "phone shake registered", Toast.LENGTH_SHORT);
            toast.show();
            Intent intent = new Intent(getApplicationContext(),diceDecisionMade.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("diceDecision", decision);
            startActivity(intent);
        }
    }

}
