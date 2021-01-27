package com.molpay.molpaycimbwebview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView wv1, wv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        wv1=(WebView)findViewById(R.id.webView);
        wv2=(WebView)findViewById(R.id.webView2);
        wv2.setVisibility(View.GONE);
        
        //String url = "https://www.merchant.razer.com/seamless-demo-v3.16/index.html";
        //String url = "https://www.onlinepayment.com.my/MOLPay/pay/molpay/MB2U.php?amount=1.10&orderid=DEV_HAFEEZ_2243&currency=MYR&bill_name=MOLPay+Demo&bill_email=demo@molpay.com&bill_mobile=55218438&bill_desc=testing+by+MOLPay";
        String url = "https://www.onlinepayment.com.my/MOLPay/pay/molpay/CIMBCLICKS.php?amount=1.10&orderid=DEV_HAFEEZ_2243&currency=MYR&bill_name=MOLPay+Demo&bill_email=demo@molpay.com&bill_mobile=55218438&bill_desc=testing+by+MOLPay";
        wv1.getSettings().setJavaScriptEnabled(true);
        wv1.getSettings().setDomStorageEnabled(true);
        wv1.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        wv1.getSettings().setSupportMultipleWindows(true);
        wv2.getSettings().setJavaScriptEnabled(true);
        wv2.getSettings().setDomStorageEnabled(true);
        wv2.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        wv2.getSettings().setSupportMultipleWindows(true);
        wv1.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                wv2.loadUrl(url);
                wv2.setVisibility(View.VISIBLE);
                wv1.setVisibility(View.GONE);
                return true;
            }
        });
        wv2.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return true;
            }
        });
        wv1.loadUrl(url);
    }
}

