package com.example.youthwings.presenter.login;

import android.content.Context;

import com.example.youthwings.presenter.LoginConstants;
import com.example.youthwings.service.UserService;

public class LoginPresenter implements LoginConstants.Presenter {
    LoginConstants.LoginView loginView;
    LoginConstants.JoinView joinView;
    UserService userService;

    public LoginPresenter(LoginConstants.LoginView view) {
        loginView = view;
        userService = new UserService(this, loginView);
    }

    public LoginPresenter(LoginConstants.JoinView view) {
        joinView = view;
        userService = new UserService(this, joinView);
    }

    @Override
    public void onLogin(String id, String pwd, Context context) {
        userService.onLogin(id, pwd, context);
    }

    @Override
    public void onJoin(String id, String pwd, String nickname, Context context) {
        userService.onJoin(id, pwd, nickname, context);
    }

    @Override
    public void onCreateNickName() {
        userService.onCreateNickName();
    }
}
