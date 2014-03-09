package com.rockwood.earsy.controller.activity;

import android.app.Activity;
import android.os.Bundle;

public class SettingsActivity extends Activity
{
	public static final String PREF_GUESS_OPTIONS = "prefGuessOptions";
	public static final String PREF_GUESS_UNLIMITED = "0";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		// Display the fragment as the main content.
		getFragmentManager().beginTransaction()
				.replace(android.R.id.content, new SettingsFragment()).commit();
	}

}
