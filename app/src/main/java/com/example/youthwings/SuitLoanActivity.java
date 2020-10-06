package com.example.youthwings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SuitLoanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suit_loan);
    }
    public void onClick(View view) {
        //여기서 각 지역에 해당하는 페이지로 넘어갈 때, 버튼 하나하나 적는 것보다는 putExtra(?)사용해서
        //정보만 전달해서 다음페이지에서의 각 값만 바뀌게 하는 것이 낫지 않을까요..? (되는 걸로 하십시다)
        switch (view.getId()) {
            case R.id.btn_seoul:
                Intent intent1 = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);
                startActivity(intent1);
                break;
            case R.id.btn_incheon:
                Intent intent2 = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);
                startActivity(intent2);
                break;
        }
    }
}