package com.example.youthwings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.ActionBar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

public class JoinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

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

    //툴바
    @Override
    public boolean onOptionsItemSelected(MenuItem item ){
        switch(item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_successjoin:
                Intent intent1 = new Intent(JoinActivity.this, MainActivity.class);
                startActivity(intent1);
                break;
        }
    }
}