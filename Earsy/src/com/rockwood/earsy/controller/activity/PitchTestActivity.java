package com.rockwood.earsy.controller.activity;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.rockwood.earsy.R;
import com.rockwood.earsy.model.MusicNote;
import com.rockwood.earsy.model.PitchTest;
import com.rockwood.earsy.utils.Utils;
import com.rockwood.earsy.view.PianoView;

public class PitchTestActivity extends Activity
{

	private PitchTest test;
	private TextView textViewQNum;
	private View pianoView;
	private boolean unlimitedGuessAttempts;
	private boolean playKeyOnGuess = false;
	private boolean enablePiano = false;

	@Override
	protected void onCreate(final Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pitch_test);
		configureTestFromPrefs();
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
							test.getNoteToPlay().getFile());
					player.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
					{
						public void onCompletion(MediaPlayer mp)
						{
							mp.stop();
							mp.release();
						}
					});
					player.start();
					enablePiano = true;
				}
				return false;
			}
		});

		pianoView = findViewById(R.id.pianoView);
		pianoView.setOnTouchListener(new View.OnTouchListener()
		{

			@Override
			public boolean onTouch(final View v, final MotionEvent event)
			{
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					if (enablePiano) {
						checkAnswer(((PianoView) v).getNoteTouched(
								event.getX(), event.getY()));
					} else {
						Toast.makeText(getApplicationContext(),
								R.string.press_play_first, Toast.LENGTH_SHORT)
								.show();
					}
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

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle item selection
		switch (item.getItemId())
		{
		case R.id.action_quit_return_home:
			goBackToMainActivity();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void goBackToMainActivity()
	{
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

	public void checkAnswer(final MusicNote guessedNote)
	{
		if (playKeyOnGuess) {
			playGuessedNote(guessedNote);
		}
		if (unlimitedGuessAttempts) {
			if (test.guessNote(guessedNote)) {
				displayDialog(true);
			} else {
				Toast.makeText(getApplicationContext(), R.string.wrong_answer,
						Toast.LENGTH_SHORT).show();
			}
		} else {
			displayDialog(test.guessNote(guessedNote));
		}
	}

	private void playGuessedNote(MusicNote guessedNote)
	{
		// level the note into the same octave as note being tested
		MusicNote testedNote = test.getNoteToPlay();
		int octave = testedNote.getOctave();
		// loop through notes to find the guessed note in the same octave as the
		// tested note
		for (MusicNote note : MusicNote.values()) {
			if (note.getDisplay().equals(guessedNote.getDisplay())
					&& note.getOctave() == octave) {
				guessedNote = note;
				break;
			}
		}
		// now play the note
		MediaPlayer player = MediaPlayer.create(this.getBaseContext(),
				guessedNote.getFile());
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

	/**
	 * Increment the question and change the text of the question number
	 */
	public void setNextQuestion()
	{
		test.incQuestionNum();
		textViewQNum.setText(test.getQuestionNumberInfo());
		enablePiano = false;
	}

	private void configureTestFromPrefs()
	{
		boolean includeBassOctave;
		boolean includeTrebleOctave;
		boolean includeMiddleOctave;
		SharedPreferences sharedPref = PreferenceManager
				.getDefaultSharedPreferences(this);
		unlimitedGuessAttempts = sharedPref.getString(
				SettingsActivity.PREF_GUESS_OPTIONS, "").equals(
				SettingsActivity.PREF_GUESS_UNLIMITED);
		includeBassOctave = sharedPref.getBoolean(
				SettingsActivity.PREF_BASS_OCTAVE, true);
		includeMiddleOctave = sharedPref.getBoolean(
				SettingsActivity.PREF_MIDDLE_OCTAVE, true);
		includeTrebleOctave = sharedPref.getBoolean(
				SettingsActivity.PREF_TREBLE_OCTAVE, true);
		playKeyOnGuess = sharedPref.getBoolean(
				SettingsActivity.PREF_PLAY_KEY_ON_GUESS, true);

		test = new PitchTest(includeBassOctave, includeMiddleOctave,
				includeTrebleOctave);
	}

	/**
	 * Show the dialog after answering a question
	 */
	public void displayDialog(boolean isCorrectAnswer)
	{
		DialogFragment newFragment = AnswerDialogFragment.newInstance(
				R.string.result, isCorrectAnswer);
		newFragment.show(getFragmentManager(), "dialog");

	}

	public void doPositiveClick()
	{
		if (test.getCurrentQuestionNum() < test.getTotalNotes()) {
			setNextQuestion();
			((PianoView) pianoView).resetView();
		} else {
			startResultActivity();
		}
	}

	public void doNegativeClick()
	{
		goBackToMainActivity();

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
		extras.putInt(Utils.TOTALNOTESEXTRA, test.getTotalNotes());
		extras.putInt(Utils.GUESSATTEMPTSEXTRA, test.getAverageGuessAttempts());
		// add bundle to intent
		intent.putExtras(extras);
		startActivity(intent);

	}

}
