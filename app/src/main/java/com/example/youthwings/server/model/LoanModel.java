package com.example.youthwings.server.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

// 서버로 보내고 받을 값. *JSON 형식으로 전달
public class LoanModel implements Serializable {
    @SerializedName("rental_id")
    private int loanId;

    @SerializedName("rental_req_date")
    private Date loanReqDate;

    @SerializedName("rental_receipt_date")
    private Date loanReceiptDate;

    @SerializedName("rental_return_date")
    private Date loanReturnDate;

    @SerializedName("rental_content")
    private String loanContent;

    @SerializedName("rental_status")
    private int loanStatus;

    @SerializedName("rental_system")
    private int loanSystem;

    @SerializedName("user")
    private UserModel userModel;

    @SerializedName("company")
    private CompanyModel companyModel;

    @SerializedName("company_id")
    private int companyId;

    @SerializedName("user_id")
    private String userId;

    public LoanModel() {
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public CompanyModel getCompanyModel() {
        return companyModel;
    }

    public void setCompanyModel(CompanyModel companyModel) {
        this.companyModel = companyModel;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public Date getLoanReqDate() {
        return loanReqDate;
    }

    public void setLoanReqDate(Date loanReqDate) {
        this.loanReqDate = loanReqDate;
    }

    public Date getLoanReceiptDate() {
        return loanReceiptDate;
    }

    public void setLoanReceiptDate(Date loanReceiptDate) {
        this.loanReceiptDate = loanReceiptDate;
    }

    public Date getLoanReturnDate() {
        return loanReturnDate;
    }

    public void setLoanReturnDate(Date loanReturnDate) {
        this.loanReturnDate = loanReturnDate;
    }

    public String getLoanContent() {
        return loanContent;
    }

    public void setLoanContent(String loanContent) {
        this.loanContent = loanContent;
    }

    public int getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(int loanStatus) {
        this.loanStatus = loanStatus;
    }

    public int getLoanSystem() {
        return loanSystem;
    }

    public void setLoanSystem(int loanSystem) {
        this.loanSystem = loanSystem;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

