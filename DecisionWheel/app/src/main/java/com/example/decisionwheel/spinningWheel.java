package com.example.decisionwheel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import java.util.Random;

public class spinningWheel extends AppCompatActivity {
    private SensorManager shake;
    private float accelVal, accelLast, accelDiff;
    private String[] wheelOptions;
    private String decision;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinning_wheel);

        Intent i = getIntent();
        wheelOptions = i.getStringArrayExtra("wheelOptions");
        random = new Random();
        decision = wheelOptions[random.nextInt(wheelOptions.length)];

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

            if(accelDiff > 10) {
                spin();
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

    public void spin() {
        //Toast toast = Toast.makeText(this, "phone shake registered", Toast.LENGTH_SHORT);
        //toast.show();
        Intent intent = new Intent(getApplicationContext(),wheelDecisionMade.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("wheelDecision", decision);
        startActivity(intent);
    }

}
