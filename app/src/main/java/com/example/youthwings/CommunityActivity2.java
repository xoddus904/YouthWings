package com.example.youthwings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class CommunityActivity2 extends AppCompatActivity {

    androidx.appcompat.widget.Toolbar toolbar;
    TextView title_detail_textView;
    TextView date_detail_textView; //전 엑티비티에서 값 받을게 없음
    TextView time_datail_textView;
    TextView recommand_detail_textView;
    TextView look_detail_textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community2);

        //툴바관리
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(""); //액션바 타이틀은 없애기
        //만든 툴바의 textview를 변경
        TextView toolbarTitle = findViewById(R.id.toolbar_title);
        toolbarTitle.setText("취업 커뮤니티");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //뒤로가기 버튼

        title_detail_textView = (TextView)findViewById(R.id.com_title_detail);
        time_datail_textView = (TextView)findViewById(R.id.com_time_datail);
        recommand_detail_textView = (TextView)findViewById(R.id.com_recommend_datail);
        look_detail_textView = (TextView)findViewById(R.id.com_look_datail);

        //값 받기
        Intent intent = getIntent();
        title_detail_textView.setText(intent.getStringExtra("title"));
        time_datail_textView.setText(intent.getStringExtra("time"));
        recommand_detail_textView.setText(intent.getStringExtra("recommand"));
        look_detail_textView.setText(intent.getStringExtra("look"));

    }

    //툴바
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: { //toolbar의 back키 눌렀을 때
                Intent intent1 = new Intent(CommunityActivity2.this, CommunityActivity.class);
                startActivity(intent1);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}