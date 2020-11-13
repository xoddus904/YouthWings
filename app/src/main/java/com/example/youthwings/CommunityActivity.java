package com.example.youthwings;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

import com.example.youthwings.server.RetrofitConnector;
import com.example.youthwings.server.ServiceApi;
import com.example.youthwings.server.model.BoardModel;
import com.example.youthwings.server.model.BoardRes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CommunityActivity extends AppCompatActivity {

    private ListView listView;
    private CommunityListAdapter communityListAdapter;
    private ArrayList<CommunityListViewItem> communityListViewItemArrayList;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);
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
    private void setCommunityList(ArrayList<BoardModel> boardModels) {
        communityListViewItemArrayList = new ArrayList<CommunityListViewItem>();     // 리스트뷰 아이템 목록
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");  // 날짜 형식 변환

        // ***************************************
        // 커뮤니티 게시글 목록 생성 시작
        // ***************************************
        int arraySize = boardModels.size();
        for (int i = 0; i < arraySize; i++) {
            int recommend = boardModels.get(i).getLikeModels().size();               // 해당 게시글 좋아요 갯수
            CommunityListViewItem item = new CommunityListViewItem(
                    boardModels.get(i).getBoardId(),
                    boardModels.get(i).getBoardTitle(),
                    format.format(boardModels.get(i).getBoardDate()),
                    boardModels.get(i).getBoardLook(),
                    recommend
            );
            communityListViewItemArrayList.add(item);
        }

        communityListAdapter = new CommunityListAdapter(CommunityActivity.this, communityListViewItemArrayList);
        listView.setAdapter(communityListAdapter);

        // listView 클릭 이벤트 작성
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), CommunityActivity2.class);
                // 값 넘김
                intent.putExtra("boardId", communityListViewItemArrayList.get(position).getCom_id());
                startActivity(intent);
            }
        });
    }

    // ***************************************
    // 커뮤니티 게시글 목록 가져오기 (서버 연동)
    // ***************************************
    private void getCommunityList() {
        Log.d("DEBUG", "################ 게시글 목록 가져오기 시작 ################");

        Retrofit retrofit = RetrofitConnector.createRetrofit();
        Call<BoardRes> call = retrofit.create(ServiceApi.class).getCommunityList();
        call.enqueue(new Callback<BoardRes>() {
            @Override
            public void onResponse(Call<BoardRes> call, Response<BoardRes> response) {
                // 서버 연골 성공 시
                if (response.isSuccessful()) {
                    BoardRes result = response.body();

                    setCommunityList(result.getBoardModels());      // 커뮤니티 리스트에 가져온 데이터 뿌려줌

                    Log.d("DEBUG", "################ 게시글 목록 가져오기 종료 ################");
                }
            }

            @Override
            public void onFailure(Call<BoardRes> call, Throwable t) {
                Log.d("Server", "onFailure: " + t.toString());
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
        getCommunityList();
    }
}