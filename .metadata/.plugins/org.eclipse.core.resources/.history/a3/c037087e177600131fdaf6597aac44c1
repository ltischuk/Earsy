package com.rockwood.earsy.view;

import com.rockwood.earsy.R;
import com.rockwood.earsy.model.PitchTest;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;


public class PitchTestActivity extends Activity {
    
    PitchTest test;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		test = new PitchTest();
		setContentView(R.layout.activity_pitch_test);
		// Get our TextView object.
		TextView vw = (TextView)findViewById(R.id.textView1);
		vw.setText(test.getQuestionNumberInfo());
		
			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pitch_test, menu);
		return true;
	}

}
