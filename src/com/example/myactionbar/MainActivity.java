package com.example.myactionbar;

import com.example.myactionbar.MyActionBar.MyActionbarClickListener;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		MyActionBar actionBar = (MyActionBar)findViewById(R.id.actionbar);
		actionBar.setOnMyActionbarClickListener(new MyActionbarClickListener() {
			
			public void leftClick() {
				Toast.makeText(MainActivity.this, "left button", Toast.LENGTH_SHORT).show();
			}
			
			public void rightClick() {
				Toast.makeText(MainActivity.this, "right button", Toast.LENGTH_SHORT).show();
			}						
		});
		
	}


}
