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


public class ExampleAdapter_Festival extends RecyclerView.Adapter<ExampleAdapter_Festival.ExampleViewHolder> {
    private Context mContext;
    private ArrayList<ExampleItem_Festival> mExampleList;

    public ExampleAdapter_Festival(Context context, ArrayList<ExampleItem_Festival> exampleList) {
        mContext = context;
        mExampleList = exampleList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.example_item_festival, parent, false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, final int position) {
        ExampleItem_Festival currentItem = mExampleList.get(position);

        String imageUrl = currentItem.getImageUrl();
        String creatorName = currentItem.getCreator();
        String creatorPlace = currentItem.getPlace();

        holder.mTextViewCreator.setText(creatorName);
        holder.mTextViewPlace.setText(creatorPlace);

        Picasso.with(mContext).load(imageUrl).fit().centerInside().into(holder.mImageView);

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailIntent = new Intent(mContext, DetailActivity_Festival.class);
                ExampleItem_Festival clickedItem = mExampleList.get(position);
                detailIntent.putExtra("url", clickedItem.getImageUrl());
                detailIntent.putExtra("creator", clickedItem.getCreator());

                detailIntent.putExtra("place", clickedItem.getPlace());
                detailIntent.putExtra("period", clickedItem.getmPeriod());


                detailIntent.putExtra("time", clickedItem.getTime());
                detailIntent.putExtra("pay", clickedItem.getmPay());
                detailIntent.putExtra("inquiry", clickedItem.getmInqury());
                detailIntent.putExtra("link", clickedItem.getmLink());

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
        public TextView mTextViewPlace;
        public View layout;

        public ExampleViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);
            mTextViewCreator = itemView.findViewById(R.id.text_view_creator);
            mTextViewPlace = itemView.findViewById(R.id.text_view_likes);
            layout = itemView;
        }
    }
}