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


public class Place_ExampleAdapter extends RecyclerView.Adapter<Place_ExampleAdapter.ExampleViewHolder> {
    private Context mContext;
    private ArrayList<Place_ExampleItem> mExampleList;

    public Place_ExampleAdapter(Context context, ArrayList<Place_ExampleItem> exampleList) {
        mContext = context;
        mExampleList = exampleList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.place_example_item, parent, false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, final int position) {
        Place_ExampleItem currentItem = mExampleList.get(position);

        String imageUrl = currentItem.getImageUrl();
        String contentid = currentItem.getContentid();
        String creatorName = currentItem.getCreator();
        int likeCount = currentItem.getLikeCount();
        String address = currentItem.getAddress();
        double lat = currentItem.getLat();
        double lng = currentItem.getLng();

        holder.mTextViewCreator.setText(creatorName);
        holder.mTextViewLikes.setText("Likes: " + likeCount);
        holder.mTextViewAddress.setText(address);
        Picasso.with(mContext).load(imageUrl).fit().centerInside().into(holder.mImageView);

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailIntent = new Intent(mContext, Place_DetailActivity.class);
                Place_ExampleItem clickedItem = mExampleList.get(position);
                detailIntent.putExtra("url", clickedItem.getImageUrl());
                detailIntent.putExtra("creator", clickedItem.getCreator());
                detailIntent.putExtra("count", clickedItem.getLikeCount());
                detailIntent.putExtra("address", clickedItem.getAddress());
                detailIntent.putExtra("contentid", clickedItem.getContentid());
                detailIntent.putExtra("lat", clickedItem.getLat());
                detailIntent.putExtra("lng", clickedItem.getLng());


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
        public TextView mTextViewLikes;
        public TextView mTextViewAddress;
        public TextView mTextViewLat;
        public TextView mTextViewLng;
        public TextView mTextViewContentid;
        public View layout;

        public ExampleViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);
            mTextViewCreator = itemView.findViewById(R.id.text_view_creator);
            mTextViewLikes = itemView.findViewById(R.id.text_view_likes);
            mTextViewAddress = itemView.findViewById(R.id.text_view_address);

//            mTextViewLat = itemView.findViewById(R.id.text_view_lat);
//            mTextViewLat = itemView.findViewById(R.id.text_view_lng);


            layout = itemView;

        }
    }
}
