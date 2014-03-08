package com.rockwood.earsy.controller.activity;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.rockwood.earsy.R;

public class SettingsFragment extends PreferenceFragment
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		// Load the preferences from an XML resource
		addPreferencesFromResource(R.layout.preferences);
	}
}
