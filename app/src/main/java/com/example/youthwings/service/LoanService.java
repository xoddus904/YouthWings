package com.example.youthwings.service;

import android.util.Log;

import com.example.youthwings.presenter.LoanConstants;
import com.example.youthwings.server.RetrofitConnector;
import com.example.youthwings.server.ServiceApi;
import com.example.youthwings.server.model.LoanModel;
import com.example.youthwings.server.model.LoanRes;
import com.example.youthwings.util.SharedPreferenceUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoanService {
    LoanConstants.Presenter presenter;
    LoanConstants.View view;
    LoanConstants.Post post;
    SharedPreferenceUtil sharedPreferenceUtil;

    public LoanService(LoanConstants.Presenter presenter, LoanConstants.View view) {
        this.presenter = presenter;
        this.view = view;
    }

    public LoanService(LoanConstants.Presenter presenter, LoanConstants.Post post) {
        this.presenter = presenter;
        this.post = post;
    }

    // -----------------------------------------------------------------------
    // 에약목록 가져오기 (서버 연동)
    // -----------------------------------------------------------------------
    public void onGetLoanList(String userId) {
        Log.d("DEBUG", "################ 예약목록 시작 ################");

        Retrofit retrofit = RetrofitConnector.createRetrofit();
        Call<LoanRes> call = retrofit.create(ServiceApi.class).getLoanList(userId);
        call.enqueue(new Callback<LoanRes>() {
            @Override
            public void onResponse(Call<LoanRes> call, Response<LoanRes> response) {
                if (response.isSuccessful()) {
                    LoanRes result = response.body();
                    view.onRequestResult(result.getLoanModels());
                    Log.d("DEBUG", "################ 예약목록 종료 ################");
                }
            }

            @Override
            public void onFailure(Call<LoanRes> call, Throwable t) {
                Log.d("Server", "onFailure: " + t.toString());
            }
        });
    }

    // -----------------------------------------------------------------------
    // 에약 하기 (서버 연동)
    // -----------------------------------------------------------------------
    public void onPostLoan(LoanModel loanModel) {
        Log.d("DEBUG", "################ 예약 시작 ################");

        Retrofit retrofit = RetrofitConnector.createRetrofit();
        Call<LoanRes> call = retrofit.create(ServiceApi.class).postLoan(loanModel);
        call.enqueue(new Callback<LoanRes>() {
            @Override
            public void onResponse(Call<LoanRes> call, Response<LoanRes> response) {
                if (response.isSuccessful()) {
                    LoanRes result = response.body();
                    post.onRequestResult(result.isSuc());
                    Log.d("DEBUG", "################ 예약 종료 ################");
                }
            }

            @Override
            public void onFailure(Call<LoanRes> call, Throwable t) {
                Log.d("Server", "onFailure: " + t.toString());
            }
        });
    }
}
