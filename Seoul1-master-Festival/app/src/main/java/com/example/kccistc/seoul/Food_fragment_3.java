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

public class Food_fragment_3 extends Fragment {

    private RecyclerView mRecyclerView;
    private ExampleAdapter mExampleAdapter;
    private ArrayList<ExampleItem> mExampleList;
    private RequestQueue mRequestQueue;

    public Food_fragment_3() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.food_fragment_3, null);

        mRecyclerView = v.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mExampleList = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(getActivity());
        parseJSON();


        return v;
    }


    private void parseJSON() {
        String url = "http://primo4185.com/test2";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject responses) {   // json 반응 함수
                        try {

                            JSONArray jsonArray = responses.getJSONArray("mp");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject item = jsonArray.getJSONObject(i);

                                String creatorName = item.getString("text");
                                String imageUrl = item.getString("sURL");
                                String addres = item.getString("addr");
                                String info = item.getString("siminfo");
                                String phone = item.getString("phone");
                                String time = item.getString("time");
                                String menu = item.getString("menu");
                                String menu1 = item.getString("menu1");
                                String menu2 = item.getString("menu2");

                                mExampleList.add(new ExampleItem(imageUrl, creatorName, addres, info, phone, time, menu, menu1, menu2));

                            }

                            mExampleAdapter = new ExampleAdapter(getActivity(), mExampleList);
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

