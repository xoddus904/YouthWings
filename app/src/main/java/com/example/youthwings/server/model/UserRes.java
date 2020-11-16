package com.example.youthwings.server.model;

import com.google.gson.annotations.SerializedName;

// 서버로부터 받을 값
public class UserRes {

    // 서버로 보낸 요청이 성공했는지 여부
    @SerializedName("suc")
    private boolean suc;

    @SerializedName("user")
    private UserModel userModel;

    @SerializedName("nickname")
    private String nickname;

    public boolean isSuc() {
        return suc;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public String getNickname() {
        return nickname;
    }
}