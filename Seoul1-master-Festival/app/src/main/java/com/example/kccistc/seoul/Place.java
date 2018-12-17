package com.example.kccistc.seoul;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

public class Place extends AppCompatActivity {

    private TabLayout tabLayout;
    private AutoScrollViewPager autoViewPager;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);

        tabLayout = findViewById(R.id.tab);

        viewPager = findViewById(R.id.viewpager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new Place_fragment1(),"고궁");
        adapter.AddFragment(new Place_fragment2(), "민속마을");
        adapter.AddFragment(new Place_fragment3(), "다리/대교");
        adapter.AddFragment(new Place_fragment4(), "테마공원");
        adapter.AddFragment(new Place_fragment5(), "이색거리");
        //adapter setup
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        ArrayList<String> data = new ArrayList<>(); //이미지 url를 저장하는 arraylist
        data.add("http://www.visitseoul.net/file_save/art_img/gallery/Bukchon_Samcheongdong_07.jpg");
        data.add("http://www.visitseoul.net/file_save/art_img/gallery/Hangang_Park_01.jpg");
        data.add("http://www.visitseoul.net/file_save/art_img/gallery/NSeoulTower_Namsan_Park_10.jpg");
        data.add("http://www.visitseoul.net/file_save/art_img/gallery/Eulalia_Festival_Haneul_Park_1.jpg");
        data.add("http://www.visitseoul.net/file_save/art_img/gallery/Cheonggyecheon_Stream_16.jpg");


        autoViewPager = findViewById(R.id.autoViewpager_place);
        AutoScrollAdapter_Food scrollAdapter_food = new AutoScrollAdapter_Food(this, data);
        autoViewPager.setAdapter(scrollAdapter_food); //Auto Viewpager에 Adapter 장착
        autoViewPager.setInterval(4000); // 페이지 넘어갈 시간 간격 설정
        autoViewPager.startAutoScroll(); //Auto Scroll 시작

//        viewPager.setAdapter(adapter);
//
        TabLayout tab = findViewById(R.id.tab);
//        //공간이 부족하면 스크롤 해서 넘어갈 수 있도록 해주는 기능
        tab.setTabMode(TabLayout.MODE_SCROLLABLE);
//
//        tabLayout.setupWithViewPager(viewPager);
    }
}