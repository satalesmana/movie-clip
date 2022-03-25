package com.sata.movieclip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplahActivity extends AppCompatActivity {
    private static int SPLAS_TIME_OUT  = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splah);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplahActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLAS_TIME_OUT);
    }
}