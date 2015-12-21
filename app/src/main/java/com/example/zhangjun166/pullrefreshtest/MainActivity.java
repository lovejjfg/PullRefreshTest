package com.example.zhangjun166.pullrefreshtest;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshWebView;

public class MainActivity extends AppCompatActivity {

    private PullToRefreshWebView mWV;
    private WebView mWebView;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWV = (PullToRefreshWebView) findViewById(R.id.wv);

        mWebView = mWV.getRefreshableView();

        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new SampleWebViewClient());
        mWebView.loadUrl("http://www.google.com");

        ILoadingLayout loadingLayoutProxy = mWV.getLoadingLayoutProxy();
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(R.drawable.loading);
        Drawable background = imageView.getBackground();

        loadingLayoutProxy.setLoadingDrawable((background));

    }

    private class SampleWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

    }
}
