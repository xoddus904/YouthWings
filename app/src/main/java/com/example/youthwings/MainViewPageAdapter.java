package com.example.youthwings;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

public class MainViewPageAdapter extends PagerAdapter {

    private int[] images = {R.drawable.practice1, R.drawable.practice2, R.drawable.practice3};
    private LayoutInflater inflater;
    private Context context;

    public MainViewPageAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount(){
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object){
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.main_viewpage, container, false);
        ImageView imageView = (ImageView)v.findViewById((R.id.imageView));

        imageView.setImageResource((images[position]));

        container.addView(v);

        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        container.invalidate();
    }

}
