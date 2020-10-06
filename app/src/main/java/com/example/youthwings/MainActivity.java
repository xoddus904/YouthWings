package com.example.youthwings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_jobinform:
                Intent intent1 = new Intent(MainActivity.this, JobInformActivity.class);
                startActivity(intent1);
                break;
            case R.id.main_community:
                Intent intent2 = new Intent(MainActivity.this, CommunityActivity.class);
                startActivity(intent2);
                break;
            case R.id.main_interview:
                Intent intent3 = new Intent(MainActivity.this, InterviewActivity.class);
                startActivity(intent3);
                break;
            case R.id.main_suitloan:
                Intent intent4 = new Intent(MainActivity.this, SuitLoanActivity.class);
                startActivity(intent4);
                break;
        }
    }
}