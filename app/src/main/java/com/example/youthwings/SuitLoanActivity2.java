package com.example.youthwings;

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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SuitLoanActivity2 extends AppCompatActivity {

    Toolbar toolbar;

    Calendar reservationCalendar = Calendar.getInstance();
    Calendar birthdayCalendar = Calendar.getInstance();

    //EditText editText_hour = (EditText)findViewById(R.id.reservation_hoursinput);
    //EditText editText_minute = (EditText)findViewById(R.id.reservation_minuteinput);

    //TimePickerDialog.OnTimeSetListener callbackMethod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suit_loan2);

        initLayout();

        //캘린더 및 시간
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

    /*public void InitializeListener(){
        callbackMethod = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                editText_hour.setText(selectedHour);
                editText_minute.setText(selectedMinute);
            }
        };
    }*/

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
                EditText reservationMinute = (EditText) findViewById(R.id.reservation_minuteinput);


                callbackMethod = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        editText_hour.setText(selectedHour);
                        editText_minute.setText(selectedMinute);
                    }
                };

                /*myTimePicker = new TimePicker(SuitLoanActivity2.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        /*String timeState = "AM";
                        //선택한 시간이 2시를 넘을 경우 "PM"으로 변경 및 -12시간하여 출력
                        if(selectedHour > 12){
                            selectedHour -= 12;
                            timeState = "PM";
                        }

                        // EditText에 출력할 형식 지정
                        reservationHour.setText(selectedHour);

                        String hoursFormat = "hh";
                        SimpleDateFormat hourSimpleDateFormat = new SimpleDateFormat(hoursFormat, Locale.KOREA);

                        String minuteFormat = "mm";
                        SimpleDateFormat minutesimpleDateFormat = new SimpleDateFormat(minuteFormat,Locale.KOREA);


                        EditText reservation_hourEditText = (EditText)findViewById(R.id.reservation_hoursinput);
                        EditText reservation_minuteEditText = (EditText)findViewById(R.id.reservation_minuteinput);

                        reservation_hourEditText.setText(hourSimpleDateFormat.format(selectedHour));
                        reservation_minuteEditText.setText(minutesimpleDateFormat.format(selectedMinute));
                    }
                }, hour, minute, false); // true의 경우 24시간 형식의 TimePicker출현

                myTimePicker.setTitle("Select Time");
                myTimePicker.show();*


                TimePickerDialog timeDialog = new TimePickerDialog(SuitLoanActivity2.this, callbackMethod, 8,10, true);
                timeDialog.show();
            }
        });*/


        calenderButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                new DatePickerDialog(SuitLoanActivity2.this, birthdayPicker, birthdayCalendar.get(Calendar.YEAR), birthdayCalendar.get(Calendar.MONTH), birthdayCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    //예약 EditText
    private  void updateLabeReservation(){
        String yearFormat = "yyyy";
        SimpleDateFormat yearSimpleDateFormat = new SimpleDateFormat(yearFormat, Locale.KOREA);

        String monthFormat = "MM";
        SimpleDateFormat monthSimpleDateFormat = new SimpleDateFormat(monthFormat, Locale.KOREA);

        String dayFormat = "dd";
        SimpleDateFormat daySimpleDateFormat = new SimpleDateFormat(dayFormat, Locale.KOREA);

        EditText reservation_yearEditText = (EditText)findViewById(R.id.reservation_yearinput);
        EditText reservation_monthEditText = (EditText)findViewById(R.id.reservation_monthinput);
        EditText reservation_dayEditText = (EditText)findViewById(R.id.reservation_dayinput);

        reservation_yearEditText.setText(yearSimpleDateFormat.format(reservationCalendar.getTime()));
        reservation_monthEditText.setText(monthSimpleDateFormat.format(reservationCalendar.getTime()));
        reservation_dayEditText.setText(daySimpleDateFormat.format(reservationCalendar.getTime()));
    }

    // 생일 EditText
    private  void updateLabeBirthday(){
        String yearFormat = "yyyy";
        SimpleDateFormat yearSimpleDateFormat = new SimpleDateFormat(yearFormat, Locale.KOREA);

        String monthFormat = "MM";
        SimpleDateFormat monthSimpleDateFormat = new SimpleDateFormat(monthFormat, Locale.KOREA);

        String dayFormat = "dd";
        SimpleDateFormat daySimpleDateFormat = new SimpleDateFormat(dayFormat, Locale.KOREA);

        EditText yearEditText = (EditText)findViewById(R.id.yearinput);
        EditText monthEditText = (EditText)findViewById(R.id.monthinput);
        EditText dayEditText = (EditText)findViewById(R.id.dayinput);

        yearEditText.setText(yearSimpleDateFormat.format(birthdayCalendar.getTime()));
        monthEditText.setText(monthSimpleDateFormat.format(birthdayCalendar.getTime()));
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
                finish();
                break;

            case R.id.address_input:
                Intent intent2 = new Intent(SuitLoanActivity2.this, SuitLoanAddressView.class);
                startActivity(intent2);
                break;
        }
    }
}