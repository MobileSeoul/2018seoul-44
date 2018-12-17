package com.example.kccistc.seoul;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra("url");
        String creatorName = intent.getStringExtra("creator");
        String addres = intent.getStringExtra("addres");
        String info = intent.getStringExtra("info");
        String phone = intent.getStringExtra("phone");
        String time = intent.getStringExtra("time");
        String menu = intent.getStringExtra("menu");
        String menu1 = intent.getStringExtra("menu1");
        String menu2 = intent.getStringExtra("menu2");

        ImageView imageView = findViewById(R.id.image_view_detail);
        TextView textViewCreator = findViewById(R.id.text_view_creator_detail);
        TextView textViewAddres = findViewById(R.id.text_view_addres_detail);
        TextView textViewInfo = findViewById(R.id.text_view_info_detail);
        TextView textViewPhone = findViewById(R.id.text_view_phone_detail);
        TextView textViewTime = findViewById(R.id.text_view_time_detail);
        ImageView imageMenu = findViewById(R.id.image_view_menu_detail);
        ImageView imageMenu1 = findViewById(R.id.image_view_menu1_detail);
        ImageView imageMenu2 = findViewById(R.id.image_view_menu2_detail);

        Picasso.with(this).load(imageUrl).fit().centerInside().into(imageView);
        textViewCreator.setText("<"+ creatorName + ">");
        textViewInfo.setText("간단설명 : " + info);
        textViewAddres.setText("주소 : " + addres);
        textViewPhone.setText("전화번호 : " + phone);
        textViewTime.setText("영업시간 : " + time);
        Picasso.with(this).load(menu).fit().centerInside().into(imageMenu);
        Picasso.with(this).load(menu1).fit().centerInside().into(imageMenu1);
        Picasso.with(this).load(menu2).fit().centerInside().into(imageMenu2);

    }
}
