package com.rockwood.earsy.controller.activity;

import com.rockwood.earsy.R;
import com.rockwood.earsy.model.MusicNote;
import com.rockwood.earsy.model.PitchTest;
import com.rockwood.earsy.utils.Utils;
import com.rockwood.earsy.view.PianoView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class PitchTestActivity extends Activity {
    
    private PitchTest test;
    private MediaPlayer mp;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		test = new PitchTest();
		 mp = MediaPlayer.create(this, Utils.getMp3FromMusicNote(test.getNoteToPlay()));
		setContentView(R.layout.activity_pitch_test);
		// Get our TextView object.
		final TextView vw = (TextView)findViewById(R.id.textView1);
		vw.setText(test.getQuestionNumberInfo());	
		
		final Button playButton = (Button) findViewById(R.id.playButton);
		playButton.setOnTouchListener(new View.OnTouchListener() {
		    
		    @Override
		    public boolean onTouch(View v, MotionEvent event) {
			 mp.start();
			return true;
		    }
		});
		
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
	    test.guessNote(guessedNote);
	}


}
