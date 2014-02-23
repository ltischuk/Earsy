package com.rockwood.earsy.controller.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.rockwood.earsy.R;
import com.rockwood.earsy.model.MusicNote;
import com.rockwood.earsy.utils.Utils;

public class ResultsActivity extends Activity
{

	@Override
	protected void onCreate(final Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_results);

		// get passed intent
		Intent intent = getIntent();

		// get message value from intent
		int score = intent.getIntExtra(Utils.SCOREEXTRA, 0);
		String msg = "You got a " + score + " out of 12 notes: "
				+ ((score / MusicNote.values().length) * 100) + "%.";
		TextView textViewResults = (TextView) findViewById(R.id.textViewResults);
		textViewResults.setText(msg);

	}

}
