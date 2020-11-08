package com.example.youthwings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MypageActivity extends AppCompatActivity {

    ListView listView;
    LoanListAdapter loanListAdapter;
    ArrayList<LoanListViewItem> loanListViewItemArrayList;

    androidx.appcompat.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        //툴바관리
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(""); //액션바 타이틀은 없애기
        //만든 툴바의 textview를 변경
        TextView toolbarTitle = findViewById(R.id.toolbar_title);
        toolbarTitle.setText("내 정보");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //뒤로가기 버튼
        //getSupportActionBar().setHomeAsUpIndicator(R.drawable.back_btn); //이미지바꾸는 코드인데 이미지가 너무 크다.

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

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: { //toolbar의 back키 눌렀을 때
                finish();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}