package com.elation.demo;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.webkit.WebView;
import android.view.KeyEvent;

import com.elation.demo.ElationWebView;

public class ElationDemoActivity extends FragmentActivity
{
    ElationWebView webview;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Check if the key event was the Back button and if there's history
        if (webview == null) {
          webview = (ElationWebView) findViewById(R.id.content_webview);
        }
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webview != null && webview.canGoBack()) {
            webview.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }
}
