package com.batista.kleyton.starwarsapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setStatusBarTranslucent(true);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                // Esse método será executado sempre que o timer acabar
                // e inicia a activity principal
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);

                startActivity(intent);

                // Fecha esta activity
                finish();

            }
        }, SPLASH_TIME_OUT);
    }

    private void setStatusBarTranslucent(boolean makeTranslucent) {

        if (makeTranslucent) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        } else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);


        }
    }
}
