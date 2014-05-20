package com.example.sailsandroid;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class HomeActivity extends Activity {

	private EditText ed1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		this.ed1= (EditText)findViewById(R.id.editText1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}
	
	public void on_click_start(View w){
		MainActivity.adress = this.ed1.getText().toString();
        Intent intent4=new Intent(this, MainActivity.class); 
        startActivity(intent4); 
        this.finish();   
	}

}
