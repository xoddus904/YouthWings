package com.example.youthwings.presenter;

import android.content.Context;

import com.example.youthwings.server.model.BoardModel;
import com.example.youthwings.server.model.CompanyModel;
import com.example.youthwings.server.model.LoanModel;

import java.util.ArrayList;

public interface LoanConstants {
    interface View {
        // 대여목록 조회 결과
        void onRequestResult(ArrayList<LoanModel> result);
    }

    interface Post {
        // 예약 결과
        void onRequestResult(boolean result);
    }

    interface List {
        // 지역별 정장대여점 목록
        void onRequestResult(ArrayList<CompanyModel> result);
    }

    interface Presenter {
        // ---------------------------------------------------
        // 예약하기
        // ---------------------------------------------------
        void onPostLoan(LoanModel loanModel);

        // ---------------------------------------------------
        // 예약목록 가져오기
        // ---------------------------------------------------
        void onGetLoanList(String userId);

        // ---------------------------------------------------
        // 정장대여점 가져오기
        // ---------------------------------------------------
        void onGetCompanyList(String state);
    }
}
