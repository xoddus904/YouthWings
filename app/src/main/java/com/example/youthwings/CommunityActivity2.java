package com.example.youthwings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.youthwings.server.RetrofitConnector;
import com.example.youthwings.server.ServiceApi;
import com.example.youthwings.server.model.BoardModel;
import com.example.youthwings.server.model.BoardRes;
import com.example.youthwings.util.SharedPreferenceUtil;

import java.text.SimpleDateFormat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CommunityActivity2 extends AppCompatActivity {
    private Intent intent;
    private SharedPreferenceUtil sharedPreferenceUtil;

    private Toolbar toolbar;
    private TextView title_detail_textView,
            content_detail_textView,
            date_detail_textView,
            recommend_detail_textView,
            look_detail_textView;

    private int boardId;                // 해당 게시글 번호
    private String userId;              // 사용자 아이디
    private int recommend;              // 해당 게시글 추천 갯수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community2);
        initLayout();
        initData();
        getCommunity();
    }

    private void initData() {
        sharedPreferenceUtil = new SharedPreferenceUtil(this);
        intent = getIntent();       // 이전 액티비티에서 값 가져오기

        boardId = intent.getIntExtra("boardId", 0);        // 게시글 번호 세팅
        userId = sharedPreferenceUtil.getSharedString("userId");        // 사용자 아이디 세팅
    }

    private void initLayout() {
        // ***************************************
        // TextView 초기화
        // ***************************************
        title_detail_textView = (TextView) findViewById(R.id.com_title_detail);
        content_detail_textView = (TextView) findViewById(R.id.com_content_detail);
        date_detail_textView = (TextView) findViewById(R.id.com_date_detail);
        recommend_detail_textView = (TextView) findViewById(R.id.com_recommend_datail);
        look_detail_textView = (TextView) findViewById(R.id.com_look_detail);

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
    // 커뮤니티 게시글 뿌려주기
    // ***************************************
    private void setTextView(BoardModel boardModel) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");       // 날짜 형식 변환
        recommend = boardModel.getLikeModels().size();                  // 해당 게시글 좋아요 갯수

        title_detail_textView.setText(boardModel.getBoardTitle());
        content_detail_textView.setText(boardModel.getBoardContent());
        date_detail_textView.setText(format.format(boardModel.getBoardDate()));
        recommend_detail_textView.setText(String.valueOf(recommend));
        look_detail_textView.setText(String.valueOf(boardModel.getBoardLook()));
    }

    // ***************************************
    // 커뮤니티 게시글 가져오기 (서버 연동)
    // ***************************************
    private void getCommunity() {
        Log.d("DEBUG", "################ 게시글 가져오기 시작 ################");

        Retrofit retrofit = RetrofitConnector.createRetrofit();
        Call<BoardRes> call = retrofit.create(ServiceApi.class).getCommunity(boardId);
        call.enqueue(new Callback<BoardRes>() {
            @Override
            public void onResponse(Call<BoardRes> call, Response<BoardRes> response) {
                // 서버 연골 성공 시
                if (response.isSuccessful()) {
                    BoardRes result = response.body();
                    Log.d("DEBUG", result.getBoardModel().getBoardTitle());
                    Log.d("DEBUG", result.getBoardModel().getBoardDate().toString());

                    setTextView(result.getBoardModel());      // TextView에 가져온 데이터 뿌려줌

                    Log.d("DEBUG", "################ 게시글 가져오기 종료 ################");
                }
            }

            @Override
            public void onFailure(Call<BoardRes> call, Throwable t) {
                Log.d("Server", "onFailure: " + t.toString());
            }
        });
    }

    // ***************************************
    // 커뮤니티 추천하기 (서버 연동)
    // ***************************************
    private void onRecommend() {
        BoardModel boardModel = new BoardModel();
        boardModel.setUserId(userId);               // 유저 아이디
        boardModel.setBoardId(boardId);             // 해당(추천할) 게시글 번호

        Log.d("DEBUG", "################ 게시글 추천하기 시작 ################");

        Retrofit retrofit = RetrofitConnector.createRetrofit();
        Call<BoardRes> call = retrofit.create(ServiceApi.class).recommendBoard(boardModel);
        call.enqueue(new Callback<BoardRes>() {
            @Override
            public void onResponse(Call<BoardRes> call, Response<BoardRes> response) {
                // 서버 연골 성공 시
                if (response.isSuccessful()) {
                    BoardRes result = response.body();
                    Log.d("DEBUG", result.isSuc() + "");

                    if (result.isSuc()) {
                        onAlertDialog("추천되었습니다!");
                        recommend++;
                        recommend_detail_textView.setText(String.valueOf(recommend));
                    } else {
                        onAlertDialog("취소되었습니다.");
                        recommend--;
                        recommend_detail_textView.setText(String.valueOf(recommend));
                    }

                    Log.d("DEBUG", "################ 게시글 추천하기 종료 ################");
                }
            }

            @Override
            public void onFailure(Call<BoardRes> call, Throwable t) {
                Log.d("Server", "onFailure: " + t.toString());
            }
        });

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_recommend_plus:
                onRecommend();
                break;
        }
    }

    // ***************************************
    // 확인만 있는 알림창
    // ***************************************
    public void onAlertDialog(String content) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("청춘날개").setMessage(content);
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    //툴바
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