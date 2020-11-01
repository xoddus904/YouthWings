package com.example.youthwings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.ActionBar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.youthwings.server.RetrofitConnector;
import com.example.youthwings.server.ServiceApi;
import com.example.youthwings.server.model.UserModel;
import com.example.youthwings.server.model.UserRes;
import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class JoinActivity extends AppCompatActivity {
    final static String PATTERN_EMAIL = "^[a-zA-Z0-9]+@([a-zA-Z0-9]|\\-)+\\.[a-zA-Z0-9]\\S+$";
    private boolean chk_id = false;

    private EditText editText_id, editText_pwd, editText_re_pwd, editText_nick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        initViews();            // 뷰 초기화
        initEditTextEvent();    // EditText Event 초기화
        //툴바
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false); //기존 title 지우기
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //뒤로가기 버튼

        //만든 툴바 타이틀 바꾸기
        TextView toolbarTitle = findViewById(R.id.toolbar_title);
        toolbarTitle.setText("회원가입");

    }

    private void initEditTextEvent() {
        editText_id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (checkInputPattern(editText_id, editable)) {
                    editText_id.setBackground(getResources().getDrawable(R.drawable.view_input));
                    chk_id = true;
                } else {
                    editText_id.setBackground(getResources().getDrawable(R.drawable.view_input_not));
                    chk_id = false;
                }

            }
        });
    }

    private void initViews() {
        editText_id = findViewById(R.id.email_entry);
        editText_pwd = findViewById(R.id.password_entry);
        editText_re_pwd = findViewById(R.id.password_re_entry);
        editText_nick = findViewById(R.id.nickname_entry);
    }

    public boolean checkInputPattern(EditText editText, Editable editable) {
        boolean result = false;

        if (editText.toString().isEmpty()) return result;

        boolean isCorrectInput = Pattern.matches(PATTERN_EMAIL, editable.toString());
        if (isCorrectInput) {
            editText.setBackground(getResources().getDrawable(R.drawable.view_input));
            result = true;
        } else {
            editText.setBackground(getResources().getDrawable(R.drawable.view_input_not));
            result = false;
        }

        return result;
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

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_success_join:
                if (onCheckData(view)) {
                    String userId = editText_id.getText().toString().trim();
                    String userPwd = editText_pwd.getText().toString().trim();
                    onJoin(userId, userPwd);
                }
                break;
        }
    }

    private boolean onCheckData(final View view) {
        editText_re_pwd.setBackground(getResources().getDrawable(R.drawable.view_input));
        if (!chk_id) {
            Snackbar.make(view, "아이디를 정확하게 입력해 주세요", Snackbar.LENGTH_SHORT).show();
            editText_id.requestFocus();
//            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
            return false;
        }
        if (!editText_pwd.getText().toString().trim().equals(editText_re_pwd.getText().toString().trim())) {
            Snackbar.make(view, "비밀번호를 정확하게 입력해 주세요", Snackbar.LENGTH_SHORT).show();
            editText_re_pwd.setBackground(getResources().getDrawable(R.drawable.view_input_not));
            editText_re_pwd.requestFocus();
//            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
            return false;
        }

        return true;
    }

    private void onJoin(String userId, String userPwd) {
        UserModel userModel = new UserModel(userId, userPwd);
        Retrofit retrofit = RetrofitConnector.createRetrofit();
        Call<UserRes> call = retrofit.create(ServiceApi.class).signUp(userModel);
        call.enqueue(new Callback<UserRes>() {
            @Override
            public void onResponse(Call<UserRes> call, Response<UserRes> response) {
                // 서버 연골 성공 시
                if (response.isSuccessful()) {
                    UserRes result = response.body();
                    // 성공적으로 데이터 가져왔을 시
                    if (result.isSuc()) {
                        Intent intent = new Intent(JoinActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
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