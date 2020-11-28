package com.example.youthwings.server.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

// 서버로부터 받을 값
public class LoanRes {
    // 서버로 보낸 요청이 성공했는지 여부
    @SerializedName("suc")
    private boolean suc;

    @SerializedName("rentalList")
    private ArrayList<LoanModel> loanModels;

    public boolean isSuc() {
        return suc;
    }

    public ArrayList<LoanModel> getLoanModels() {
        return loanModels;
    }
}