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

public class Historty_fragment1 extends Fragment {

    private View v;
    private String myurl = "https://www.discoverseoulpass.com/introduce";
    private WebView webView;

    public Historty_fragment1() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup vg, @Nullable Bundle bundle) {
        v = inflater.inflate(R.layout.history_fragment1, vg, false);

        return v;
    }
}
