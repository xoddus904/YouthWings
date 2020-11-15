package com.example.youthwings.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.youthwings.R;
import com.example.youthwings.server.model.BoardModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CommunityListAdapter extends BaseAdapter {

    ArrayList<BoardModel> boardModels;
    Context m_context;

    TextView comTitle_textView;
    TextView comTime_textView;
    TextView comLook_textView;
    TextView comRecommend_textView;

    public CommunityListAdapter(Context m_context, ArrayList<BoardModel> boardModels) {
        this.m_context = m_context;
        this.boardModels = boardModels;
    }

    @Override
    public int getCount() {
        return this.boardModels.size();
    }

    @Override
    public Object getItem(int position) {
        return this.boardModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");  // 날짜 형식 변환

            convertView = LayoutInflater.from(m_context).inflate(R.layout.community_listview_item, null);

            comTitle_textView = (TextView)convertView.findViewById(R.id.com_title);
            comTitle_textView.setText(boardModels.get(position).getBoardTitle());

            comTime_textView = (TextView)convertView.findViewById(R.id.com_time);
            comTime_textView.setText(format.format(boardModels.get(position).getBoardDate()));

            comLook_textView = (TextView)convertView.findViewById(R.id.com_look);
            comLook_textView.setText(String.valueOf(boardModels.get(position).getBoardLook()));

            comRecommend_textView = (TextView)convertView.findViewById(R.id.com_recommend);
            comRecommend_textView.setText(String.valueOf(boardModels.get(position).getLikeModels().size()));
        }

        return convertView;
    }
}
