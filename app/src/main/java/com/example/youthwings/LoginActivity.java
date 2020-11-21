package com.example.youthwings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.youthwings.presenter.LoginConstants;
import com.example.youthwings.presenter.login.LoginPresenter;
import com.example.youthwings.util.SharedPreferenceUtil;

public class LoginActivity extends AppCompatActivity implements LoginConstants.LoginView {
    private Intent intent;
    private EditText editText_id, editText_pwd;
    private SharedPreferenceUtil sharedPreferenceUtil;
    private LoginConstants.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenter = new LoginPresenter(this);
        initLayout();
    }

    private void initLayout() {
        sharedPreferenceUtil = new SharedPreferenceUtil(this);
        editText_id = findViewById(R.id.email_input);
        editText_pwd = findViewById(R.id.password_input);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:            // 로그인 버튼
                String userId = editText_id.getText().toString();
                String userPwd = editText_pwd.getText().toString();
                presenter.onLogin(userId, userPwd, this);                // 로그인 실행
                break;
            case R.id.btn_login_dev:        // 개발자 로그인 실행 (아이디, 패스워드 패스)
                intent = new Intent(this, MainActivity.class);
                sharedPreferenceUtil.setSharedString("userId"   , "develop@dev.com"       );     // 테스트 계정 저장.
                sharedPreferenceUtil.setSharedString("userNick" , "할일없이사기를잘치던마법사");     // 유저 닉네임 세션(쉐어드프리퍼런스)에 저장.
                sharedPreferenceUtil.setSharedString("userName" , "테스트"                 );     // 유저 이름 세션(쉐어드프리퍼런스)에 저장.
                startActivity(intent);
                finish();
                break;
            case R.id.btn_join:             // 회원가입
                intent = new Intent(this, JoinActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onRequestResult(boolean result) {
        // 로그인 성공 여부
        if (result) {
            intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "아이디 또는 비밀번호를 다시 확인하세요.", Toast.LENGTH_SHORT).show();
        }
    }
}