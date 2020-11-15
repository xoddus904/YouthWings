package com.example.youthwings;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.youthwings.adapter.CommunityListAdapter;
import com.example.youthwings.presenter.CommunityConstants;
import com.example.youthwings.presenter.community.CommunityPresenter;
import com.example.youthwings.server.model.BoardModel;

import java.util.ArrayList;

public class CommunityActivity extends AppCompatActivity implements CommunityConstants.ListView {

    private ListView listView;
    private CommunityListAdapter communityListAdapter;
    private CommunityConstants.Presenter presenter;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);
        presenter = new CommunityPresenter(this);
        initLayout();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.toolbarmenu, menu);
        menu.findItem(R.id.toolbar_help_button).setIcon(R.drawable.icon_help);
        return true;
    }

    private void initLayout() {
        listView = findViewById(R.id.community_list);                               // 커뮤니티 게시글 리스트뷰

        // ***************************************
        // 툴바관리
        // ***************************************
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");                                         // 액션바 타이틀은 없애기
        TextView toolbarTitle = findViewById(R.id.toolbar_title);                   // 만든 툴바의 textview를 변경
        toolbarTitle.setText("취업 커뮤니티");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);                      // 뒤로가기 버튼

    }

    // ***************************************
    // 커뮤니티 게시글 목록 뿌려주기
    // ***************************************
    private void setCommunityList(final ArrayList<BoardModel> boardModels) {
        communityListAdapter = new CommunityListAdapter(CommunityActivity.this, boardModels);
        listView.setAdapter(communityListAdapter);

        // listView 클릭 이벤트 작성
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), CommunityActivity2.class);
                // 값 넘김
                intent.putExtra("boardId", boardModels.get(position).getBoardId());
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: { //toolbar의 back키 눌렀을 때
                finish();
                break;
            }
            case R.id.toolbar_help_button: { //글쓰기 버튼인데 아이디는 도움말 버튼과 동일
                // ***************************************
                // 글쓰기 버튼
                // ***************************************
                Intent intent = new Intent(CommunityActivity.this, ComWritingActivity.class);
                startActivity(intent);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onGetCommunityList();
    }

    @Override
    public void onRequestResult(ArrayList<BoardModel> result) {
        setCommunityList(result);
    }
}