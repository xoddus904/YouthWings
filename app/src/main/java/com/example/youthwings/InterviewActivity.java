package com.example.youthwings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.youthwings.adapter.InterviewListAdpater;
import com.example.youthwings.adapter.InterviewListItem;
import com.example.youthwings.adapter.LoanListAdapter;
import com.example.youthwings.adapter.LoanListViewItem;

import java.util.ArrayList;

public class InterviewActivity extends AppCompatActivity {

    Toolbar toolbar;

    ListView listView;
    InterviewListAdpater interviewListAdpater;
    ArrayList<InterviewListItem> interviewListItemArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview);

        listView = (ListView)findViewById(R.id.interview_list);
        interviewListItemArrayList = new ArrayList<InterviewListItem>();

        interviewListItemArrayList.add( new InterviewListItem("자기소개를 30초안에 해보세요",24));
        interviewListItemArrayList.add( new InterviewListItem("인상 깊은 교내/교외 활동은 뭔가요?",185));

        interviewListAdpater = new InterviewListAdpater(InterviewActivity.this, interviewListItemArrayList);
        listView.setAdapter(interviewListAdpater);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), InterviewActivity2.class);
                //값 넘김
                intent.putExtra("interviewTitle", interviewListItemArrayList.get(position).getInterviewTitle());
                startActivity(intent);
            }
        });

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