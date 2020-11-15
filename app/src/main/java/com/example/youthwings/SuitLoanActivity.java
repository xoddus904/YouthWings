package com.example.youthwings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;

public class SuitLoanActivity extends AppCompatActivity {

    TextView sendSeoul, sendBusan, sendDaegu, sendJeonju, sendSuwon, sendCheongju, sendGwangju, sendIncheon, sendGimpo, sendYongin, sendUijeongbu, sendHwaseong, sendChangwon, sendGoyang, sendNamyangju, sendAnyang, sendHanam, sendUiwang, sendGunpo;

    private Intent intent;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suit_loan);

        //툴바 뒤로가기
        initLayout();

        //지역이름 찾음
        setAreaName();

        setareaImage();

    }

    private void initLayout() {
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); //만든 툴바 데려오기

        getSupportActionBar().setTitle(""); //액션바 타이틀은 없애기
        //만든 툴바의 textview를 변경
        TextView toolbarTitle = findViewById(R.id.toolbar_title);
        toolbarTitle.setText("지역 선택");
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

    public void setAreaName(){

        sendSeoul = (TextView)findViewById(R.id.text_seoul);
        sendBusan = (TextView)findViewById(R.id.text_busan);
        sendDaegu = (TextView)findViewById(R.id.text_daegu);
        sendJeonju = (TextView)findViewById(R.id.text_jeonju);
        sendSuwon = (TextView)findViewById(R.id.text_suwon);
        sendCheongju = (TextView)findViewById(R.id.text_cheongju);
        sendGwangju = (TextView)findViewById(R.id.text_gwangju);
        sendIncheon = (TextView)findViewById(R.id.text_incheon);
        sendGimpo = (TextView)findViewById(R.id.text_gimpo);
        sendYongin = (TextView)findViewById(R.id.text_yongin);
        sendUijeongbu = (TextView)findViewById(R.id.text_uijeongbu);
        sendHwaseong = (TextView)findViewById(R.id.text_hwaseong);
        sendChangwon = (TextView)findViewById(R.id.text_changwon);
        sendGoyang = (TextView)findViewById(R.id.text_goyang);
        sendNamyangju = (TextView)findViewById(R.id.text_namyangju);
        sendAnyang = (TextView)findViewById(R.id.text_anyang);
        sendHanam = (TextView)findViewById(R.id.text_hanam);
        sendUiwang = (TextView)findViewById(R.id.text_uiwang);
        sendGunpo = (TextView)findViewById(R.id.text_gunpo);
    }

    public void setareaImage(){
    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_seoul:
                intent = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);

                //이미지
                Bitmap seoulBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.suitloan_seoulimg);
                ByteArrayOutputStream seoulstream = new ByteArrayOutputStream();
                seoulBitmap.compress(Bitmap.CompressFormat.JPEG, 100, seoulstream);
                byte[] seoulByteArray = seoulstream.toByteArray();

                intent.putExtra("areaimage",seoulByteArray);
                intent.putExtra("areaname", sendSeoul.getText().toString());

                break;

            case R.id.btn_busan:
                intent = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);

                //이미지
                Bitmap busanBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.suitloan_busanimg);
                ByteArrayOutputStream busanstream = new ByteArrayOutputStream();
                busanBitmap.compress(Bitmap.CompressFormat.JPEG, 100, busanstream);
                byte[] busanByteArray = busanstream.toByteArray();

                intent.putExtra("areaimage",busanByteArray);
                intent.putExtra("areaname", sendBusan.getText().toString());

                break;

            case R.id.btn_daegu:
                intent = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);
                intent.putExtra("areaname", sendDaegu.getText().toString());
                break;
            case R.id.btn_jeonju:
                intent = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);
                intent.putExtra("areaname", sendJeonju.getText().toString());
                break;
            case R.id.btn_suwon:
                intent = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);
                intent.putExtra("areaname", sendSuwon.getText().toString());
                break;
            case R.id.btn_cheongju:
                intent = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);
                intent.putExtra("areaname", sendCheongju.getText().toString());
                break;
            case R.id.btn_gwangju:
                intent = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);
                intent.putExtra("areaname", sendGwangju.getText().toString());
                break;
            case R.id.btn_incheon:
                intent = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);
                intent.putExtra("areaname", sendIncheon.getText().toString());
                break;
            case R.id.btn_gimpo:
                intent = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);
                intent.putExtra("areaname", sendGimpo.getText().toString());
                break;
            case R.id.btn_yongin:
                intent = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);
                intent.putExtra("areaname", sendYongin.getText().toString());
                break;
            case R.id.btn_uijeongbu:
                intent = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);
                intent.putExtra("areaname", sendUijeongbu.getText().toString());
                break;
            case R.id.btn_hwaseong:
                intent = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);
                intent.putExtra("areaname", sendHwaseong.getText().toString());
                break;
            case R.id.btn_changwon:
                intent = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);
                intent.putExtra("areaname", sendChangwon.getText().toString());
                break;
            case R.id.btn_goyang:
                intent = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);
                intent.putExtra("areaname", sendGoyang.getText().toString());
                break;
            case R.id.btn_namyangju:
                intent = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);
                intent.putExtra("areaname", sendNamyangju.getText().toString());
                break;
            case R.id.btn_anyang:
                intent = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);
                intent.putExtra("areaname", sendAnyang.getText().toString());
                break;
            case R.id.btn_hanam:
                intent = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);
                intent.putExtra("areaname", sendHanam.getText().toString());
                break;
            case R.id.btn_uiwang:
                intent = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);
                intent.putExtra("areaname", sendUiwang.getText().toString());
                break;
            case R.id.btn_gunpo:
                intent = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);
                intent.putExtra("areaname", sendGunpo.getText().toString());
                break;
        }
        startActivity(intent);
    }
}