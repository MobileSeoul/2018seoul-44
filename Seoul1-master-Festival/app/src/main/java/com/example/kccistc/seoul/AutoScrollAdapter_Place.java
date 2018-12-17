package com.example.kccistc.seoul;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AutoScrollAdapter_Place extends PagerAdapter{

    Context context;
    ArrayList<String> data;
    View v;

    public AutoScrollAdapter_Place(Context context, ArrayList<String>data){
        this.context = context;
        this.data = data;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.auto_viewpager_place, null);
        ImageView image_contaier = v.findViewById(R.id.image_container);
        Glide.with(context).load(data.get(position)).into(image_contaier);
        container.addView(v);

        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
