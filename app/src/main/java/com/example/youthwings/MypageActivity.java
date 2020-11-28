package com.example.youthwings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.youthwings.adapter.LoanListAdapter;
import com.example.youthwings.adapter.LoanListViewItem;
import com.example.youthwings.presenter.LoanConstants;
import com.example.youthwings.presenter.loan.LoanPresenter;
import com.example.youthwings.server.model.LoanModel;
import com.example.youthwings.util.SharedPreferenceUtil;

import java.util.ArrayList;

public class MypageActivity extends AppCompatActivity implements LoanConstants.View {
    LoanConstants.Presenter presenter;
    SharedPreferenceUtil sharedPreferenceUtil;
    ListView loanListView;
    TextView remainTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);
        sharedPreferenceUtil = new SharedPreferenceUtil(this);
        presenter = new LoanPresenter(this);
        init();
    }

    private void init() {
        Toolbar toolbar          = findViewById(R.id.toolbar        );
        ImageView profileImgView = findViewById(R.id.mypage_myimage );
        TextView nickTextView    = findViewById(R.id.mypage_nickname);
        TextView emailTextView   = findViewById(R.id.mypage_email   );
        TextView toolbarTitle    = findViewById(R.id.toolbar_title  );
        remainTextView           = findViewById(R.id.mypage_remain  );
        loanListView             = findViewById(R.id.mypage_loanlist);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(""); //액션바 타이틀은 없애기
        //만든 툴바의 textview를 변경
        toolbarTitle.setText("내 정보");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //뒤로가기 버튼
        //getSupportActionBar().setHomeAsUpIndicator(R.drawable.back_btn); //이미지바꾸는 코드인데 이미지가 너무 크다.


        nickTextView.setText(sharedPreferenceUtil.getSharedString("userNick"));
        emailTextView.setText(sharedPreferenceUtil.getSharedString("userId"));
        MultiTransformation multiTransformation = new MultiTransformation(new CircleCrop());
        Glide.with(this).load(R.drawable.profile1_img).apply(RequestOptions.bitmapTransform(multiTransformation)).into(profileImgView);

        presenter.onGetLoanList(sharedPreferenceUtil.getSharedString("userId"));
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_moreloanlist:
                Intent intent1 = new Intent(this, LoanListActivity.class);
                startActivity(intent1);
                break;
        }
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
        LoanListAdapter loanListAdapter = new LoanListAdapter(this, result, 0);
        loanListView.setAdapter(loanListAdapter);
        remainTextView.setText(10 - result.size() + "");
    }
}