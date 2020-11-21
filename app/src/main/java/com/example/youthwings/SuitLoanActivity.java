package com.example.youthwings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

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

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_seoul:
                intent = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);

                //ID(?)
                intent.putExtra("CITY","SEOUL");

                //지역 이름
                intent.putExtra("AREANAME", sendSeoul.getText().toString());

                //이미지
                Bitmap seoulBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.suitloan_test_seoul);
                ByteArrayOutputStream seoulstream = new ByteArrayOutputStream();
                seoulBitmap.compress(Bitmap.CompressFormat.JPEG, 100, seoulstream);
                byte[] seoulByteArray = seoulstream.toByteArray();

                intent.putExtra("AREAIMAGE",seoulByteArray);

                break;

            case R.id.btn_busan:
                intent = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);

                //ID(?)
                intent.putExtra("CITY","BUSAN");

                //지역 이름
                intent.putExtra("AREANAME", sendBusan.getText().toString());

                //이미지
                Bitmap busanBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.busan_logo);
                ByteArrayOutputStream busanstream = new ByteArrayOutputStream();
                busanBitmap.compress(Bitmap.CompressFormat.JPEG, 100, busanstream);
                byte[] busanByteArray = busanstream.toByteArray();

                intent.putExtra("AREAIMAGE",busanByteArray);

                break;

            case R.id.btn_daegu:
                intent = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);

                //ID(?)
                intent.putExtra("CITY","DAEGU");

                //지역 이름
                intent.putExtra("AREANAME", sendDaegu.getText().toString());

                //이미지
                Bitmap daeguBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.daegu_logo);
                ByteArrayOutputStream daegustream = new ByteArrayOutputStream();
                daeguBitmap.compress(Bitmap.CompressFormat.JPEG, 100, daegustream);
                byte[] daeguByteArray = daegustream.toByteArray();

                intent.putExtra("AREAIMAGE",daeguByteArray);

                break;

            case R.id.btn_jeonju:
                intent = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);

                //ID(?)
                intent.putExtra("CITY","JEONJU");

                //지역 이름
                intent.putExtra("AREANAME", sendJeonju.getText().toString());

                //이미지
                Bitmap jeonjuBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.jeonju_logo);
                ByteArrayOutputStream jeonjustream = new ByteArrayOutputStream();
                jeonjuBitmap.compress(Bitmap.CompressFormat.JPEG, 100, jeonjustream);
                byte[] jeonjuByteArray = jeonjustream.toByteArray();

                intent.putExtra("AREAIMAGE",jeonjuByteArray);

                break;

            case R.id.btn_suwon:
                intent = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);

                //ID(?)
                intent.putExtra("CITY","SUWON");

                //지역 이름
                intent.putExtra("AREANAME", sendSuwon.getText().toString());

                //이미지
                Bitmap suwonBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.suwon_logo);
                ByteArrayOutputStream suwonstream = new ByteArrayOutputStream();
                suwonBitmap.compress(Bitmap.CompressFormat.JPEG, 100, suwonstream);
                byte[] suwonByteArray = suwonstream.toByteArray();

                intent.putExtra("AREAIMAGE",suwonByteArray);

                break;

            case R.id.btn_cheongju:
                intent = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);

                //ID(?)
                intent.putExtra("CITY","CHEONGJU");

                //지역 이름
                intent.putExtra("AREANAME", sendCheongju.getText().toString());

                //이미지
                Bitmap cheongjuBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cheongju_logo);
                ByteArrayOutputStream cheongjustream = new ByteArrayOutputStream();
                cheongjuBitmap.compress(Bitmap.CompressFormat.JPEG, 100, cheongjustream);
                byte[] cheongjuByteArray = cheongjustream.toByteArray();

                intent.putExtra("AREAIMAGE",cheongjuByteArray);

                break;

            case R.id.btn_gwangju:
                intent = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);

                //ID(?)
                intent.putExtra("CITY","GWANGJU");

                //지역 이름
                intent.putExtra("AREANAME", sendGwangju.getText().toString());

                //이미지
                Bitmap gwangjuBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.gwangju_logo);
                ByteArrayOutputStream gwangjustream = new ByteArrayOutputStream();
                gwangjuBitmap.compress(Bitmap.CompressFormat.JPEG, 100, gwangjustream);
                byte[] gwangjuByteArray = gwangjustream.toByteArray();

                intent.putExtra("AREAIMAGE",gwangjuByteArray);

                break;

            case R.id.btn_incheon:
                intent = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);

                //ID(?)
                intent.putExtra("CITY","INCHEON");

                //지역 이름
                intent.putExtra("AREANAME", sendIncheon.getText().toString());

                //이미지
                Bitmap incheonBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.incheon_logo);
                ByteArrayOutputStream incheonstream = new ByteArrayOutputStream();
                incheonBitmap.compress(Bitmap.CompressFormat.JPEG, 100, incheonstream);
                byte[] incheonByteArray = incheonstream.toByteArray();

                intent.putExtra("AREAIMAGE",incheonByteArray);

                break;

            case R.id.btn_gimpo:
                intent = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);

                //ID(?)
                intent.putExtra("CITY","GIMPO");

                //지역 이름
                intent.putExtra("AREANAME", sendGimpo.getText().toString());

                //이미지
                Bitmap gimpoBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.gimpo_logo);
                ByteArrayOutputStream gimpostream = new ByteArrayOutputStream();
                gimpoBitmap.compress(Bitmap.CompressFormat.JPEG, 100, gimpostream);
                byte[] gimpoByteArray = gimpostream.toByteArray();

                intent.putExtra("AREAIMAGE",gimpoByteArray);

                break;

            case R.id.btn_yongin:
                intent = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);

                //ID(?)
                intent.putExtra("CITY","YONGIN");

                //지역 이름
                intent.putExtra("AREANAME", sendYongin.getText().toString());

                //이미지
                Bitmap yonginBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.yongin_logo);
                ByteArrayOutputStream yonginstream = new ByteArrayOutputStream();
                yonginBitmap.compress(Bitmap.CompressFormat.JPEG, 100, yonginstream);
                byte[] yonginByteArray = yonginstream.toByteArray();

                intent.putExtra("AREAIMAGE",yonginByteArray);

                break;

            case R.id.btn_uijeongbu:
                intent = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);

                //ID(?)
                intent.putExtra("CITY","UIJEONGBU");

                //지역 이름
                intent.putExtra("AREANAME", sendUijeongbu.getText().toString());

                //이미지
                Bitmap uijeongbuBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.uijeongbu_logo);
                ByteArrayOutputStream uijeongbustream = new ByteArrayOutputStream();
                uijeongbuBitmap.compress(Bitmap.CompressFormat.JPEG, 100, uijeongbustream);
                byte[] uijeongbuByteArray = uijeongbustream.toByteArray();

                intent.putExtra("AREAIMAGE",uijeongbuByteArray);

                break;

            case R.id.btn_hwaseong:
                intent = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);

                //ID(?)
                intent.putExtra("CITY","HWASEONG");

                //지역 이름
                intent.putExtra("AREANAME", sendHwaseong.getText().toString());

                //이미지
                Bitmap hwaseongBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.hwaseong_logo);
                ByteArrayOutputStream hwaseongstream = new ByteArrayOutputStream();
                hwaseongBitmap.compress(Bitmap.CompressFormat.JPEG, 100, hwaseongstream);
                byte[] hwaseongByteArray = hwaseongstream.toByteArray();

                intent.putExtra("AREAIMAGE",hwaseongByteArray);

                break;

            case R.id.btn_changwon:
                intent = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);

                //ID(?)
                intent.putExtra("CITY","CHANGWON");

                //지역 이름
                intent.putExtra("AREANAME", sendChangwon.getText().toString());

                //이미지
                Bitmap changwonBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.changwon_logo);
                ByteArrayOutputStream changwonstream = new ByteArrayOutputStream();
                changwonBitmap.compress(Bitmap.CompressFormat.JPEG, 100, changwonstream);
                byte[] changwonByteArray = changwonstream.toByteArray();

                intent.putExtra("AREAIMAGE",changwonByteArray);

                break;

            case R.id.btn_goyang:
                intent = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);

                //ID(?)
                intent.putExtra("CITY","GOYONG");

                //지역 이름
                intent.putExtra("AREANAME", sendGoyang.getText().toString());

                //이미지
                Bitmap goyangBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.goyang_logo);
                ByteArrayOutputStream goyangstream = new ByteArrayOutputStream();
                goyangBitmap.compress(Bitmap.CompressFormat.JPEG, 100, goyangstream);
                byte[] goyangByteArray = goyangstream.toByteArray();

                intent.putExtra("AREAIMAGE",goyangByteArray);

                break;

            case R.id.btn_namyangju:
                intent = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);

                //ID(?)
                intent.putExtra("CITY","NAMYANGJU");

                //지역 이름
                intent.putExtra("AREANAME", sendNamyangju.getText().toString());

                //이미지
                Bitmap namyangjuBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.namyangju_logo);
                ByteArrayOutputStream namyangjustream = new ByteArrayOutputStream();
                namyangjuBitmap.compress(Bitmap.CompressFormat.JPEG, 100, namyangjustream);
                byte[] namyangjuByteArray = namyangjustream.toByteArray();

                intent.putExtra("AREAIMAGE",namyangjuByteArray);

                break;

            case R.id.btn_anyang:
                intent = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);

                //ID(?)
                intent.putExtra("CITY","ANYANG");

                //지역 이름
                intent.putExtra("AREANAME", sendAnyang.getText().toString());

                //이미지
                Bitmap anyangBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.anyang_logo);
                ByteArrayOutputStream anyangstream = new ByteArrayOutputStream();
                anyangBitmap.compress(Bitmap.CompressFormat.JPEG, 100, anyangstream);
                byte[] anyangByteArray = anyangstream.toByteArray();

                intent.putExtra("AREAIMAGE",anyangByteArray);

                break;

            case R.id.btn_hanam:
                intent = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);

                //ID(?)
                intent.putExtra("CITY","HANAM");


                //지역 이름
                intent.putExtra("AREANAME", sendHanam.getText().toString());

                //이미지
                Bitmap hanamBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.hanam_logo);
                ByteArrayOutputStream hanamstream = new ByteArrayOutputStream();
                hanamBitmap.compress(Bitmap.CompressFormat.JPEG, 100, hanamstream);
                byte[] hanamByteArray = hanamstream.toByteArray();

                intent.putExtra("AREAIMAGE",hanamByteArray);

                break;

            case R.id.btn_uiwang:
                intent = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);

                //ID(?)
                intent.putExtra("CITY","UIWANG");

                //지역 이름
                intent.putExtra("AREANAME", sendUiwang.getText().toString());

                //이미지
                Bitmap uiwangBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.uiwang_logo);
                ByteArrayOutputStream uiwangstream = new ByteArrayOutputStream();
                uiwangBitmap.compress(Bitmap.CompressFormat.JPEG, 100, uiwangstream);
                byte[] uiwangByteArray = uiwangstream.toByteArray();

                intent.putExtra("AREAIMAGE",uiwangByteArray);

                break;

            case R.id.btn_gunpo:
                intent = new Intent(SuitLoanActivity.this, SuitLoanActivity1.class);

                //ID(?)
                intent.putExtra("CITY","GUNPO");

                //지역 이름
                intent.putExtra("AREANAME", sendGunpo.getText().toString());

                //이미지
                Bitmap gunpoBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.gunpo_logo);
                ByteArrayOutputStream gunpostream = new ByteArrayOutputStream();
                gunpoBitmap.compress(Bitmap.CompressFormat.JPEG, 100, gunpostream);
                byte[] gunpoByteArray = gunpostream.toByteArray();

                intent.putExtra("AREAIMAGE",gunpoByteArray);

                break;
        }
        startActivity(intent);
    }
}