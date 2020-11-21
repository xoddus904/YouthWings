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

public class SuitLoanActivity1 extends AppCompatActivity {

    TextView getData;
    Bitmap image;

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
        listView = (ListView)findViewById(R.id.storelist);

        //SuitLoanStoreChooseListAdapter 생성
        suitLoanStoreChooseListAdapter = new SuitLoanStoreChooseListAdapter();
        listView.setAdapter(suitLoanStoreChooseListAdapter);

        suitLoanStoreChooseListAdapter.addItem(ContextCompat.getDrawable(this,R.drawable.suitloanchoose_opencloset),"열린옷장","주소임","영업시간","점심시간","휴일","전화번호");

        // listView 클릭 이벤트 작성
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), SuitLoanActivity2.class);
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

    public void getAreaName(){
        Intent intent = getIntent();
        String getAreanameData = intent.getExtras().getString("AREANAME");

        getData = (TextView)findViewById(R.id.loan1_areaName);
        getData.setText(getAreanameData);
    }

    public void getAreaImage(){
        Intent intent = getIntent();
        byte[] arr = getIntent().getByteArrayExtra("AREAIMAGE");
        image = BitmapFactory.decodeByteArray(arr, 0, arr.length);
        ImageView BigImage = (ImageView)findViewById(R.id.areaImage);
        BigImage.setImageBitmap(image);
    }

    public void onClick(View view) {

        switch (view.getId()) {
        }
    }
}