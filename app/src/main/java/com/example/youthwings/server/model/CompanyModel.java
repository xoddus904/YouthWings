package com.example.youthwings.server.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

// 서버로 보내고 받을 값. *JSON 형식으로 전달
public class CompanyModel implements Serializable {
    @SerializedName("company_id")
    private int companyId;

    @SerializedName("company_image_url")
    private String companyImageUrl;

    @SerializedName("company_name")
    private String companyName;

    @SerializedName("company_content")
    private String companyContent;

    @SerializedName("company_address")
    private String companyAddress;

    @SerializedName("company_date")
    private Date companyDate;

    @SerializedName("company_region")
    private String companyRegion;

    @SerializedName("user")
    private UserModel userModel;

    public CompanyModel() {
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyImageUrl() {
        return companyImageUrl;
    }

    public void setCompanyImageUrl(String companyImageUrl) {
        this.companyImageUrl = companyImageUrl;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyContent() {
        return companyContent;
    }

    public void setCompanyContent(String companyContent) {
        this.companyContent = companyContent;
    }

    public Date getCompanyDate() {
        return companyDate;
    }

    public void setCompanyDate(Date companyDate) {
        this.companyDate = companyDate;
    }

    public String getCompanyRegion() {
        return companyRegion;
    }

    public void setCompanyRegion(String companyRegion) {
        this.companyRegion = companyRegion;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }
}

