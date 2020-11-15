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

import com.example.youthwings.presenter.CommunityConstants;
import com.example.youthwings.presenter.community.CommunityPresenter;
import com.example.youthwings.server.RetrofitConnector;
import com.example.youthwings.server.ServiceApi;
import com.example.youthwings.server.model.BoardModel;
import com.example.youthwings.server.model.BoardRes;
import com.example.youthwings.util.SharedPreferenceUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ComWritingActivity extends AppCompatActivity implements CommunityConstants.WritingView {
    private Toolbar toolbar;
    private EditText title_editText, content_editText;
    private SharedPreferenceUtil sharedPreferenceUtil;
    private String userId;      // 사용자 아이디
    private CommunityConstants.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com_writing);
        presenter = new CommunityPresenter(this);
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
                onPostAlert();
                break;
        }
    }

    // ***************************************
    // 게시글 작성 알림창
    // ***************************************
    private void onPostAlert() {
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
                String title    = title_editText.getText().toString();      // 게시글 제목
                String content  = content_editText.getText().toString();    // 게시글 내용

                presenter.onPostBoard(getApplicationContext(), title, content);              // 게시글 작성 시작
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

    @Override
    public void onRequestResult(boolean result) {
        // 게시글 작성 성공 여부
        if (result) {
            Toast.makeText(getApplicationContext(), "작성되었습니다.", Toast.LENGTH_LONG).show();
            finish();
        }
    }
}