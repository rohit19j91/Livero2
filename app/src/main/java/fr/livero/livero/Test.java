package fr.livero.livero;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Test extends AppCompatActivity {

    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        webView =(WebView) findViewById(R.id.webview);
        webView.loadUrl("file:///android_asset/www/home.html");
        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        }

        @Override
        public boolean onKeyDown(int keyCode, KeyEvent event) {
            // Check if the key event was the Back button and if there's history
            if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
                webView.goBack();
                return true;
            }
            // If it wasn't the Back key or there's no web page history, bubble up to the default
            // system behavior (probably exit the activity)
            return super.onKeyDown(keyCode, event);
        }
    }