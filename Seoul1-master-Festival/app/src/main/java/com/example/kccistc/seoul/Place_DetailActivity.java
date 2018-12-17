package com.example.kccistc.seoul;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;

import java.util.ArrayList;


public class Place_DetailActivity extends AppCompatActivity {
    private Place_ExampleAdapter mExampleAdapter;
    private ArrayList<Place_ExampleItem> mExampleList;
    private RequestQueue mRequestQueue;
    private String contentid;
    private String overview;

    TextView textViewOverview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_activity_detail);

        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra("url");
        String creatorName = intent.getStringExtra("creator");
        int likeCount = intent.getIntExtra("count", 0);
        String address = intent.getStringExtra("address");
        double lat = intent.getDoubleExtra("lat", 37.588227);
        double lng = intent.getDoubleExtra("lng", 126.993606);
        contentid = intent.getStringExtra("contentid");
//        overview = intent.getStringExtra("overview");


        ImageView imageView = findViewById(R.id.image_view_detail);
        TextView textViewCreator = findViewById(R.id.text_view_creator_detail);
        TextView textViewLikes = findViewById(R.id.text_view_like_detail);
        TextView textViewAddress = findViewById(R.id.text_view_address_detail);
        textViewOverview = findViewById(R.id.text_view_overview_detail);


        Picasso.with(this).load(imageUrl).fit().centerInside().into(imageView);
        textViewCreator.setText(creatorName);
        textViewLikes.setText("Likes : " + likeCount);
        textViewAddress.setText(address);
        textViewOverview.setText(overview);

        mRequestQueue = Volley.newRequestQueue(this);
        parseJSON();

    }

    private void parseJSON() {
        String url = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon?serviceKey=wDDX3rgEb9dPsphDWqvjLp3UstanaN%2BDtGoSoCOiPgtfAi9JZF6zELCxRvbIp%2FjtVEN8CVgTIR0ANa5%2F41toAg%3D%3D&numOfRows=100&contentId=" + contentid + "&contentTypeId=12&firstImageYN=Y&defaultYN=Y&addrinfoYN=Y&mapinfoYN=Y&overviewYN=Y&MobileOS=AND&MobileApp=AppTest&_type=json";

//        Log.e("contentid", contentid + "");
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject responses) {   // json 반응 함수

                        Log.e("json", "start");
                        try {
                            JSONObject response = responses.getJSONObject("response");
                            JSONObject body = response.getJSONObject("body");
                            JSONObject items = body.getJSONObject("items");
                            JSONObject item = items.getJSONObject("item");

                            overview = Jsoup.parse(item.getString("overview")).text();

//                            overview = item.getString("overview");
                            //overview를 위에서도 사용하기 위해 전역변수로 바꿈
//                                String overview = item.getString("overview");
                            Log.e("json", overview + "");

                            textViewOverview.setText(overview);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
//
        mRequestQueue.add(request);
    }
}