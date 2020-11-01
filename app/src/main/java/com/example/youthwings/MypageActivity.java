package com.example.youthwings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MypageActivity extends AppCompatActivity {

    ListView listView;
    LoanListAdapter loanListAdapter;
    ArrayList<LoanListViewItem> loanListViewItemArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        listView = (ListView)findViewById(R.id.mypage_loanlist);

        loanListViewItemArrayList = new ArrayList<LoanListViewItem>();

        loanListViewItemArrayList.add( new LoanListViewItem("이대점","","",""));
        loanListViewItemArrayList.add( new LoanListViewItem("삼성점","","",""));
        loanListViewItemArrayList.add( new LoanListViewItem("강서점","","",""));

        loanListAdapter = new LoanListAdapter(MypageActivity.this, loanListViewItemArrayList);
        listView.setAdapter(loanListAdapter);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_moreloanlist:
                Intent intent1 = new Intent(MypageActivity.this, LoanListActivity.class);
                startActivity(intent1);
                break;
        }
    }
}