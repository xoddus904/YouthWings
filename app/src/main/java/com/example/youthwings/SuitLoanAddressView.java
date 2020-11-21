package com.example.youthwings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Spinner;
import android.widget.TextView;

public class SuitLoanAddressView extends AppCompatActivity {

    Toolbar toolbar;

    private WebView webView;
    private TextView textAddress;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suit_loan_address_view);

        textAddress = findViewById(R.id.text_address);

        initLayout();

        //WebView 초기화
        init_webView();

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

    public void init_webView(){

        //WebView 설정
        webView = (WebView)findViewById(R.id.webView_address);

        //JavaScript 허용
        webView.getSettings().setJavaScriptEnabled(true);

        //JavaScript의 window.open 허용
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

        //JavaScript이벤트에 대응할 함수를 정의 한 클래스를 붙여줌
        webView.addJavascriptInterface(new AndroidBridge(), "TestApp");

        //web client를 chrome으로 설정
        webView.setWebChromeClient((new WebChromeClient()));

        //webview url load. php 파일 주소
        webView.loadUrl("내 php주소 입력");

    }

    private class AndroidBridge {
        @JavascriptInterface
        public void setAddress(final String arg1, final String arg2, final String arg3){
            handler.post(new Runnable() {
                @Override
                public void run() {
                    textAddress.setText(String.format("(%s) %s %s", arg1, arg2, arg3));

                    //WebView를 초기화 하지 않으면 재사용할 수 없음
                    init_webView();
                }
            });
        }
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

}