package com.example.youthwings.service;

import android.content.Context;
import android.util.Log;

import com.example.youthwings.presenter.LoginConstants;
import com.example.youthwings.server.RetrofitConnector;
import com.example.youthwings.server.ServiceApi;
import com.example.youthwings.server.model.UserModel;
import com.example.youthwings.server.model.UserRes;
import com.example.youthwings.util.SharedPreferenceUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UserService {
    LoginConstants.Presenter presenter;
    LoginConstants.View loginView;
    SharedPreferenceUtil sharedPreferenceUtil;

    public UserService(LoginConstants.Presenter presenter, LoginConstants.View view) {
        this.presenter = presenter;
        this.loginView = view;
    }

    // -----------------------------------------------------------------------
    // 로그인 함수 (서버 연동)
    // -----------------------------------------------------------------------
    public void onLogin(String userId, String userPwd, final Context context) {
        sharedPreferenceUtil = new SharedPreferenceUtil(context);
        Log.d("DEBUG", "################ 로그인 시작 ################");

        UserModel userModel = new UserModel(userId, userPwd);
        Retrofit retrofit = RetrofitConnector.createRetrofit();
        Call<UserRes> call = retrofit.create(ServiceApi.class).signIn(userModel);
        call.enqueue(new Callback<UserRes>() {
            @Override
            public void onResponse(Call<UserRes> call, Response<UserRes> response) {
                // 서버 연골 성공 시
                if (response.isSuccessful()) {
                    UserRes result = response.body();
                    // 성공적으로 데이터 가져왔을 시
                    if (result.isSuc()) {
                        Log.d("DEBUG", "########### 로그인 아이디 : " + result.getUserModel().getLoginId() + " ###########");

                        sharedPreferenceUtil.setSharedString("userId", result.getUserModel().getLoginId());     // 유저 아이디 세션(쉐어드프리퍼런스)에 저장.
                        loginView.onRequestResult(true);
                    } else {
                        loginView.onRequestResult(false);
                    }
                    Log.d("DEBUG", "################ 로그인 종료 ################");
                }
            }
            @Override
            public void onFailure(Call<UserRes> call, Throwable t) {
                Log.d("Server", "onFailure: " + t.toString());
            }
        });
    }

    // -----------------------------------------------------------------------
    // 회원가입 함수 (서버 연동)
    // -----------------------------------------------------------------------
    public void onJoin(String userId, String userPwd, Context context) {
        sharedPreferenceUtil = new SharedPreferenceUtil(context);
        Log.d("DEBUG", "################ 회원가입 시작 ################");

        UserModel userModel = new UserModel(userId, userPwd);
        Retrofit retrofit = RetrofitConnector.createRetrofit();
        Call<UserRes> call = retrofit.create(ServiceApi.class).signUp(userModel);
        call.enqueue(new Callback<UserRes>() {
            @Override
            public void onResponse(Call<UserRes> call, Response<UserRes> response) {
                // 서버 연골 성공 시
                if (response.isSuccessful()) {
                    UserRes result = response.body();
                    // 성공적으로 데이터 가져왔을 시
                    if (result.isSuc()) {
                        Log.d("DEBUG", "########### 회원가입 아이디 : " + result.getUserModel().getLoginId() + " ###########");
                        Log.d("DEBUG", result.getUserModel().getLoginId());

                        sharedPreferenceUtil.setSharedString("userId", result.getUserModel().getLoginId());     // 유저 아이디 세션(쉐어드프리퍼런스)에 저장.
                        loginView.onRequestResult(true);

                        Log.d("DEBUG", "################ 회원가입 종료 ################");
                    } else {
                        loginView.onRequestResult(false);
                    }
                }
            }

            @Override
            public void onFailure(Call<UserRes> call, Throwable t) {
                Log.d("Server", "onFailure: " + t.toString());
            }
        });
    }
}
