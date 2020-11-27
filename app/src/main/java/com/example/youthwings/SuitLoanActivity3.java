package com.example.youthwings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SuitLoanActivity3 extends AppCompatActivity {

    Toolbar toolbar;

    Calendar interviewCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suit_loan3);

        //툴바
        initLayout();

        //면접 날짜
        Dateselect();

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

    //캘린더
    DatePickerDialog.OnDateSetListener interviewPicker = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int datOfMonth) {
            interviewCalendar.set(Calendar.YEAR, year);
            interviewCalendar.set(Calendar.MONTH, month);
            interviewCalendar.set(Calendar.DAY_OF_MONTH, datOfMonth);

            interviewReservation();
        }
    };

    // 버튼 선택 Dialog 띄우기
    public void Dateselect() {

        Button interviewButton = (Button) findViewById(R.id.interviewcalendar_input);

        interviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(SuitLoanActivity3.this, interviewPicker, interviewCalendar.get(Calendar.YEAR), interviewCalendar.get(Calendar.MONTH), interviewCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    //면접 EditText
    private  void interviewReservation(){
        String yearFormat = "yyyy";
        SimpleDateFormat yearSimpleDateFormat = new SimpleDateFormat(yearFormat, Locale.KOREA);

        String monthFormat = "MM";
        SimpleDateFormat monthSimpleDateFormat = new SimpleDateFormat(monthFormat, Locale.KOREA);

        String dayFormat = "dd";
        SimpleDateFormat daySimpleDateFormat = new SimpleDateFormat(dayFormat, Locale.KOREA);

        EditText reservation_yearEditText = (EditText)findViewById(R.id.yearinput);
        EditText reservation_monthEditText = (EditText)findViewById(R.id.monthinput);
        EditText reservation_dayEditText = (EditText)findViewById(R.id.dayinput);

        reservation_yearEditText.setText(yearSimpleDateFormat.format(interviewCalendar.getTime()));
        reservation_monthEditText.setText(monthSimpleDateFormat.format(interviewCalendar.getTime()));
        reservation_dayEditText.setText(daySimpleDateFormat.format(interviewCalendar.getTime()));
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
            case R.id.btn_reservation:
                Intent intent = new Intent(SuitLoanActivity3.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;

        }
    }
}