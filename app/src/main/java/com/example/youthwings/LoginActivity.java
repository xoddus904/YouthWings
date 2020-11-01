package com.example.youthwings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.youthwings.server.RetrofitConnector;
import com.example.youthwings.server.ServiceApi;
import com.example.youthwings.server.model.UserModel;
import com.example.youthwings.server.model.UserRes;
import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {
    private Intent intent;
    private EditText editText_id, editText_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
    }

    private void initViews() {
        editText_id = findViewById(R.id.email_input);
        editText_pwd = findViewById(R.id.password_input);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                String userId = editText_id.getText().toString();
                String userPwd = editText_pwd.getText().toString();
                onLogin(userId, userPwd, view);                 // 로그인 실행
                finish();
                break;
            case R.id.btn_login_dev:                            // 개발자 로그인 실행 (아이디, 패스워드 패스)
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.btn_join:                                 // 회원가입
                intent = new Intent(this, JoinActivity.class);
                startActivity(intent);
                break;
        }
    }

    // 로그인 메서드 (서버 연동)
    public void onLogin(String userId, String userPwd, final View view) {
        UserModel userModel = new UserModel(userId, userPwd);
        Retrofit retrofit = RetrofitConnector.createRetrofit();
        Call<UserRes> call = retrofit.create(ServiceApi.class).signIn(userModel);
        call.enqueue(new Callback<UserRes>() {
            @Override
            public void onResponse(Call<UserRes> call, Response<UserRes> response) {
                // 서버 연골 성공 시
                if (response.isSuccessful()) {
                    UserRes result = response.body();
                    // 성공적으로 데이터 가져왔을 시
                    if (result.isSuc()) {
                        intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    } else {
                        Snackbar.make(view, "아이디 또는 비밀번호를 다시 확인하세요.", Snackbar.LENGTH_SHORT).show();
                    }
                }
            }
            @Override
            public void onFailure(Call<UserRes> call, Throwable t) {
                Log.d("Server", "onFailure: " + t.toString());
            }
        });

    }
}