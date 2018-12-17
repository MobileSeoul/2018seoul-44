package com.example.kccistc.seoul;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

public class Food extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private AutoScrollViewPager autoViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        tabLayout = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewpager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new Food_fragment_1(), "강남 맛집");
        adapter.AddFragment(new Food_fragment_2(), "종로 맛집");
        adapter.AddFragment(new Food_fragment_3(), "홍대,신촌 맛집");

        //adapter setup

        viewPager.setAdapter(adapter);

        TabLayout tab = findViewById(R.id.tab);
        //공간이 부족하면 스크롤 해서 넘어갈 수 있도록 해주는 기능
        //tab.setTabMode(TabLayout.MODE_SCROLLABLE);

        tabLayout.setupWithViewPager(viewPager);

        ArrayList<String> data = new ArrayList<>(); //이미지 url를 저장하는 arraylist
        data.add("http://post.phinf.naver.net/MjAxNzA0MDVfMTM0/MDAxNDkxMzQ2OTIxMjI0.8kBdBKdkoogP8FbMLbrAdsVErT7Sfme_Nz3FMOdf-rYg.45MUak0P8-cCuvDNa7EScsaN_FlPoij_loqjzUQi7Dcg.JPEG/IznUOAJ7huVCm7tpzYdXW-u4KCkQ.jpg");
        data.add("http://blogfiles.naver.net/MjAxODAyMTlfMTc2/MDAxNTE5MDM0NjAyNTEx.5GTb7x6hA1DIoos_8MabGLrhUKKmg7hBIO9zG7b7W7Qg.sRbUoPMX2TkqXzFpeDn9OfpVQ4v3COaJ62MgrqVa7e8g.JPEG.dmsgur9122/2018%B3%E2_02%BF%F9_19%C0%CF_%B0%AD%B3%B2_%BB%E7%C4%ED%B6%F3%C5%D7%C0%CC%BF%A3_04.JPG");
        data.add("http://blogfiles.naver.net/MjAxNzAzMjlfMjYz/MDAxNDkwNzcwMDgxMDMz._WllcDEeiLnuM6Q4NEUsrpfJzx2GvHuLt_edP0PjxP8g.ILz-oOquKYqngQDYCBGtNauhMwCi1hj096dCpzEkSJwg.JPEG.hjinnyk71/%B1%A4%C8%AD%B9%AE%BF%AA%B8%C0%C1%FD_%BA%F1%BD%BA%C6%AE%B7%CE%BC%AD%BF%EF__%2815%29.JPG");
        data.add("http://ldb.phinf.naver.net/20170623_230/1498197960253YPUzo_JPEG/186573553579669_4.jpeg");
        data.add("http://blogfiles.naver.net/20160406_144/liring113_1459869251412TefVf_JPEG/%B1%A4%C8%AD%B9%AE_%BC%FA%C1%FD.jpg");


        autoViewPager = findViewById(R.id.autoViewpager_food);
        AutoScrollAdapter_Food scrollAdapter_food = new AutoScrollAdapter_Food(this, data);
        autoViewPager.setAdapter(scrollAdapter_food); //Auto Viewpager에 Adapter 장착
        autoViewPager.setInterval(4000); // 페이지 넘어갈 시간 간격 설정
        autoViewPager.startAutoScroll(); //Auto Scroll 시작

    }
}

