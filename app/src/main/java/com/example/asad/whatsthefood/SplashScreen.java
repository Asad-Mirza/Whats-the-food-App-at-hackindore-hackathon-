package com.example.asad.whatsthefood;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        final Intent intent;


        SharedPreferences pref = getSharedPreferences("v", Context.MODE_MULTI_PROCESS);

        boolean isLoged = pref.getBoolean("is", false);
        if (isLoged) {
            boolean f = pref.getBoolean("f", false);
            if (f) intent = new Intent(SplashScreen.this, studentActivity.class);
            else
                //FirebaseDatabase.getInstance().getReference().keepSynced(true);


                intent = new Intent(this, AdminActivity.class);

        } else {
            intent = new Intent(SplashScreen.this, LoginActivity.class);
        }

        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity

                startActivity(intent);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
