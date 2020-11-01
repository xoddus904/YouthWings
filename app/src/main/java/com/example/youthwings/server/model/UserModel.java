package com.example.youthwings.server.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

// 서버로 보낼 값. *JSON 형식으로 전달
// {farm_pk: farmPk, egg_name: eggName ... }
public class UserModel implements Serializable {
    @SerializedName("user_id")
    private String loginId;

    @SerializedName("user_password")
    private String password;

    @SerializedName("user_name")
    private String name;

    @SerializedName("user_nickname")
    private String nickName;

    @SerializedName("user_email")
    private String email;

    @SerializedName("user_birthday")
    private Date birthday;

    @SerializedName("user_phone_number")
    private String phoneNumber;

    @SerializedName("user_refresh_token")
    private String refreshToken;

    @SerializedName("user_address")
    private String address;

    @SerializedName("user_address_detail")
    private String addressDetail;

    @SerializedName("user_register_token")
    private String firebaseToken;

    public UserModel() {
    }

    public UserModel(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }

    public UserModel(String loginId, String password, String nickName) {
        this.loginId = loginId;
        this.password = password;
        this.nickName = nickName;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getFirebaseToken() {
        return firebaseToken;
    }

    public void setFirebaseToken(String firebaseToken) {
        this.firebaseToken = firebaseToken;
    }
}

