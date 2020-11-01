package com.example.youthwings;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CommunityActivity extends AppCompatActivity {

    ListView listView;
    CommunityListAdapter communityListAdapter;
    ArrayList<CommunityListViewItem> communityListViewItemArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);

        listView = (ListView)findViewById(R.id.community_list);

        communityListViewItemArrayList = new ArrayList<CommunityListViewItem>();

        communityListViewItemArrayList.add(new CommunityListViewItem("여기는 이렇다","04.26",2,8));
        communityListViewItemArrayList.add(new CommunityListViewItem("저기는 이렇다","10.25",25,2));
        communityListViewItemArrayList.add(new CommunityListViewItem("저기는 별로다","01.26",66,8));

        communityListAdapter = new CommunityListAdapter(CommunityActivity.this, communityListViewItemArrayList);
        listView.setAdapter(communityListAdapter);

    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_write:
                Intent intent1 = new Intent(CommunityActivity.this, ComWritingActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
