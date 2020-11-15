package com.example.youthwings;

import android.graphics.drawable.Drawable;

class SuitLoanStoreChooseListViewItem {

    private Drawable storeimage;        //상점 사진
    private String storename;           //상점이름
    private String address;             //주소
    private String hours;               //영업시간
    private String lunchtime;           //점심시간
    private String holiday;             //휴일
    private String number;              //전화번호

    public void setStoreimage(Drawable storeimage) {
        this.storeimage = storeimage;
    }

    public Drawable getStoreimage() {
        return storeimage;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public String getStorename() {
        return storename;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setHours(String hours){
        this.hours = hours;
    }

    public String getHours(){
        return hours;
    }

    public void setLunchtime(String lunchtime){
        this.lunchtime = lunchtime;
    }

    public String getLunchtime(){
        return lunchtime;
    }

    public void setHoliday(String holiday){
        this.holiday = holiday;
    }

    public String getHoliday(){
        return holiday;
    }

    public void setNumber(String number){
        this.number = number;
    }

    public String getNumber(){
        return number;
    }

}
