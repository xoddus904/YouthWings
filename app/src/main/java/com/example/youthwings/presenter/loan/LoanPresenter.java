package com.example.youthwings.presenter.loan;

import android.content.Context;

import com.example.youthwings.presenter.LoanConstants;
import com.example.youthwings.presenter.LoginConstants;
import com.example.youthwings.server.model.LoanModel;
import com.example.youthwings.service.LoanService;
import com.example.youthwings.service.UserService;

public class LoanPresenter implements LoanConstants.Presenter {
    LoanConstants.View view;
    LoanConstants.Post post;
    LoanConstants.List list;
    LoanService loanService;

    public LoanPresenter(LoanConstants.View view) {
        this.view = view;
        loanService = new LoanService(this, view);
    }

    public LoanPresenter(LoanConstants.Post post) {
        this.post = post;
        loanService = new LoanService(this, post);
    }

    public LoanPresenter(LoanConstants.List list) {
        this.list = list;
        loanService = new LoanService(this, list);
    }


    @Override
    public void onPostLoan(LoanModel loanModel) {
        loanService.onPostLoan(loanModel);
    }

    @Override
    public void onGetLoanList(String userId) {
        loanService.onGetLoanList(userId);
    }

    @Override
    public void onGetCompanyList(String state) {
        loanService.onGetCompanyList(state);
    }
}
