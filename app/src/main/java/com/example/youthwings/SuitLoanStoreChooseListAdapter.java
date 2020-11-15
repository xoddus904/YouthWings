package com.example.youthwings;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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
    private ArrayList<SuitLoanStoreChooseListViewItem> suitLoanStoreChooseListViewItems = new ArrayList<SuitLoanStoreChooseListViewItem>();

    // ListViewAdapter의 생성자
    public SuitLoanStoreChooseListAdapter(){
    }

    @Override
    public int getCount() {
        return suitLoanStoreChooseListViewItems.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

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

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        SuitLoanStoreChooseListViewItem suitLoanStoreChooseListViewItem = suitLoanStoreChooseListViewItems.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        storeImage.setImageDrawable(suitLoanStoreChooseListViewItem.getStoreimage());
        storeName.setText(suitLoanStoreChooseListViewItem.getStorename());
        address.setText(suitLoanStoreChooseListViewItem.getAddress());
        hours.setText(suitLoanStoreChooseListViewItem.getHours());
        lunchTime.setText(suitLoanStoreChooseListViewItem.getLunchtime());
        holiday.setText(suitLoanStoreChooseListViewItem.getHoliday());
        number.setText(suitLoanStoreChooseListViewItem.getNumber());

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return suitLoanStoreChooseListViewItems.get(position);
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(Drawable storeimage, String storename, String address, String hours, String lunchtime, String holiday, String number) {
        SuitLoanStoreChooseListViewItem item = new SuitLoanStoreChooseListViewItem();

        item.setStoreimage(storeimage);
        item.setStorename(storename);
        item.setAddress(address);
        item.setHours(hours);
        item.setLunchtime(lunchtime);
        item.setHoliday(holiday);
        item.setNumber(number);

        suitLoanStoreChooseListViewItems.add(item);
    }

}
