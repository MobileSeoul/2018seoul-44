package com.example.kccistc.seoul;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

public class Festival extends AppCompatActivity {

    private TabLayout tabLayout;
    private AutoScrollViewPager autoViewPager;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_festival);

        tabLayout = findViewById(R.id.tab_festival);

        viewPager = findViewById(R.id.viewpager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new Festival_fragment_1(), "축제"+"\n"+"문화·예술");
        adapter.AddFragment(new Festival_Fragment_2(), "문화교양"+"\n"+"/강좌");
        adapter.AddFragment(new Festival_Fragment_3(), "전시/미술");
        adapter.AddFragment(new Festival_Fragment_4(), "클래식");
        adapter.AddFragment(new Festival_Fragment_5(), "기타");

        //adapter setup

        viewPager.setAdapter(adapter);

        TabLayout tab = findViewById(R.id.tab_festival);

        tabLayout.setupWithViewPager(viewPager);
        ArrayList<String> data = new ArrayList<>(); //이미지 url를 저장하는 arraylist
        data.add("http://www.breaknews.com/imgdata/breaknews_com/201804/2018043013465257.jpg");
        data.add("https://oojooblog.files.wordpress.com/2018/02/12.png");
        data.add("http://sharingfestival.kr/electron/images/w_visual.png");
        data.add("http://www.bloter.net/wp-content/uploads/2018/02/MWU-awards-korea.jpg");

        autoViewPager = findViewById(R.id.autoViewpager_festival);
        AutoScrollAdapter_Food scrollAdapter_food = new AutoScrollAdapter_Food(this, data);
        autoViewPager.setAdapter(scrollAdapter_food); //Auto Viewpager에 Adapter 장착
        autoViewPager.setInterval(4000); // 페이지 넘어갈 시간 간격 설정
        autoViewPager.startAutoScroll(); //Auto Scroll 시작
    }
}

