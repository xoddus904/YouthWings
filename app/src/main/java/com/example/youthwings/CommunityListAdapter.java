package com.example.youthwings;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.youthwings.CommunityListViewItem;
import com.example.youthwings.R;

import java.util.ArrayList;

public class CommunityListAdapter extends BaseAdapter {

    ArrayList<CommunityListViewItem> communityListViewItemArrayList;
    Context m_context;

    TextView comTitle_textView;
    TextView comTime_textView;
    TextView comLook_textView;
    TextView comRecommand_textView;

    public CommunityListAdapter(Context m_context, ArrayList<CommunityListViewItem> communityListViewItemArrayList) {
        this.m_context = m_context;
        this.communityListViewItemArrayList = communityListViewItemArrayList;
    }

    @Override
    public int getCount() {
        return this.communityListViewItemArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.communityListViewItemArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {

            convertView = LayoutInflater.from(m_context).inflate(R.layout.communitylistview_item, null);

            comTitle_textView = (TextView)convertView.findViewById(R.id.com_title);
            comTitle_textView.setText(communityListViewItemArrayList.get(position).getCom_Title());

            comTime_textView = (TextView)convertView.findViewById(R.id.com_time);
            comTime_textView.setText(communityListViewItemArrayList.get(position).getCom_time());

            comLook_textView = (TextView)convertView.findViewById(R.id.com_look);
            comLook_textView.setText(String.valueOf(communityListViewItemArrayList.get(position).getCom_look()));

            comRecommand_textView = (TextView)convertView.findViewById(R.id.com_recommend);
            comRecommand_textView.setText(String.valueOf(communityListViewItemArrayList.get(position).getCom_recommand()));
        }

        return convertView;
    }
}
