package com.example.sailsandroid;


import android.location.LocationManager;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

@SuppressLint("JavascriptInterface")
public class MainActivity extends Activity {

	private WebView webView;
	public static String adress;
	public static String gps;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		webView = (WebView) findViewById(R.id.webView1);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.addJavascriptInterface(new JSInterface(this), "jsinterface");
		webView.loadUrl(this.adress);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}	
	public void on_click_back(View w){
		
        Intent intent4=new Intent(this, HomeActivity.class); 
        startActivity(intent4); 
        this.finish();   
	}
	

}
