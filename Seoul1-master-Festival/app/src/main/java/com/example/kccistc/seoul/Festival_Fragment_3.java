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

public class Festival_Fragment_3 extends Fragment {

    private RecyclerView mRecyclerView;
    private ExampleAdapter_Festival mExampleAdapter;
    private ArrayList<ExampleItem_Festival> mExampleList;
    private RequestQueue mRequestQueue;

    public Festival_Fragment_3() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.festival_fragment_1, null);

        mRecyclerView = v.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mExampleList = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(getActivity());
        parseJSON();


        return v;
    }


    private void parseJSON() {
        String url = "http://openapi.seoul.go.kr:8088/485a594245736c6f3432625a64736b/json/SearchConcertDetailService/1/500/";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            JSONObject search = response.getJSONObject("SearchConcertDetailService");
                            JSONArray row = search.getJSONArray("row");

                            String play = "전시/미술";

                            for (int i = 0; i < row.length(); i++) {

                                JSONObject gal = row.getJSONObject(i);

                                if (gal.getString("CODENAME").equals(play)) {
                                    String address = gal.getString("MAIN_IMG");
                                    String add = address.substring(26);
                                    String add1;
                                    String add2 = "HTTP://CULTURE.SEOUL.GO.KR";
                                    String add3 = address.substring(0, 26);
                                    String add4 = "http://culture.seoul.go.kr";

                                    if (add2.equals(add3)) {
                                        add1 = add4 + add;
                                    } else {
                                        add1 = address;
                                    }


                                    String creatorName = gal.getString("TITLE");
                                    String imageUrl = add1;
                                    String creatorPlace = gal.getString("PLACE");
                                    String period_st = gal.getString("STRTDATE");
                                    String period_end = gal.getString("END_DATE");
                                    String period = period_st + "~" + period_end;
                                    String time = gal.getString("TIME");
                                    String pay = gal.getString("USE_FEE");
                                    String inquiry = gal.getString("INQUIRY");
                                    String link = gal.getString("ORG_LINK");

                                    mExampleList.add(new ExampleItem_Festival(imageUrl, creatorName, creatorPlace, period, time, pay, inquiry, link));
                                }

                            }

                            mExampleAdapter = new ExampleAdapter_Festival(getActivity(), mExampleList);
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
