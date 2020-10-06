package com.example.youthwings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                Intent intent1 = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn_join:
                Intent intent2 = new Intent(LoginActivity.this, JoinActivity.class);
                startActivity(intent2);
                break;
        }
    }
}