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
import com.example.youthwings.presenter.LoanConstants;
import com.example.youthwings.presenter.loan.LoanPresenter;
import com.example.youthwings.server.model.CompanyModel;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class SuitLoanActivity1 extends AppCompatActivity implements LoanConstants.List {

    TextView getData;

    Toolbar toolbar;
    String stateName;

    private ListView listView;
    private SuitLoanStoreChooseListAdapter suitLoanStoreChooseListAdapter;
    private LoanConstants.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suit_loan1);
        presenter = new LoanPresenter(this);

        //툴바 뒤로가기
        initLayout();

        //지역 이름 get
        getAreaName();

        //지역 로고 get
        getAreaImage();

        presenter.onGetCompanyList(stateName);
    }

    private void initListView(final ArrayList<CompanyModel> companyModels) {
        //리스트뷰 참조 및 Adapter 달기
        listView = (ListView) findViewById(R.id.storelist);

        //SuitLoanStoreChooseListAdapter 생성
        suitLoanStoreChooseListAdapter = new SuitLoanStoreChooseListAdapter(this, companyModels);
        listView.setAdapter(suitLoanStoreChooseListAdapter);

        // listView 클릭 이벤트 작성
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), SuitLoanActivity2.class);

                int companyId = companyModels.get(position).getCompanyId();
                String imageUrl = companyModels.get(position).getCompanyImageUrl();
                String storeName = companyModels.get(position).getCompanyName();
                intent.putExtra("companyId", companyId);
                intent.putExtra("imageUrl", imageUrl);
                intent.putExtra("areaName", stateName);
                intent.putExtra("storeName", storeName);
                startActivity(intent);
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
        stateName = intent.getExtras().getString("CITY");

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

    @Override
    public void onRequestResult(ArrayList<CompanyModel> result) {
        initListView(result);
    }
}