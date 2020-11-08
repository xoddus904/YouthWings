package com.example.youthwings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SuitLoanActivity extends AppCompatActivity {

    private Intent intent;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suit_loan);

        toolbar = findViewById(R.id.toolbar);
    }

    public void onClick(View view) {
        //여기서 각 지역에 해당하는 페이지로 넘어갈 때, 버튼 하나하나 적는 것보다는 putExtra(?)사용해서
        //정보만 전달해서 다음페이지에서의 각 값만 바뀌게 하는 것이 낫지 않을까요..? (되는 걸로 하십시다)
        switch (view.getId()) {
            case R.id.btn_seoul:
                intent = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);
                break;
            case R.id.btn_incheon:
                intent = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);
                break;
        }
        startActivity(intent);
    }
}