package com.example.youthwings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class InterviewActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview);

        initLayout();
    }

    private void initLayout() {
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); //만든 툴바 데려오기

        getSupportActionBar().setTitle(""); //액션바 타이틀은 없애기
        //만든 툴바의 textview를 변경
        TextView toolbarTitle = findViewById(R.id.toolbar_title);
        toolbarTitle.setText("면접 주요 질문");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //뒤로가기버튼
    }

    //툴바
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}