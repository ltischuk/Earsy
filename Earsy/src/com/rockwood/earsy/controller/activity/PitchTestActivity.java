package com.rockwood.earsy.controller.activity;

import android.app.Activity;
import android.app.DialogFragment;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.rockwood.earsy.R;
import com.rockwood.earsy.model.MusicNote;
import com.rockwood.earsy.model.PitchTest;
import com.rockwood.earsy.utils.Utils;
import com.rockwood.earsy.view.AnswerDialogFragment;
import com.rockwood.earsy.view.PianoView;

public class PitchTestActivity extends Activity
{

	private PitchTest test;
	private MediaPlayer mp;
	private TextView textViewQNum;
	private View pianoView;

	@Override
	protected void onCreate(final Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pitch_test);

		test = new PitchTest();
		mp = MediaPlayer.create(this,
				Utils.getMp3FromMusicNote(test.getNoteToPlay()));
		// Get our TextView object.
		textViewQNum = (TextView) findViewById(R.id.textViewQNum);
		textViewQNum.setText(test.getQuestionNumberInfo());

		final ImageButton playButton = (ImageButton) findViewById(R.id.playButton);
		playButton.setOnTouchListener(new View.OnTouchListener()
		{

			@Override
			public boolean onTouch(final View v, final MotionEvent event)
			{
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					mp.start();
				}
				return true;
			}
		});

		pianoView = findViewById(R.id.pianoView);
		pianoView.setOnTouchListener(new View.OnTouchListener()
		{

			@Override
			public boolean onTouch(final View v, final MotionEvent event)
			{
				if(event.getAction() == MotionEvent.ACTION_DOWN)
				{
					checkAnswer(((PianoView) v).getNoteTouched(event.getX(),
						event.getY()));
					return true;
				}
				
				return false;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(final Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pitch_test, menu);
		return true;
	}

	public void checkAnswer(final MusicNote guessedNote)
	{
		if (test.guessNote(guessedNote)) {
			showDialog();
		} else {
			Toast.makeText(getApplicationContext(), R.string.wrong_answer, Toast.LENGTH_SHORT).show();
		}
	}

	public void setNextQuestion()
	{
		test.incQuestionNum();
		textViewQNum.setText(test.getQuestionNumberInfo());
		mp.
	}
	
	void showDialog() {
	    DialogFragment newFragment = AnswerDialogFragment.newInstance(
	            R.string.result);
	    newFragment.show(getFragmentManager(), "dialog");
	}

	public void doPositiveClick() {
		setNextQuestion();
		((PianoView) pianoView).resetView();
	    
	}

	public void doNegativeClick() {
	    // Do stuff here.
	   
	}

	
}
