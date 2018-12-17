package com.example.kccistc.seoul;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class DetailActivity_Festival extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_festival);

        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra("url");
        String creatorName = intent.getStringExtra("creator");
        String creatorPlace = intent.getStringExtra("place");
        String creatorPeriod = intent.getStringExtra("period");
        String creatorTime = intent.getStringExtra("time");
        String creatorPay = intent.getStringExtra("pay");
        String creatorInquiry = intent.getStringExtra("inquiry");
        String creatorLink = intent.getStringExtra("link");

        ImageView imageView = findViewById(R.id.image_view_detail);
        TextView textViewCreator = findViewById(R.id.text_view_creator_detail);
        TextView textViewplace = findViewById(R.id.place_detail);
        TextView textViewPeriod = findViewById(R.id.period_detail);
        TextView textViewTime = findViewById(R.id.time_detail);
        TextView textViewPay = findViewById(R.id.pay_detail);
        TextView textViewInquiry = findViewById(R.id.inquiry_detail);
        TextView textViewLink = findViewById(R.id.link_detail);

        Picasso.with(this).load(imageUrl).fit().centerInside().into(imageView);
        textViewCreator.setText(creatorName);
        textViewplace.setText(creatorPlace);
        textViewPeriod.setText(creatorPeriod);
        textViewTime.setText(creatorTime);
        textViewPay.setText(creatorPay);
        textViewInquiry.setText(creatorInquiry);
        textViewLink.setText(creatorLink);

    }

}
