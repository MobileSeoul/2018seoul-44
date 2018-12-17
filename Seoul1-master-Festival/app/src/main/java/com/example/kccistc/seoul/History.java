package com.example.kccistc.seoul;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class History extends AppCompatActivity {

    private TabLayout tabLayout;
    //private AppBarLayout appBarLayout;
    private ViewPager viewPager;
    private AutoScrollViewPager autoViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        tabLayout = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewpager);
        //appBarLayout = findViewById(R.id.appbar);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.AddFragment(new Historty_fragment1(), "시티투어 버스");
        adapter.AddFragment(new Historty_fragment2(), "서울 패스");
        adapter.AddFragment(new Historty_fragment3(), "추천 코스");
        adapter.AddFragment(new Historty_fragment4(), "통계로 보는 서울");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


        ArrayList<String> data = new ArrayList<>(); //이미지 url를 저장하는 arraylist
        data.add("https://cdn.pixabay.com/photo/2016/02/22/08/29/scenery-1214950_960_720.jpg");
        data.add("https://cdn.pixabay.com/photo/2017/10/01/13/35/bridge-2805540_960_720.jpg");
        data.add("https://cdn.pixabay.com/photo/2015/12/10/01/55/night-1085846_960_720.jpg");
        data.add("https://cdn.pixabay.com/photo/2015/01/14/15/44/south-korea-599206_960_720.jpg");


        autoViewPager = findViewById(R.id.autoViewpager);
        AutoScrollAdapter scrollAdapter = new AutoScrollAdapter(this, data);
        autoViewPager.setAdapter(scrollAdapter); //Auto Viewpager에 Adapter 장착
        autoViewPager.setInterval(4000); // 페이지 넘어갈 시간 간격 설정
        autoViewPager.startAutoScroll(); //Auto Scroll 시작

    }

//    public class MyTimerTask extends TimerTask{
//
//        @Override
//        public void run(){
//
//            History.this.runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//
//                    if(viewPager.getCurrentItem() == 0){
//                        viewPager.setCurrentItem(1);
//                    }else if(viewPager.getCurrentItem() == 1){
//                        viewPager.setCurrentItem(2);
//                    }else {
//                        viewPager.setCurrentItem(0);
//                    }
//                }
//            });
//        }
//    }
}
