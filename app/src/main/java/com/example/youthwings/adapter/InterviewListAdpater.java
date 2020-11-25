package com.example.youthwings.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.youthwings.R;

import java.util.ArrayList;

public class InterviewListAdpater extends BaseAdapter {

    TextView interviewTitle_textView;
    TextView interview_response_textView;

    Context context;
    ArrayList<InterviewListItem> interviewListItemArrayList;

    public InterviewListAdpater(Context context, ArrayList<InterviewListItem> interviewListItemArrayList) {
        this.context = context;
        this.interviewListItemArrayList = interviewListItemArrayList;
    }

    @Override
    public int getCount() {
        return this.interviewListItemArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.interviewListItemArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.interviewlist_item, null);

            interviewTitle_textView = (TextView)convertView.findViewById(R.id.interview_title);
            interviewTitle_textView.setText(interviewListItemArrayList.get(position).getInterviewTitle());

            interview_response_textView = (TextView)convertView.findViewById(R.id.interview_response);
            interview_response_textView.setText(String.valueOf(interviewListItemArrayList.get(position).getInterview_response()));

        }
        return convertView;
    }
}
