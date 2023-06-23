package com.example.ejercicio_indiv_1_m_5;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;


import com.example.ejercicio_indiv_1_m_5.databinding.FragmentViewLinkBinding;


public class FragmentViewLink extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String urlActivity;
    public String mParam2;
    public FragmentViewLinkBinding binding;

    public FragmentViewLink() {
        // Required empty public constructor
    }
    public static FragmentViewLink newInstance(String urlActivity , String param2) {
        FragmentViewLink fragment = new FragmentViewLink();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, urlActivity);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            urlActivity = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentViewLinkBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        WebView webView = binding.webView1;
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        // configurar el webView
        webView.getSettings().setJavaScriptEnabled(true);
        // configurar un webbiewClien para cargar el contenido dentro del webVIew

        webView.setWebViewClient(new WebViewClient());
        // obtener la url
        String url = urlActivity.trim();
        String http = "https://";
        webView.loadUrl(http+url);

        Button btnVolver = binding.btnVolver;
        btnVolver.setOnClickListener(v -> requireActivity().onBackPressed());
        return  view;
    }
}
