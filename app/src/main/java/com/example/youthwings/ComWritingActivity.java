package com.example.youthwings;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.youthwings.server.RetrofitConnector;
import com.example.youthwings.server.ServiceApi;
import com.example.youthwings.server.model.BoardModel;
import com.example.youthwings.server.model.BoardRes;
import com.example.youthwings.util.SharedPreferenceUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ComWritingActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText title_editText, content_editText;
    private SharedPreferenceUtil sharedPreferenceUtil;
    private String userId;      // 사용자 아이디

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com_writing);
        initLayout();
    }

    private void initLayout() {
        sharedPreferenceUtil = new SharedPreferenceUtil(this);
        userId = sharedPreferenceUtil.getSharedString("userId");               // 사용자 아이디 가져오기

        // ***************************************
        // EditText 초기화
        // ***************************************
        title_editText = findViewById(R.id.writing_title);
        content_editText = findViewById(R.id.writing_content);

        // ***************************************
        // 툴바관리
        // ***************************************
        toolbar = findViewById(R.id.writing_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");                                         // 액션바 타이틀은 없애기
        TextView toolbarTitle = findViewById(R.id.writing_toolbar_title);           // 만든 툴바의 textview를 변경
        toolbarTitle.setText("취업 커뮤니티");
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.writing_cancel:
                if (title_editText.getText().toString().isEmpty() && content_editText.getText().toString().isEmpty()) {
                    finish();
                } else {
                    onConfirmAlertDialog("글 작성을 취소하시겠습니까?");
                }
                break;
            case R.id.writing_post:
                if (title_editText.getText().toString().trim().isEmpty()) {
                    onAlertDialog("제목을 적어주세요");
                    return;
                }
                if (content_editText.getText().toString().trim().isEmpty()) {
                    onAlertDialog("내용을 적어주세요");
                    return;
                }
                onPostBoard();
                break;
        }
    }

    // ***************************************
    // 게시글 작성 (서버 연동)
    // ***************************************
    private void onPostBoard() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("청춘날개").setMessage("작성한 글은 커뮤니티 이용수칙에 따라 제한될 수 있습니다. \n" +
                "작성하시겠습니까?");

        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
            }
        });

        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                Log.d("DEBUG", "################ 게시글 작성하기 시작 ################");

                // 서버에 보낼 값 생성
                BoardModel boardModel = new BoardModel();
                boardModel.setBoardTitle(title_editText.getText().toString());          // 게시글 제목
                boardModel.setBoardContent(content_editText.getText().toString());      // 게시글 내용
                boardModel.setUserId(userId);                                           // 작성자 아이디

                Retrofit retrofit = RetrofitConnector.createRetrofit();
                Call<BoardRes> call = retrofit.create(ServiceApi.class).postBoard(boardModel);
                call.enqueue(new Callback<BoardRes>() {
                    @Override
                    public void onResponse(Call<BoardRes> call, Response<BoardRes> response) {
                        // 서버 연골 성공 시
                        if (response.isSuccessful()) {
                            BoardRes result = response.body();
                            if (result.isSuc()) {
                                Toast.makeText(getApplicationContext(), "작성되었습니다.", Toast.LENGTH_LONG).show();
                                finish();
                            }

                            Log.d("DEBUG", "################ 게시글 작성하기 종료 ################");
                        }
                    }

                    @Override
                    public void onFailure(Call<BoardRes> call, Throwable t) {
                        Log.d("Server", "onFailure: " + t.toString());
                    }
                });
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    // ***************************************
    // 확인, 취소 알림창
    // ***************************************
    private void onConfirmAlertDialog(String content) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("청춘날개").setMessage(content);

        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
            }
        });

        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    // ***************************************
    // 확인 알림창
    // ***************************************
    private void onAlertDialog(String content) {
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
}