package com.rockwood.earsy.controller.activity;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
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
	private TextView textViewQNum;
	private View pianoView;

	@Override
	protected void onCreate(final Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pitch_test);

		test = new PitchTest();
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
					MediaPlayer player = MediaPlayer.create(v.getContext(),
							Utils.getMp3FromMusicNote(test.getNoteToPlay()));
					player.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
					{
						public void onCompletion(MediaPlayer mp)
						{
							mp.stop();
							mp.release();
						}
					});
					player.start();
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
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
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
			Toast.makeText(getApplicationContext(), R.string.wrong_answer,
					Toast.LENGTH_SHORT).show();
		}
	}

	/**
	 * Increment the question and change the text of the question number
	 */
	public void setNextQuestion()
	{
		test.incQuestionNum();
		textViewQNum.setText(test.getQuestionNumberInfo());
	}

	/**
	 * Show the dialog after answering a question
	 */
	void showDialog()
	{
		DialogFragment newFragment = AnswerDialogFragment
				.newInstance(R.string.result);
		newFragment.show(getFragmentManager(), "dialog");
	}

	public void doPositiveClick()
	{
		if (test.getCurrentQuestionNum() < PitchTest.TOTALNOTES) {
			setNextQuestion();
			((PianoView) pianoView).resetView();
		} else {
			startResultActivity();
		}
	}

	public void doNegativeClick()
	{
		// Do stuff here.

	}

	public PitchTest getCurrentTest()
	{
		return test;
	}

	public void startResultActivity()
	{
		Intent intent = new Intent(this, ResultsActivity.class);
		Bundle extras = new Bundle();
		extras.putInt(Utils.SCOREEXTRA, test.getScore());
		// add bundle to intent
		intent.putExtras(extras);
		startActivity(intent);

	}

}
