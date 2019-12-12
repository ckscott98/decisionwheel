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

public class coinDecision extends AppCompatActivity {

    private SensorManager flip;
    private float accelVal, accelLast, accelDiff;
    private String[] coinOptions;
    private String decision;
    private Random random;

}
