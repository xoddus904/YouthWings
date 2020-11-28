package com.example.youthwings;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.youthwings.server.model.CompanyModel;

import java.util.ArrayList;

class SuitLoanStoreChooseListAdapter extends BaseAdapter {

    ImageView storeImage;
    TextView storeName;
    TextView address;
    TextView hours;
    TextView lunchTime;
    TextView holiday;
    TextView number;

    Context context;

    //Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<CompanyModel> companyModels = new ArrayList<CompanyModel>();

    // ListViewAdapter의 생성자
    public SuitLoanStoreChooseListAdapter(Context context, ArrayList<CompanyModel> companyModels){
        this.context = context;
        this.companyModels = companyModels;
    }

    @Override
    public int getCount() {
        return companyModels.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // item layout을 inflate하여 convertView 참조 획득.
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.suit_loan_store_choose_item, parent, false);
        }

        // 화면에 표시될 View로부터 위젯에 대한 참조 획득
        storeImage = (ImageView)convertView.findViewById(R.id.storeimage);
        storeName = (TextView)convertView.findViewById(R.id.storeName_get);
        address = (TextView)convertView.findViewById(R.id.address_get);
        hours = (TextView)convertView.findViewById(R.id.hours_get);
        lunchTime = (TextView)convertView.findViewById(R.id.lunchTime_get);
        holiday = (TextView)convertView.findViewById(R.id.holiday_get);
        number = (TextView)convertView.findViewById(R.id.number_get);

        // 아이템 내 각 위젯에 데이터 반영
        storeImage.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.opencloset_logo));
        storeName.setText(companyModels.get(position).getCompanyName());
        address.setText(companyModels.get(position).getCompanyAddress());
        hours.setText("09:00 ~ 18:00");
        lunchTime.setText("12:00 ~ 13:00");
        holiday.setText("매 주 월요일 휴무");
        number.setText("02 - 000 - 0000");

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return companyModels.get(position);
    }
}
