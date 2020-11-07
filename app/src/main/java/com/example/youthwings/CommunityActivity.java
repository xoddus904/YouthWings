package com.example.youthwings;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CommunityActivity extends AppCompatActivity implements View.OnClickListener{

    ListView listView;
    CommunityListAdapter communityListAdapter;
    ArrayList<CommunityListViewItem> communityListViewItemArrayList;

    androidx.appcompat.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);

        //툴바관리
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(""); //액션바 타이틀은 없애기
        //만든 툴바의 textview를 변경
        TextView toolbarTitle = findViewById(R.id.toolbar_title);
        toolbarTitle.setText("취업 커뮤니티");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //뒤로가기 버튼

        listView = (ListView)findViewById(R.id.community_list);

        communityListViewItemArrayList = new ArrayList<CommunityListViewItem>();
        communityListViewItemArrayList.add(new CommunityListViewItem("여기는 이렇다","04:26",2,8));
        communityListViewItemArrayList.add(new CommunityListViewItem("저기는 이렇다","10:25",25,2));
        communityListViewItemArrayList.add(new CommunityListViewItem("저기는 별로다","01:26",66,8));

        communityListAdapter = new CommunityListAdapter(CommunityActivity.this, communityListViewItemArrayList);
        listView.setAdapter(communityListAdapter);


        //listview클릭
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), CommunityActivity2.class);
                //값 넘김
                intent.putExtra("title", communityListViewItemArrayList.get(position).getCom_Title());
                intent.putExtra("time", communityListViewItemArrayList.get(position).getCom_time());
                intent.putExtra("recommand", Integer.toString(communityListViewItemArrayList.get(position).getCom_recommand()));
                intent.putExtra("look", Integer.toString(communityListViewItemArrayList.get(position).getCom_look()));
                startActivity(intent);
            }
        });

    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_write:
                Intent intent1 = new Intent(CommunityActivity.this, ComWritingActivity.class);
                startActivity(intent1);
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: { //toolbar의 back키 눌렀을 때
                Intent intent1 = new Intent(CommunityActivity.this, MainActivity.class);
                startActivity(intent1);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

}