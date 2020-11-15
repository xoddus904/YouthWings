package com.example.youthwings.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.youthwings.R;
import com.example.youthwings.server.model.ReplyModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CommunityReplyAdapter extends BaseAdapter {

    ArrayList<ReplyModel> replyModels;
    Context m_context;

    TextView replyContent_textView;     // 댓글 내용
    TextView replyTime_textView;        // 댓글 단 시간
    TextView replyName_textView;        // 댓글 단 사용자 닉네임


    public CommunityReplyAdapter(Context m_context, ArrayList<ReplyModel> replyModels) {
        this.m_context = m_context;
        this.replyModels = replyModels;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");  // 날짜 형식 변환

            convertView = LayoutInflater.from(m_context).inflate(R.layout.community_reply_listview_item, null);

            replyContent_textView = convertView.findViewById(R.id.reply_content);
            replyContent_textView.setText(replyModels.get(position).getReplyContent());

            replyTime_textView = convertView.findViewById(R.id.reply_date);
            replyTime_textView.setText(format.format(replyModels.get(position).getReplyDate()));

            replyName_textView = convertView.findViewById(R.id.reply_name);
            // TODO: 닉네임 예정
            //replyContent_textView.setText(String.valueOf(replyModels.get(position).getCom_look()));

        }

        return convertView;
    }
}
