package com.example.youthwings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SuitLoanActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suit_loan2);
    }
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.nextbtn_suit:
                Intent intent1 = new Intent(SuitLoanActivity2.this, SuitLoanActivity3.class);
                startActivity(intent1);
                break;
        }
    }
}