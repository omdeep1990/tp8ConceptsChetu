package com.chetu.demotp8.javaConcepts.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.chetu.demotp8.databinding.ActivityWebViewBinding;

public class WebViewActivity extends AppCompatActivity {
    private ActivityWebViewBinding binding;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWebViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading, Please Wait....");
        progressDialog.show();
        binding.webView.loadUrl("https://developer.android.com/");
        binding.webView.setWebViewClient(new MyWebViewClient());

    }
    class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            if (request.getUrl().toString().contains(view.getUrl())) {

            } else {
                startActivity(new Intent(Intent.ACTION_VIEW, request.getUrl()));
            }
            return super.shouldOverrideUrlLoading(view, request);
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressDialog.dismiss();
        }
    }
}