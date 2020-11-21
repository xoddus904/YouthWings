package com.example.youthwings.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;

import com.example.youthwings.R;

import java.util.ArrayList;

public class MainViewPageAdapter extends PagerAdapter {
    private int[] images = {R.drawable.practice1, R.drawable.practice2, R.drawable.practice3};
    private LayoutInflater inflater;
    private Context context;

    ArrayList<String> data;

    public MainViewPageAdapter(Context context){
        this.context = context;
        //this.data = data;
    }

    @Override
    public int getCount(){
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object){
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){

        /*inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.main_viewpage, null);
        ImageView image_container = (ImageView)v.findViewById(R.id.imageView);
        Glide.with(context).load(data.get(position)).into(image_container);
        container.addView(v);
        return v;*/

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.main_viewpage, container, false);
        ImageView imageView = (ImageView)v.findViewById((R.id.viewPager_img));

        imageView.setImageResource((images[position]));

        container.addView(v);

        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        container.removeView((View)object);
        //container.invalidate();
    }

}
