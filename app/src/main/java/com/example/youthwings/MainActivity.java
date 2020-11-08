package com.example.youthwings;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    androidx.appcompat.widget.Toolbar toolbar;

    ViewPager viewPager;
    MainViewPageAdapter viewPageadapter;

    ListView listView;
    MainEmploymentListAdapter mainEmploymentListAdapter;
    ArrayList<MainEmploymentListViewItem> mainEmploymentListViewItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //툴바
        initLayout();

        //이미지 슬라이드
        viewPager = (ViewPager) findViewById(R.id.main_viewPager);
        viewPageadapter = new MainViewPageAdapter(this);
        viewPager.setAdapter(viewPageadapter);


        //리스트뷰 참조 및 Adapter 달기
        listView = (ListView)findViewById(R.id.employmentlist);
        mainEmploymentListViewItem = new ArrayList<MainEmploymentListViewItem>();

        mainEmploymentListViewItem.add( new MainEmploymentListViewItem("Top!","어쩌구저쩌구 쏼라쏼라...","5분전"));
        mainEmploymentListViewItem.add(new MainEmploymentListViewItem("Top!", "어쩌구저쩌구 쏼라쏼라...", "3분전"));

        //MainEmploymentAdapter 생성
        mainEmploymentListAdapter = new MainEmploymentListAdapter(MainActivity.this, mainEmploymentListViewItem);
        listView.setAdapter(mainEmploymentListAdapter);

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        else if (item.getItemId() == R.id.toolbar_help_button); {
            //Toast.makeText(this, "도움말 클릭", Toast.LENGTH_SHORT).show();
            Context mContext = getApplicationContext();
            AlertDialog.Builder alertDialogBuiler = new AlertDialog.Builder(this); // 빌더얻기

            //다이얼로그에 이미지로 넣을 거 아니라면 66줄~71줄까지 코드 삭제
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.custom_dialog, null); //레이아웃불러오기
            ImageView imageView = (ImageView) layout.findViewById(R.id.dialog_image); //해당 레이어에서 이미지뷰 불러오기
            imageView.setImageResource(R.drawable.introimg);//이미지뷰의 이미지 변경
            alertDialogBuiler.setView(layout);//다이얼로그에 배치

            //제목 설정
            alertDialogBuiler.setTitle("도움말");
            //다이얼로그 메세지
            alertDialogBuiler.setMessage("주의사항에는 뭐가 있고 저거가 있고 그렇다.")
                    .setCancelable(false)
                    .setPositiveButton("네", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel(); //다이얼로그 닫기
                        }
                    });
            AlertDialog alertDialog = alertDialogBuiler.create();
            alertDialog.show();
        }
        return super.onOptionsItemSelected(item);
    }

    private void initLayout() {
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); //만든 툴바 데려오기

        getSupportActionBar().setTitle(""); //액션바 타이틀은 없애기
        //만든 툴바의 textview를 변경
        TextView toolbarTitle = findViewById(R.id.toolbar_title);
        toolbarTitle.setText("청춘날개");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.menu_btn);

        drawerLayout = (DrawerLayout)findViewById(R.id.main_drawer_root);
        navigationView = (NavigationView)findViewById(R.id.nv_main_navigation_root);

        drawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    //도움말 버튼
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.toolbarmenu, menu);
        menu.findItem(R.id.toolbar_help_button).setIcon(R.drawable.icon_help);
        //menuInflater.inflate(R.menu.drawer,menu);
        //menu.findItem(R.id.)
        return true;
    }

    //activity_main_content.xml에 있는 버튼 기능 구현코드
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_jobinform:
                Intent intent1 = new Intent(MainActivity.this, JobInformActivity.class);
                startActivity(intent1);
                break;
            case R.id.main_community:
                Intent intent2 = new Intent(MainActivity.this, CommunityActivity.class);
                startActivity(intent2);
                break;
            case R.id.main_interview:
                Intent intent3 = new Intent(MainActivity.this, InterviewActivity.class);
                startActivity(intent3);
                break;
            case R.id.main_suitloan:
                Intent intent4 = new Intent(MainActivity.this, SuitLoanActivity.class);
                startActivity(intent4);
                break;
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menu_mypage :
                Toast.makeText(this, "내정보 clicked", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(MainActivity.this, MypageActivity.class);
                startActivity(intent1);
                break;

            case R.id.menu_home :
                Toast.makeText(this, "홈으로 clicked", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent2);
                break;
            case R.id.menu_reservation :
                Toast.makeText(this, "예약하기 clicked", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(MainActivity.this, SuitLoanActivity.class);
                startActivity(intent3);
                break;
            case R.id.menu_loanlist :
                Toast.makeText(this, "대여내역 clicked", Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(MainActivity.this, LoanListActivity.class);
                startActivity(intent4);
                break;
            case R.id.menu_community :
                Toast.makeText(this, "취업 커뮤니티 clicked", Toast.LENGTH_SHORT).show();
                Intent intent5 = new Intent(MainActivity.this, CommunityActivity.class);
                startActivity(intent5);
                break;
            case R.id.menu_interviewlist :
                Toast.makeText(this, "면접 주요 질문 모음 clicked", Toast.LENGTH_SHORT).show();
                Intent intent6 = new Intent(MainActivity.this, InterviewActivity.class);
                startActivity(intent6);
                break;
            case R.id.menu_myresponse :
                Toast.makeText(this, "내 답변 clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }
}