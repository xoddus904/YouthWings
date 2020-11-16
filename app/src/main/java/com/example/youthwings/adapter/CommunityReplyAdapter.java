package com.example.youthwings.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.example.youthwings.CommunityActivity2;
import com.example.youthwings.R;
import com.example.youthwings.presenter.CommunityConstants;
import com.example.youthwings.presenter.community.CommunityPresenter;
import com.example.youthwings.server.model.BoardModel;
import com.example.youthwings.server.model.ReplyModel;
import com.example.youthwings.util.AlertUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CommunityReplyAdapter extends BaseAdapter implements CommunityConstants.View {

    ArrayList<ReplyModel> replyModels;
    Context m_context;

    TextView replyContent_textView;     // 댓글 내용
    TextView replyTime_textView;        // 댓글 단 시간
    TextView replyName_textView;        // 댓글 단 사용자 닉네임
    Button replyDelete_Button;          // 삭제 버튼

    CommunityConstants.Presenter presenter;
    int boardId;

    public CommunityReplyAdapter(Context m_context, ArrayList<ReplyModel> replyModels, int boardId) {
        this.m_context = m_context;
        this.replyModels = replyModels;
        this.boardId = boardId;
    }

    @Override
    public int getCount() {
        return this.replyModels.size();
    }

    @Override
    public Object getItem(int position) {
        return this.replyModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");  // 날짜 형식 변환
            presenter = new CommunityPresenter(this);

            convertView = LayoutInflater.from(m_context).inflate(R.layout.community_reply_listview_item, null);

            replyContent_textView = convertView.findViewById(R.id.reply_content);
            replyContent_textView.setText(replyModels.get(position).getReplyContent());

            replyTime_textView = convertView.findViewById(R.id.reply_date);
            replyTime_textView.setText(format.format(replyModels.get(position).getReplyDate()));

            replyName_textView = convertView.findViewById(R.id.reply_name);
            replyName_textView.setText(replyModels.get(position).getUserModel().getNickName());

            replyDelete_Button = convertView.findViewById(R.id.reply_del_btn);
            replyDelete_Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onConfirmAlertDialog("해당 댓글을 삭제하시겠습니까?", replyModels.get(position).getReplyId());
                }
            });
        }

        return convertView;
    }

    // ***************************************
    // 확인, 취소 알림창
    // ***************************************
    private void onConfirmAlertDialog(String content, final int replyId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(m_context);
        builder.setTitle("청춘날개").setMessage(content);

        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
            }
        });

        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                presenter.onDeleteReply(replyId);
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public void onRequestResult(BoardModel result) {

    }

    @Override
    public void onRecommendResult(boolean result) {

    }

    @Override
    public void onReplyResult(boolean result) {
        if (result) {
            AlertUtil.onAlertDialog(m_context, "삭제되었습니다.");
            ((CommunityActivity2)m_context).presenter.onGetCommunity(boardId);
        }
    }
}
