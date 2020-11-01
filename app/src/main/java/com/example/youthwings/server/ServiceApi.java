package com.example.youthwings.server;

import com.example.youthwings.server.model.UserModel;
import com.example.youthwings.server.model.UserRes;

import java.util.HashMap;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServiceApi {

    // 로그인
    @POST("/account/login")
    Call<UserRes> signIn(@Body UserModel userModel);

    // 회원 가입
    @POST("/account")
    Call<UserRes> signUp(@Body UserModel userModel);

}