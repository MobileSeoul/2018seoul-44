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
import android.widget.PopupWindow;

public class Historty_fragment2 extends Fragment {

    private View v;
    private String myurl = "https://www.discoverseoulpass.com/introduce";
    private WebView webView;

    public Historty_fragment2() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup vg, @Nullable Bundle bundle) {
        v = inflater.inflate(R.layout.history_fragment2, vg, false);

        webView = v.findViewById(R.id.webview_seoul_pass);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(myurl);

        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);

        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setSupportZoom(true);
//        Button btn = v.findViewById(R.id.btn);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                View popup = getLayoutInflater().inflate(R.layout.img_popup, null);
//                mPopupWindow = new PopupWindow(popup, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//                mPopupWindow.setFocusable(true);
//                mPopupWindow.showAtLocation(popup, Gravity.CENTER, 0,0);
//
//                Button cancel = popup.findViewById(R.id.cancel);
//                cancel.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        mPopupWindow.dismiss();
//                    }
//                });
//
//
//            }
//        });

        return v;
    }
}
