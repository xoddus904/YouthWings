package com.example.youthwings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SuitLoanActivity2 extends AppCompatActivity {

    Toolbar toolbar;

    Calendar birthdayCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suit_loan2);

        initLayout();

        //캘린더
        birthdayDateselect();
    }

    private void initLayout() {
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); //만든 툴바 데려오기

        getSupportActionBar().setTitle(""); //액션바 타이틀은 없애기
        //만든 툴바의 textview를 변경
        TextView toolbarTitle = findViewById(R.id.toolbar_title);
        toolbarTitle.setText("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //뒤로가기버튼

        //Spinner
        Spinner spinner = findViewById(R.id.email_spinner);
    }

    //캘린더
    DatePickerDialog.OnDateSetListener birthdayPicker = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int datOfMonth) {
            birthdayCalendar.set(Calendar.YEAR, year);
            birthdayCalendar.set(Calendar.MONTH, month);
            birthdayCalendar.set(Calendar.DAY_OF_MONTH, datOfMonth);
            updateLabe1();
        }
    };

    public void birthdayDateselect(){
        Button calenderButton = (Button)findViewById(R.id.calendar_input);

        calenderButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                new DatePickerDialog(SuitLoanActivity2.this, birthdayPicker, birthdayCalendar.get(Calendar.YEAR), birthdayCalendar.get(Calendar.MONTH), birthdayCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private  void updateLabe1(){
        String yearFormat = "yyyy";
        SimpleDateFormat yearSimpleDateFormat = new SimpleDateFormat(yearFormat, Locale.KOREA);

        String monthFormat = "MM";
        SimpleDateFormat monthSimpleDateFormat = new SimpleDateFormat(monthFormat, Locale.KOREA);

        String dayFormat = "dd";
        SimpleDateFormat daySimpleDateFormat = new SimpleDateFormat(dayFormat, Locale.KOREA);

        EditText yearEditText = (EditText)findViewById(R.id.yearinput);
        yearEditText.setText(yearSimpleDateFormat.format(birthdayCalendar.getTime()));

        EditText monthEditText = (EditText)findViewById(R.id.monthinput);
        monthEditText.setText(monthSimpleDateFormat.format(birthdayCalendar.getTime()));

        EditText dayEditText = (EditText)findViewById(R.id.dayinput);
        dayEditText.setText(daySimpleDateFormat.format(birthdayCalendar.getTime()));
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

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.nextbtn_suit:
                Intent intent1 = new Intent(SuitLoanActivity2.this, SuitLoanActivity3.class);
                startActivity(intent1);
                break;

            case R.id.address_input:
                Intent intent2 = new Intent(SuitLoanActivity2.this, SuitLoanAddressView.class);
                startActivity(intent2);
                break;
        }
    }
}