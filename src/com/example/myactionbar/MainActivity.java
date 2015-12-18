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
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "left button", Toast.LENGTH_SHORT).show();
			}
			
			public void rightClick() {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "right button", Toast.LENGTH_SHORT).show();
			}						
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
