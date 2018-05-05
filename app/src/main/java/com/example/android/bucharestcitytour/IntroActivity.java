package com.example.android.bucharestcitytour;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Handler delayer = new Handler();
        delayer.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent starMainActivity = new Intent(IntroActivity.this, MainActivity.class);
                startActivity(starMainActivity);
                finish();
            }
        }, 2000);
    }
}
