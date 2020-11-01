package com.example.youthwings;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class LoanListActivity extends AppCompatActivity {

    ListView listView;
    LoanListAdapter loanListAdapter;
    ArrayList<LoanListViewItem> loanListViewItemArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_list);

        listView = (ListView)findViewById(R.id.loan_list);

        loanListViewItemArrayList = new ArrayList<LoanListViewItem>();

        loanListViewItemArrayList.add( new LoanListViewItem("이대점","2020.08.08","2020.08.10","셔츠"));
        loanListViewItemArrayList.add( new LoanListViewItem("삼성점","2020.08.09","2020.08.15","셔츠,자켓"));
        loanListViewItemArrayList.add( new LoanListViewItem("강서점","2020.08.10","2020.08.17","셔츠,넥타이"));

        loanListAdapter = new LoanListAdapter(LoanListActivity.this, loanListViewItemArrayList);
        listView.setAdapter(loanListAdapter);
    }
}