package com.example.youthwings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.example.youthwings.adapter.LoanListAdapter;
import com.example.youthwings.adapter.LoanListViewItem;
import com.example.youthwings.presenter.LoanConstants;
import com.example.youthwings.presenter.loan.LoanPresenter;
import com.example.youthwings.server.model.LoanModel;
import com.example.youthwings.util.SharedPreferenceUtil;

import java.util.ArrayList;

public class LoanListActivity extends AppCompatActivity implements LoanConstants.View {

    ListView loanListView;
    LoanConstants.Presenter presenter;
    SharedPreferenceUtil sharedPreferenceUtil;

    androidx.appcompat.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_list);
        sharedPreferenceUtil = new SharedPreferenceUtil(this);
        presenter = new LoanPresenter(this);
        init();
    }

    private void init() {
        //툴바관리
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(""); //액션바 타이틀은 없애기
        //만든 툴바의 textview를 변경
        TextView toolbarTitle = findViewById(R.id.toolbar_title);
        toolbarTitle.setText("내 정보");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //뒤로가기 버튼

        loanListView = (ListView)findViewById(R.id.loan_list);
        presenter.onGetLoanList(sharedPreferenceUtil.getSharedString("userId"));
    }

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

    @Override
    public void onRequestResult(ArrayList<LoanModel> result) {
        LoanListAdapter loanListAdapter = new LoanListAdapter(this, result, 1);
        loanListView.setAdapter(loanListAdapter);
    }
}