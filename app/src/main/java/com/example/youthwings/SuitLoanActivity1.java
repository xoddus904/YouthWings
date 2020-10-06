package com.example.youthwings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SuitLoanActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suit_loan1);
    }
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_mapo:
                Intent intent1 = new Intent(SuitLoanActivity1.this, SuitLoanActivity2.class);
                startActivity(intent1);
                break;

            case R.id.btn_gangnam:
                Intent intent2 = new Intent(SuitLoanActivity1.this, SuitLoanActivity2.class);
                startActivity(intent2);
                break;
        }
    }
}