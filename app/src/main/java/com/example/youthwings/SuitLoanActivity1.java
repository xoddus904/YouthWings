package com.example.youthwings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.navigation.NavigationView;

public class SuitLoanActivity1 extends AppCompatActivity {

    TextView getData;

    Toolbar toolbar;

    private ListView listView;
    private SuitLoanStoreChooseListAdapter suitLoanStoreChooseListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suit_loan1);

        //툴바 뒤로가기
        initLayout();

        //지역 이름 get
        getAreaName();

        //지역 로고 get
        getAreaImage();

        //리스트뷰 참조 및 Adapter 달기
        listView = (ListView) findViewById(R.id.storelist);

        //SuitLoanStoreChooseListAdapter 생성
        suitLoanStoreChooseListAdapter = new SuitLoanStoreChooseListAdapter();
        listView.setAdapter(suitLoanStoreChooseListAdapter);

        suitLoanStoreChooseListAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.opencloset_logo), "열린옷장", "주소임", "영업시간", "점심시간", "휴일", "전화번호");
        suitLoanStoreChooseListAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.opencloset_logo), "열린옷장", "주소임", "영업시간", "점심시간", "휴일", "전화번호");

        // listView 클릭 이벤트 작성
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), SuitLoanActivity2.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void initLayout() {
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); //만든 툴바 데려오기

        getSupportActionBar().setTitle(""); //액션바 타이틀은 없애기
        //만든 툴바의 textview를 변경
        TextView toolbarTitle = findViewById(R.id.toolbar_title);
        toolbarTitle.setText("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //뒤로가기버튼
    }

    public void getAreaName() {
        Intent intent = getIntent();
        String getAreanameData = intent.getExtras().getString("AREANAME");

        getData = (TextView) findViewById(R.id.loan1_areaName);
        getData.setText(getAreanameData);
    }

    public void getAreaImage() {
        ImageView stateImageView = (ImageView) findViewById(R.id.areaImage);

        Intent intent = getIntent();
        String stateName = intent.getExtras().getString("CITY");

        switch (stateName) {
            case "서울" :
                Glide.with(this).load(R.drawable.seoul_logo).into(stateImageView);
                break;

            case "부산" :
                Glide.with(this).load(R.drawable.busan_logo).into(stateImageView);
                break;

            case "대구" :
                Glide.with(this).load(R.drawable.daegu_logo).into(stateImageView);
                break;

            case "전주" :
                Glide.with(this).load(R.drawable.jeonju_logo).into(stateImageView);
                break;

            case "수원" :
                Glide.with(this).load(R.drawable.suwon_logo).into(stateImageView);
                break;

            case "청주" :
                Glide.with(this).load(R.drawable.cheongju_logo).into(stateImageView);
                break;

            case "광주" :
                Glide.with(this).load(R.drawable.gwangju_logo).into(stateImageView);
                break;

            case "인천" :
                Glide.with(this).load(R.drawable.incheon_logo).into(stateImageView);
                break;

            case "김포" :
                Glide.with(this).load(R.drawable.gimpo_logo).into(stateImageView);
                break;

            case "용인" :
                Glide.with(this).load(R.drawable.yongin_logo).into(stateImageView);
                break;

            case "의정부" :
                Glide.with(this).load(R.drawable.uijeongbu_logo).into(stateImageView);
                break;

            case "화성" :
                Glide.with(this).load(R.drawable.hwaseong_logo).into(stateImageView);
                break;

            case "창원" :
                Glide.with(this).load(R.drawable.changwon_logo).into(stateImageView);
                break;

            case "고양" :
                Glide.with(this).load(R.drawable.goyang_logo).into(stateImageView);
                break;

            case "남양주" :
                Glide.with(this).load(R.drawable.namyangju_logo).into(stateImageView);
                break;

            case "안양" :
                Glide.with(this).load(R.drawable.anyang_logo).into(stateImageView);
                break;

            case "하남" :
                Glide.with(this).load(R.drawable.hanam_logo).into(stateImageView);
                break;

            case "의왕" :
                Glide.with(this).load(R.drawable.uiwang_logo).into(stateImageView);
                break;

            case "군포" :
                Glide.with(this).load(R.drawable.gunpo_logo).into(stateImageView);
                break;
        }
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
}