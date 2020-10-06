package com.example.youthwings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class JoinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_successjoin:
                Intent intent1 = new Intent(JoinActivity.this, MainActivity.class);
                startActivity(intent1);
                break;
        }
    }
}