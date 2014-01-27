package com.rockwood.earsy.controller.activity;

import com.rockwood.earsy.R;
import com.rockwood.earsy.model.MusicNote;
import com.rockwood.earsy.model.PitchTest;
import com.rockwood.earsy.view.PianoView;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;


public class PitchTestActivity extends Activity {
    
    PitchTest test;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		test = new PitchTest();
		setContentView(R.layout.activity_pitch_test);
		// Get our TextView object.
		final TextView vw = (TextView)findViewById(R.id.textView1);
		vw.setText(test.getQuestionNumberInfo());	
		
		final View pianoView = findViewById(R.id.pianoView);
		pianoView.setOnTouchListener(new View.OnTouchListener() {
		    
		    @Override
		    public boolean onTouch(View v, MotionEvent event) {
			checkAnswer(((PianoView) v).getNoteTouched( event.getX(),event.getY()));
			return true;
		    }
		});			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pitch_test, menu);
		return true;
	}
	
	public void checkAnswer(MusicNote guessedNote)
	{
	    if(guessedNote!= null)
	    {
		
	    }
	}

}
