package com.example.youthwings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class IntroActivity extends AppCompatActivity {
    private  final int Intro_time = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                IntroActivity.this.finish();
            }
        }, Intro_time);
    }

    @Override //뒤로가기 안되게
    public void onBackPressed() {
        super.onBackPressed();
    }
}