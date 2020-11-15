package com.example.youthwings.presenter.login;

import android.content.Context;
import android.util.Log;

import com.example.youthwings.presenter.LoginConstants;
import com.example.youthwings.service.UserService;

public class LoginPresenter implements LoginConstants.Presenter {
    LoginConstants.View loginView;
    UserService userService;

    public LoginPresenter(LoginConstants.View view) {
        loginView = view;
        userService = new UserService(this, loginView);
    }

    @Override
    public void onLogin(String id, String pwd, Context context) {
        userService.onLogin(id, pwd, context);
    }

    @Override
    public void onJoin(String id, String pwd, Context context) {
        userService.onJoin(id, pwd, context);
    }
}
