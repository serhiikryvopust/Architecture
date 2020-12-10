package com.samaaps.architecture;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActiviti extends AppCompatActivity {

    public static final int DELAY_IN_MILLIS = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_activiti);

        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashActiviti.this, MainActivity.class));
            finish();
        }, DELAY_IN_MILLIS);
    }
}