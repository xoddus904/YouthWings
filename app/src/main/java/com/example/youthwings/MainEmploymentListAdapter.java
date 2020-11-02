package com.example.youthwings;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

class MainEmploymentListAdapter extends BaseAdapter {

    TextView textView_classification;
    TextView textView_commutitle;
    TextView textView_mtime;

    Context context;
    ArrayList<MainEmploymentListViewItem> mainEmploymentListViewItem;

    public MainEmploymentListAdapter(Context context, ArrayList<MainEmploymentListViewItem> mainEmploymentListViewItem) {
        this.context = context;
        this.mainEmploymentListViewItem = mainEmploymentListViewItem;
    }

    //Adapter에 사용되는 데이터의 개수를 리턴
    @Override
    public int getCount(){
        return mainEmploymentListViewItem.size();
    }

    @Override
    public Object getItem(int position) {
        return this.mainEmploymentListViewItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.main_employment_list_item, null);

            textView_classification = (TextView)convertView.findViewById(R.id.classification);
            textView_classification.setText(mainEmploymentListViewItem.get(position).getClassification());

            textView_commutitle = (TextView)convertView.findViewById(R.id.commutitle);
            textView_commutitle.setText(mainEmploymentListViewItem.get(position).getCommutitle());

            textView_mtime = (TextView)convertView.findViewById(R.id.mtime);
            textView_mtime.setText(mainEmploymentListViewItem.get(position).getMtime());

        }
        return convertView;
    }


}
