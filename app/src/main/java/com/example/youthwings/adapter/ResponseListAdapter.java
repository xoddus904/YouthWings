package com.example.youthwings.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.youthwings.R;

import java.util.ArrayList;

public class ResponseListAdapter extends BaseAdapter {

    TextView response_nickname_textView;
    TextView response_good_textView;
    TextView response_text_textView;

    Context context;
    ArrayList<ResponseListItem> responseListItemArrayList;

    public ResponseListAdapter(Context context, ArrayList<ResponseListItem> responseListItemArrayList) {
        this.context = context;
        this.responseListItemArrayList = responseListItemArrayList;
    }

    @Override
    public int getCount() {
        return responseListItemArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.responseListItemArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.responselistview_item, null);

            response_nickname_textView = (TextView)convertView.findViewById(R.id.response_nickname);
            response_nickname_textView.setText(responseListItemArrayList.get(position).getResponse_nickname());

            response_good_textView = (TextView)convertView.findViewById(R.id.response_good);
            response_good_textView.setText(String.valueOf(responseListItemArrayList.get(position).getResponse_good()));

            response_text_textView = (TextView)convertView.findViewById(R.id.response_text);
            response_text_textView.setText(responseListItemArrayList.get(position).getResponse_text());

        }
        return convertView;
    }
}
