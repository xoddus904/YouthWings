package com.example.youthwings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.youthwings.util.AlertUtil;

public class SuitLoanAddressView extends AppCompatActivity {

    Toolbar toolbar;

    private WebView webView;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suit_loan_address_view);

        handler = new Handler();

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
    }

    public void init_webView(){
        //WebView 설정
        webView = (WebView)findViewById(R.id.address_web_view);

        //JavaScript 허용
        webView.getSettings().setJavaScriptEnabled(true);

        //JavaScript의 window.open 허용
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

        //JavaScript이벤트에 대응할 함수를 정의 한 클래스를 붙여줌
        webView.addJavascriptInterface(new AndroidBridge(), "TestApp");

        //web client를 chrome으로 설정
        webView.setWebChromeClient((new WebChromeClient()));

        //webview url load. php 파일 주소
        webView.loadUrl("http://studylog.shop:5001/postcode");

    }

    private class AndroidBridge {
        @JavascriptInterface
        public void setAddress(final String arg1, final String arg2, final String arg3){
            handler.post(new Runnable() {
                @Override
                public void run() {
                    init_webView();

                    String address = String.format("(%s) %s %s", arg1, arg2, arg3);
                    Intent intent = new Intent();
                    AlertUtil.DebugLog(address);
                    intent.putExtra("RESULT", address);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });
        }
    }

    //툴바
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent();
                intent.putExtra("RESULT", " ");
                setResult(RESULT_OK, intent);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("RESULT", " ");
        setResult(RESULT_OK, intent);
        finish();
    }

}