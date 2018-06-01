package fr.livero.livero;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class Test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        WebView webView =(WebView) findViewById(R.id.webview);
        webView.loadUrl("file:///android_asset/www/home.html");


    }
}