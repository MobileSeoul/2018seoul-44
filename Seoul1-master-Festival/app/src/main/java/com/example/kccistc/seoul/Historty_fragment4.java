package com.example.kccistc.seoul;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Historty_fragment4 extends Fragment {


    private View v;
    private String myurl = "http://data.seoul.go.kr/inter/ko/history/";
    private WebView webView;

    public Historty_fragment4() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup vg, @Nullable Bundle bundle) {
        v = inflater.inflate(R.layout.history_fragment4, vg, false);

        webView = v.findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(myurl);

        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);

        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setSupportZoom(true);

        return v;
    }
}
