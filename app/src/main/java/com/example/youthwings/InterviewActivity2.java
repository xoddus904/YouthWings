package com.example.youthwings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
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
import com.example.youthwings.util.SharedPreferenceUtil;

import java.util.ArrayList;

public class InterviewActivity2 extends AppCompatActivity {
    Toolbar toolbar;

    ListView listView;
    TextView textView;
    ResponseListAdapter responseListAdapter;
    ArrayList<ResponseListItem> responseListItemArrayList;

    ArrayList<InterviewListItem> interviewListItemArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview2);

        Intent intent = getIntent();
        String interviewTitle = intent.getExtras().getString("interviewTitle");

        //제목 가져오기
        textView = (TextView)findViewById(R.id.interview_title_detail);

        textView.setText(interviewTitle);

        //답변 리스트
        listView = (ListView)findViewById(R.id.response_listview);
        responseListItemArrayList = new ArrayList<ResponseListItem>();

        responseListItemArrayList.add( new ResponseListItem("닉네임1",2,"쓸말이 없다..."));
        responseListItemArrayList.add( new ResponseListItem("닉네임2",2,"가나다라마바사아자차카타파하 최대한 길게 써야하는데 무슨 말을 해야할까요 동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세 이 기상과 이맘으로 충성을 다하여 괴로우나 즐거우나\n" +
                " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"));
        responseListItemArrayList.add( new ResponseListItem("닉네임3",2,"오호 오 ㅐ 기능이 안될까나.......뭐가 문제일까욥"));
        responseListItemArrayList.add( new ResponseListItem("닉네임4",2,"왜이래애애ㅐ............"));
        responseListItemArrayList.add( new ResponseListItem("닉네임5",2,"가갸거겨고교구규그기나냐너녀노뇨누뉴느니"));

        responseListAdapter = new ResponseListAdapter(InterviewActivity2.this, responseListItemArrayList);
        listView.setAdapter(responseListAdapter);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //글쓰기 버튼
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.toolbarmenu, menu);
        menu.findItem(R.id.toolbar_help_button).setIcon(R.drawable.icon_edit);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                finish();
                break;
            }
            case R.id.toolbar_help_button: { //글쓰기 버튼인데 아이디는 도움말 버튼과 동일
                // ***************************************
                // 글쓰기 버튼 - 제목도 같이 넘김.
                // ***************************************
                Intent intent = new Intent(InterviewActivity2.this, InterWritingActivity.class);
                intent.putExtra("interviewTitle",textView.getText().toString());
                startActivity(intent);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }


    //답글 추천버튼
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id. btn_goodresponse:
                Toast.makeText(this, "답글 추천버튼클릭", Toast.LENGTH_SHORT).show();
        }
    }
}