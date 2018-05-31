package com.example.alvin.alvin_midterm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.view.View;
import android.webkit.WebViewClient;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

  WebView webview;


 @Override
 protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     setTitle("Midterm Exam is fun!");
     Button button = (Button) findViewById(R.id.button);
     button.setText("START!");

     WebView myWebView = (WebView) findViewById(R.id.webview1);
     myWebView.setWebViewClient(new WebViewClient());
     myWebView.loadUrl("http://www.google.com");
    }
    public void startClick(View view){

        startActivity(new Intent(this, Screen2.class));
    }






}

