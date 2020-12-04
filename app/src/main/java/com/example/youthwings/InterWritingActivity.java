package com.example.youthwings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.youthwings.adapter.InterviewListAdpater;
import com.example.youthwings.adapter.InterviewListItem;

import java.util.ArrayList;

public class InterWritingActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView textView;

    //InterviewListItem interviewListItem;
    //InterviewListAdpater interviewListAdpater;
    //ArrayList<InterviewListItem> interviewListItemArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inter_writing);

        //String interviewtitle = interviewListItem.getInterviewTitle();

        Intent intent = getIntent();
        String interviewTitle = intent.getExtras().getString("interviewTitle");
//
        textView = (TextView) findViewById(R.id.interview_writing_title);
        textView.setText(interviewTitle);

        initLayout();
    }

    private void initLayout() {
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); //만든 툴바 데려오기

        getSupportActionBar().setTitle(""); ///액션바 타이틀은 없애기
        //만든 툴바의 textview를 변경
        TextView toolbarTitle = findViewById(R.id.toolbar_title);
        toolbarTitle.setText("답변 작성");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //뒤로가기버튼
    }

    public void onClick(View view) {
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