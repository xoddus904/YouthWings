package com.example.youthwings.presenter;

import android.content.Context;

public interface LoginConstants {
    interface LoginView {
        void onRequestResult(boolean result);
    }

    interface JoinView {
        void onRequestResult(boolean result);

        void onNickNameResult(String result);
    }

    interface Presenter {
        // ---------------------------------------------------
        // 로그인
        // ---------------------------------------------------
        void onLogin(String id, String pwd, Context context);

        // ---------------------------------------------------
        // 회원가입
        // ---------------------------------------------------
        void onJoin(String id, String pwd, String nickname, Context context);

        // ---------------------------------------------------
        // 닉네임 생성
        // ---------------------------------------------------
        void onCreateNickName();

    }
}
