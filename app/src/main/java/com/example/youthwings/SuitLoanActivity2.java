package com.example.youthwings;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.youthwings.util.AlertUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SuitLoanActivity2 extends AppCompatActivity {

    Toolbar toolbar;
    TextView addressTextView;
    TextView storeNameTextView;
    TextView areaNameTextView;

    Calendar reservationCalendar = Calendar.getInstance();
    Calendar birthdayCalendar = Calendar.getInstance();

    EditText reservation_yearEditText;
    EditText reservation_monthEditText;
    EditText reservation_dayEditText;

    String reservDate;
    int companyId;
    String imageUrl;
    String areaName;
    String storeName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suit_loan2);
        initData();

        initLayout();

        //캘린더 및 시간
        Dateselect();
    }

    private void initData() {
        Intent intent = getIntent();
        companyId = intent.getIntExtra("companyId", 1);
        imageUrl = intent.getStringExtra("imageUrl");
        areaName = intent.getStringExtra("areaName");
        storeName = intent.getStringExtra("storeName");
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

        addressTextView = findViewById(R.id.loan_address);
        storeNameTextView = findViewById(R.id.loan2_storeName);
        areaNameTextView = findViewById(R.id.loan2_areaName);

        storeNameTextView.setText(storeName);
        areaNameTextView.setText(areaName);

        Spinner();
    }

    //캘린더
    DatePickerDialog.OnDateSetListener birthdayPicker = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int datOfMonth) {
            birthdayCalendar.set(Calendar.YEAR, year);
            birthdayCalendar.set(Calendar.MONTH, month);
            birthdayCalendar.set(Calendar.DAY_OF_MONTH, datOfMonth);

            updateLabeBirthday();
        }
    };

    DatePickerDialog.OnDateSetListener reservationPicker = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int datOfMonth) {
            reservationCalendar.set(Calendar.YEAR, year);
            reservationCalendar.set(Calendar.MONTH, month);
            reservationCalendar.set(Calendar.DAY_OF_MONTH, datOfMonth);

            updateLabeReservation();
        }
    };

    // 버튼 선택 Dialog 띄우기
    public void Dateselect() {

        Button reservationButton = (Button) findViewById(R.id.reservationDate_input);
        Button reservationTimeButton = (Button) findViewById(R.id.reservationTime_input);

        Button calenderButton = (Button) findViewById(R.id.calendar_input);

        reservationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(SuitLoanActivity2.this, reservationPicker, reservationCalendar.get(Calendar.YEAR), reservationCalendar.get(Calendar.MONTH), reservationCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        /*reservationTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar myCurrenTime = Calendar.getInstance();
                int hour = myCurrenTime.get(Calendar.HOUR_OF_DAY);
                int minute = myCurrenTime.get(Calendar.MINUTE);

                TimePickerDialog myTimePicker;

                final EditText reservationHour = (EditText) findViewById(R.id.reservation_hoursinput);

                myTimePicker = new TimePicker(SuitLoanActivity2.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        String timeState = "AM";
                        //선택한 시간이 2시를 넘을 경우 "PM"으로 변경 및 -12시간하여 출력
                        if(selectedHour > 12){
                            selectedHour -= 12;
                            timeState = "PM";
                        }

                        // EditText에 출력할 형식 지정
                        reservationHour.setText(selectedHour);
                    }
                }, hour, minute, false); // true의 경우 24시간 형식의 TimePicker출현

                myTimePicker.setTitle("Select Time");
                myTimePicker.show();
            }
        });*/


        calenderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(SuitLoanActivity2.this, birthdayPicker, birthdayCalendar.get(Calendar.YEAR), birthdayCalendar.get(Calendar.MONTH), birthdayCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    //예약 EditText
    private void updateLabeReservation() {
        String yearFormat = "yyyy";
        SimpleDateFormat yearSimpleDateFormat = new SimpleDateFormat(yearFormat, Locale.KOREA);

        String monthFormat = "MM";
        SimpleDateFormat monthSimpleDateFormat = new SimpleDateFormat(monthFormat, Locale.KOREA);

        String dayFormat = "dd";
        SimpleDateFormat daySimpleDateFormat = new SimpleDateFormat(dayFormat, Locale.KOREA);

        reservation_yearEditText = (EditText) findViewById(R.id.reservation_yearinput);
        reservation_monthEditText = (EditText) findViewById(R.id.reservation_monthinput);
        reservation_dayEditText = (EditText) findViewById(R.id.reservation_dayinput);

        reservation_yearEditText.setText(yearSimpleDateFormat.format(reservationCalendar.getTime()));
        reservation_monthEditText.setText(monthSimpleDateFormat.format(reservationCalendar.getTime()));
        reservation_dayEditText.setText(daySimpleDateFormat.format(reservationCalendar.getTime()));

        reservDate = reservation_yearEditText.getText().toString();
        reservDate += reservation_monthEditText.getText().toString();
        reservDate += reservation_dayEditText.getText().toString();
    }

    // 생일 EditText
    private void updateLabeBirthday() {
        String yearFormat = "yyyy";
        SimpleDateFormat yearSimpleDateFormat = new SimpleDateFormat(yearFormat, Locale.KOREA);

        String monthFormat = "MM";
        SimpleDateFormat monthSimpleDateFormat = new SimpleDateFormat(monthFormat, Locale.KOREA);

        String dayFormat = "dd";
        SimpleDateFormat daySimpleDateFormat = new SimpleDateFormat(dayFormat, Locale.KOREA);

        EditText yearEditText = (EditText) findViewById(R.id.yearinput);
        EditText monthEditText = (EditText) findViewById(R.id.monthinput);
        EditText dayEditText = (EditText) findViewById(R.id.dayinput);

        yearEditText.setText(yearSimpleDateFormat.format(birthdayCalendar.getTime()));
        monthEditText.setText(monthSimpleDateFormat.format(birthdayCalendar.getTime()));
        dayEditText.setText(daySimpleDateFormat.format(birthdayCalendar.getTime()));
    }

    public void Spinner(){
        final EditText editText = (EditText)findViewById(R.id.email_front);
        Spinner spinner = (Spinner)findViewById(R.id.email_spinner);
        final EditText textView = (EditText) findViewById(R.id.email_back);

        // Spinner 동작처리
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                String str = (String)parent.getItemAtPosition(position);
                textView.setText(str);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });

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
        Intent intent;
        switch (view.getId()) {
            case R.id.nextbtn_suit:
                intent = new Intent(SuitLoanActivity2.this, SuitLoanActivity3.class);
                intent.putExtra("reservDate", reservDate);
                intent.putExtra("companyId", companyId);
                intent.putExtra("areaName", areaName);
                intent.putExtra("storeName", storeName);
                startActivity(intent);
                break;

            case R.id.address_input:
                intent = new Intent(SuitLoanActivity2.this, SuitLoanAddressView.class);
                startActivityForResult(intent, 3000);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        addressTextView.setText(data.getStringExtra("RESULT").trim());
    }
}