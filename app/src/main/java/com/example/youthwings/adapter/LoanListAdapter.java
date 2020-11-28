package com.example.youthwings.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.youthwings.R;
import com.example.youthwings.server.model.LoanModel;
import com.example.youthwings.util.AlertUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class LoanListAdapter extends BaseAdapter {

    TextView storeName_textView;
    TextView receivingDate_textView;
    TextView returnDate_textView;
    TextView loanDetail_textView;

    ViewGroup receivingDate_layout;
    ViewGroup loanDetail_layout;
    int pageDiv;

    Context context;
    ArrayList<LoanModel> loanModels;

    public LoanListAdapter(Context context, ArrayList<LoanModel> loanModels, int pageDiv) {
        this.context = context;
        this.loanModels = loanModels;
        this.pageDiv = pageDiv;
    }

    @Override
    public int getCount() {
        return this.loanModels.size();
    }

    @Override
    public Object getItem(int position) {
        return this.loanModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.loanlistview_item, null);
            SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm");  // 날짜 형식 변환

            storeName_textView = (TextView)convertView.findViewById(R.id.list_storename);
            storeName_textView.setText(loanModels.get(position).getCompanyModel().getCompanyName());

            receivingDate_textView = (TextView)convertView.findViewById(R.id.list_receivingdate);
            receivingDate_textView.setText(format.format(loanModels.get(position).getLoanReceiptDate()));

            returnDate_textView = (TextView)convertView.findViewById(R.id.list_returndate);
            returnDate_textView.setText(format.format(loanModels.get(position).getLoanReturnDate()));

            loanDetail_textView = (TextView)convertView.findViewById(R.id.list_loandetail);
            loanDetail_textView.setText(loanModels.get(position).getLoanContent());

            /*
            *** 마이페이지 표시 구분부
             */
            if(pageDiv == 0) {
                receivingDate_layout = convertView.findViewById(R.id.list_receivingdate_layout);
                loanDetail_layout = convertView.findViewById(R.id.list_loandetail_layout);
                receivingDate_layout.setVisibility(View.GONE);
                loanDetail_layout.setVisibility(View.GONE);
            }
        }

        return convertView;
    }
}
