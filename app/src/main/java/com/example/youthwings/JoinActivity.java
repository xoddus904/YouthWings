package com.example.youthwings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.youthwings.presenter.LoginConstants;
import com.example.youthwings.presenter.login.LoginPresenter;
import com.example.youthwings.util.AlertUtil;


import java.util.regex.Pattern;

public class JoinActivity extends AppCompatActivity implements LoginConstants.JoinView {
    final static String PATTERN_EMAIL = "^[a-zA-Z0-9]+@([a-zA-Z0-9]|\\-)+\\.[a-zA-Z0-9]\\S+$";      // 정규 표현식
    private boolean chk_id = false;

    private EditText editText_id, editText_pwd, editText_re_pwd;
    private TextView textView_nick;
    private LoginConstants.Presenter presenter;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        presenter = new LoginPresenter(this);
        initLayout();
        initViews();                    // 뷰 초기화
        initEditTextEvent();            // EditText Event 초기화
        presenter.onCreateNickName();   // 닉네임 생성
    }

    private void initLayout() {
        // =============================================================
        // 툴바관리
        // =============================================================
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);                               //만든 툴바 데려오기
        getSupportActionBar().setTitle("");                         //액션바 타이틀은 없애기
        TextView toolbarTitle = findViewById(R.id.toolbar_title);   // 만든 툴바의 textView를 변경
        toolbarTitle.setText("회원가입");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);      //뒤로가기버튼
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
        textView_nick = findViewById(R.id.nickname_entry);
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
                    String nickname = textView_nick.getText().toString();
                    presenter.onJoin(userId, userPwd, nickname, this);
                }
                break;
        }
    }

    // =============================================================
    // 아이디, 비밀번호 형식 체크 (정규식)
    // =============================================================
    private boolean onCheckData(final View view) {
        editText_re_pwd.setBackground(getResources().getDrawable(R.drawable.view_input));
        if (!chk_id) {
            Toast.makeText(this, "아이디를 정확하게 입력해 주세요", Toast.LENGTH_SHORT).show();
            editText_id.requestFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
            return false;
        }
        if (!editText_pwd.getText().toString().trim().equals(editText_re_pwd.getText().toString().trim())) {
            Toast.makeText(this, "비밀번호를 정확하게 입력해 주세요", Toast.LENGTH_SHORT).show();
            editText_re_pwd.setBackground(getResources().getDrawable(R.drawable.view_input_not));
            editText_re_pwd.requestFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
            return false;
        }

        return true;
    }

    // =============================================================
    // 정규식 패턴
    // =============================================================
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

    @Override
    public void onRequestResult(boolean result) {
        if(result) {
            Intent intent = new Intent(JoinActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "동일한 아이디가 존재합니다. 다시 입력해주세요.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNickNameResult(String result) {
        if(result.equals("N")){
            AlertUtil.onAlertDialog(this, "닉네임 부족!!");
        }
        textView_nick.setText(result);
    }

}