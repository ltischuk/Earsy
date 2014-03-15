package com.rockwood.earsy.controller.activity;

import android.app.Activity;
import android.os.Bundle;

public class SettingsActivity extends Activity
{
	public static final String PREF_GUESS_OPTIONS = "prefGuessOptions";
	public static final String PREF_GUESS_UNLIMITED = "0";
	public static final String PREF_BASS_OCTAVE = "prefBassOctave";
	public static final String PREF_MIDDLE_OCTAVE = "prefMiddleOctave";
	public static final String PREF_TREBLE_OCTAVE = "prefTrebleOctave";
	public static final String PREF_PLAY_KEY_ON_GUESS = "prefPlayKeyOnGuess";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		// Display the fragment as the main content.
		getFragmentManager().beginTransaction()
				.replace(android.R.id.content, new SettingsFragment()).commit();
	}

}
