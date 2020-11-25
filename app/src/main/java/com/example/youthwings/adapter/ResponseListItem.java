package com.example.youthwings.adapter;

import android.graphics.drawable.Drawable;

public class ResponseListItem {

    private String response_nickname;
    private int response_good;
    private String response_text;

    public ResponseListItem(String response_nickname, int response_good, String response_text) {
        this.response_nickname = response_nickname;
        this.response_good = response_good;
        this.response_text = response_text;
    }

    public String getResponse_nickname() {
        return response_nickname;
    }

    public void setResponse_nickname(String response_nickname) {
        this.response_nickname = response_nickname;
    }

    public int getResponse_good() {
        return response_good;
    }

    public void setResponse_good(int response_good) {
        this.response_good = response_good;
    }

    public String getResponse_text() {
        return response_text;
    }

    public void setResponse_text(String response_text) {
        this.response_text = response_text;
    }

}
