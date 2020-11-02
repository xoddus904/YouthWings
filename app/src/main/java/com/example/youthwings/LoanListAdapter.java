package com.example.youthwings;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class LoanListAdapter extends BaseAdapter {

    TextView storeName_textView;
    TextView receivingDate_textView;
    TextView returnDate_textView;
    TextView loanDetail_textView;

    Context context;
    ArrayList<LoanListViewItem> loanListViewItemArrayList;

    public LoanListAdapter(Context context, ArrayList<LoanListViewItem> loanListViewItemArrayList) {
        this.context = context;
        this.loanListViewItemArrayList = loanListViewItemArrayList;
    }

    @Override
    public int getCount() {
        return this.loanListViewItemArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.loanListViewItemArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.loanlistview_item, null);

            storeName_textView = (TextView)convertView.findViewById(R.id.list_storename);
            storeName_textView.setText(loanListViewItemArrayList.get(position).getStoreName());

            receivingDate_textView = (TextView)convertView.findViewById(R.id.list_receivingdate);
            receivingDate_textView.setText(loanListViewItemArrayList.get(position).getReceivingDate());

            returnDate_textView = (TextView)convertView.findViewById(R.id.list_returndate);
            returnDate_textView.setText(loanListViewItemArrayList.get(position).getReturnDate());

            loanDetail_textView = (TextView)convertView.findViewById(R.id.list_loandetail);
            loanDetail_textView.setText(loanListViewItemArrayList.get(position).getLoanDetail());

        }

        return convertView;
    }
}
