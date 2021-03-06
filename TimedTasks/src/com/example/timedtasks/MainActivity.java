package com.example.timedtasks;

import java.util.Calendar;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	TextView mClock;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mClock = new TextView(this);
		setContentView(mClock);
	}

	private Handler handler = new Handler();
	
	private Runnable task = new Runnable(){

		@Override
		public void run() {
			Calendar now = Calendar.getInstance();
			mClock.setText(String.format("%02d:%02d:%02d", 
					now.get(Calendar.HOUR),
					now.get(Calendar.MINUTE),
					now.get(Calendar.SECOND)));
			handler.postDelayed(task, 5000);
		}
	};
	
	@Override
	public void onResume(){
		super.onResume();
		handler.post(task);
	}
	
	@Override
	public void onPause(){
		super.onPause();
		handler.removeCallbacks(task);
	}

}
