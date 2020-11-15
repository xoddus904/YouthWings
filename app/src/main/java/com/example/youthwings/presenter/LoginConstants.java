package com.example.youthwings.presenter;

import android.content.Context;

public interface LoginConstants {
    interface View {
        void onRequestResult(boolean result);
    }

    interface Presenter {
        // ---------------------------------------------------
        // 로그인
        // ---------------------------------------------------
        void onLogin(String id, String pwd, Context context);

        // ---------------------------------------------------
        // 회원가입
        // ---------------------------------------------------
        void onJoin(String id, String pwd, Context context);

    }
}
