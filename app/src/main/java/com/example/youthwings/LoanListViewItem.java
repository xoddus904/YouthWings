package com.example.youthwings;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class LoanListViewItem  {

    private String storeName;
    private String receivingDate;
    private String returnDate;
    private String loanDetail;

    //대여목록 자세히
    public LoanListViewItem(String storeName, String receivingDate, String returnDate, String loanDetail) {
        this.storeName = storeName;
        this.receivingDate = receivingDate;
        this.returnDate = returnDate;
        this.loanDetail = loanDetail;
    }

    //내정보에서 간략하게 대여업체랑 반납날짜만 보여주는
   /* public LoanListViewItem(String storeName, String returnDate) {
        this.storeName = storeName;
        this.returnDate = returnDate;
    }*/

    public String getReceivingDate() {
        return receivingDate;
    }

    public void setReceivingDate(String receivingDate) {
        this.receivingDate = receivingDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getLoanDetail() {
        return loanDetail;
    }

    public void setLoanDetail(String loanDetail) {
        this.loanDetail = loanDetail;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

}