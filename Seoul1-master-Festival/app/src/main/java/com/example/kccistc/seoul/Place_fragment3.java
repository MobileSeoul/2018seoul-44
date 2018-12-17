package com.example.kccistc.seoul;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

//fragment3 : 다리/대교  A02050100
public class Place_fragment3 extends Fragment {

    private RecyclerView mRecyclerView;
    private Place_ExampleAdapter mExampleAdapter;
    private ArrayList<Place_ExampleItem> mExampleList;
    private RequestQueue mRequestQueue;

    public Place_fragment3() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.place_fragment1, null);

        mRecyclerView = v.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mExampleList = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(getActivity());
        parseJSON();


        return v;
    }


    private void parseJSON() {
        String url = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?numOfRows=20&ServiceKey=wDDX3rgEb9dPsphDWqvjLp3UstanaN%2BDtGoSoCOiPgtfAi9JZF6zELCxRvbIp%2FjtVEN8CVgTIR0ANa5%2F41toAg%3D%3D&arrange=P&contentTypeid=12&areaCode=1&MobileOS=AND&cat1=A02&cat2=A0205&cat3=A02050100&MobileApp=AppTest&_type=json";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject responses) {   // json 반응 함수
                        try {

                            JSONObject response = responses.getJSONObject("response");
                            JSONObject body = response.getJSONObject("body");
                            JSONObject items = body.getJSONObject("items");
                            JSONArray jsonArray = items.getJSONArray("item");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject item = jsonArray.getJSONObject(i);
                                String imageUrl = item.getString("firstimage");
                                String contentid = item.getString("contentid"); // id 가져온 후 URL에 추가하여 description 불러올 수 있음
                                String creatorName = item.getString("title");
                                int likeCount = item.getInt("readcount");
                                String address = item.getString("addr1");
                                double lat = item.getDouble("mapx");
                                double lng = item.getDouble("mapy");



                                mExampleList.add(new Place_ExampleItem(imageUrl, contentid, creatorName, likeCount, address, lat, lng));

                            }

                            mExampleAdapter = new Place_ExampleAdapter(getActivity(), mExampleList);
                            mRecyclerView.setAdapter(mExampleAdapter);
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

        mRequestQueue.add(request);
    }


}

