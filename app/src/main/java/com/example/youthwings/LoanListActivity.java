package com.example.youthwings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class LoanListActivity extends AppCompatActivity {

    ListView listView;
    LoanListAdapter loanListAdapter;
    ArrayList<LoanListViewItem> loanListViewItemArrayList;

    androidx.appcompat.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_list);

        //툴바관리
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(""); //액션바 타이틀은 없애기
        //만든 툴바의 textview를 변경
        TextView toolbarTitle = findViewById(R.id.toolbar_title);
        toolbarTitle.setText("내 정보");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //뒤로가기 버튼

        listView = (ListView)findViewById(R.id.loan_list);
        loanListViewItemArrayList = new ArrayList<LoanListViewItem>();
        loanListViewItemArrayList.add( new LoanListViewItem("이대점","2020.08.08","2020.08.10","셔츠"));
        loanListViewItemArrayList.add( new LoanListViewItem("삼성점","2020.08.09","2020.08.15","셔츠,자켓"));
        loanListViewItemArrayList.add( new LoanListViewItem("강서점","2020.08.10","2020.08.17","셔츠,넥타이"));

        loanListAdapter = new LoanListAdapter(LoanListActivity.this, loanListViewItemArrayList);
        listView.setAdapter(loanListAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: { //toolbar의 back키 눌렀을 때
                Intent intent1 = new Intent(LoanListActivity.this, MainActivity.class);
                startActivity(intent1);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}