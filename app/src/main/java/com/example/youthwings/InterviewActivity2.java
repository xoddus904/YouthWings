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
import android.widget.Toast;

import com.example.youthwings.adapter.InterviewListAdpater;
import com.example.youthwings.adapter.InterviewListItem;
import com.example.youthwings.adapter.ResponseListAdapter;
import com.example.youthwings.adapter.ResponseListItem;

import java.util.ArrayList;

public class InterviewActivity2 extends AppCompatActivity {

    Toolbar toolbar;

    ListView listView;
    ResponseListAdapter responseListAdapter;
    ArrayList<ResponseListItem> responseListItemArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview2);

        listView = (ListView)findViewById(R.id.response_listview);
        responseListItemArrayList = new ArrayList<ResponseListItem>();

        responseListItemArrayList.add( new ResponseListItem("자기소개를 30초안에 해보세요",2,"쓸말이 없다..."));
        responseListItemArrayList.add( new ResponseListItem("자기소개를 30초안에 해보세요",2,"가나다라마바사아자차카타파하 최대한 길게 써야하는데 무슨 말을 해야할까요 동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세 이 기상과 이맘으로 충성을 다하여 괴로우나 즐거우나\n" +
                "                                abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"));

        responseListAdapter = new ResponseListAdapter(InterviewActivity2.this, responseListItemArrayList);
        listView.setAdapter(responseListAdapter);

       /* listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), InterviewActivity2.class);
                // 값 넘김
               // intent.putExtra("interviewTitle", responseListItemArrayList.get(position).getResponse_nickname());
                //Toast.makeText();
                startActivity(intent);
            }
        });*/

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