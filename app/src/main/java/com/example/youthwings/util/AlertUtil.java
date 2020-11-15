package com.example.youthwings.util;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

// =============================================================
// 알림창 유틸
// =============================================================
public class AlertUtil {

    // =============================================================
    // 확인만 있는 알림창
    // =============================================================
    public static void onAlertDialog(Context context, String content) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("청춘날개").setMessage(content);
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    // =============================================================
    // 토스트 메시지
    // =============================================================
    public static void onToastMessage(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    // =============================================================
    // 로그
    // =============================================================
    public static void DebugLog(String log) {
        Log.d("DEBUG", log);
    }
}
