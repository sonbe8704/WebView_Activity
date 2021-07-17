 package com.example.webview_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

 public class MainActivity extends AppCompatActivity {
//웹뷰를 사용할때는 manifest에 가서 권한줘야함
    private WebView webView;
    private String url="https://www.naver.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView)findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
        webView.setWebChromeClient(new WebChromeClient());//크롬으로 실행하겠다.
        webView.setWebViewClient(new WebViewClientClass());
    }


     @Override
     public boolean onKeyDown(int keyCode, KeyEvent event) {
        //키들이 눌렸을 때
         if((keyCode==KeyEvent.KEYCODE_BACK)&&webView.canGoBack()){
             webView.goBack();
             return true;//??
         }
         return super.onKeyDown(keyCode, event);
     }

     private class WebViewClientClass extends WebViewClient {
         @Override
         public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            String url = request.getUrl().toString();
            view.loadUrl(url);
//버전오류가 난다면 가정문or gradle app에 가서 최소버전을 올려줄것
             return super.shouldOverrideUrlLoading(view, request);
         }
     }
 }