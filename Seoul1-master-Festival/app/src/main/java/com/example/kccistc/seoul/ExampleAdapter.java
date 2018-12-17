package com.example.kccistc.seoul;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private Context mContext;
    private ArrayList<ExampleItem> mExampleList;

    public ExampleAdapter(Context context, ArrayList<ExampleItem> exampleList) {
        mContext = context;
        mExampleList = exampleList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.example_item, parent, false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, final int position) {
        ExampleItem currentItem = mExampleList.get(position);

        String imageUrl = currentItem.getmImageUrl();
        String creatorName = currentItem.getmCreator();
        String addres = currentItem.getmAddres();
        String info = currentItem.getmInfo();
        //String phone = currentItem.getmPhone();
        //String time = currentItem.getmTime();
        //String menu = currentItem.getmMenu();

        holder.mTextViewCreator.setText(creatorName);
        holder.mTextViewAddres.setText("주소 : " + addres);
        holder.mTextViewInfo.setText("간단설명 : " + info);
        //holder.mTextViewPhone.setText("전화번호 : " + phone);
        //holder.mTextViewTime.setText("영업시간 : " + time);
        //Picasso.with(mContext).load(menu).fit().centerInside().into(holder.mImageView1);
        Picasso.with(mContext).load(imageUrl).fit().centerInside().into(holder.mImageView);

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailIntent = new Intent(mContext, DetailActivity.class);
                ExampleItem clickedItem = mExampleList.get(position);
                detailIntent.putExtra("url", clickedItem.getmImageUrl());
                detailIntent.putExtra("creator", clickedItem.getmCreator());
                detailIntent.putExtra("addres", clickedItem.getmAddres());
                detailIntent.putExtra("info", clickedItem.getmInfo());
                detailIntent.putExtra("phone", clickedItem.getmPhone());
                detailIntent.putExtra("time", clickedItem.getmTime());
                detailIntent.putExtra("menu", clickedItem.getmMenu());
                detailIntent.putExtra("menu1", clickedItem.getmMenu1());
                detailIntent.putExtra("menu2", clickedItem.getmMenu2());
                mContext.startActivity(detailIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextViewCreator;
        public TextView mTextViewAddres;
        //public ImageView mImageView1;
       // public TextView mTextViewTime;
        public TextView mTextViewInfo;
       // public TextView mTextViewPhone;
        public View layout;

        public ExampleViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);
            mTextViewCreator = itemView.findViewById(R.id.text_view_creator);
            mTextViewAddres = itemView.findViewById(R.id.text_view_addres);
            mTextViewInfo = itemView.findViewById(R.id.text_view_info);
            layout = itemView;

        }
    }
}