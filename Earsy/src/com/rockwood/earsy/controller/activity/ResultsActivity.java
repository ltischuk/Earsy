package com.rockwood.earsy.controller.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import com.rockwood.earsy.R;
import com.rockwood.earsy.utils.Utils;

public class ResultsActivity extends Activity
{
	Typeface denseFont;

	@Override
	protected void onCreate(final Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		denseFont = Typeface.createFromAsset(getAssets(), "Dense-Regular.otf");
		setContentView(R.layout.activity_results);

		// get passed intent
		Intent intent = getIntent();

		// get message value from intent
		int score = intent.getIntExtra(Utils.SCOREEXTRA, 0);
		int notes = intent.getIntExtra(Utils.TOTALNOTESEXTRA, 0);
		String msg = "You got a " + score + " out of " + notes + " notes: "
				+ (int) ((score * 100.0f) / notes) + "%.";
		TextView textViewResults = (TextView) findViewById(R.id.textViewResults);
		textViewResults.setText(msg);
		textViewResults.setTypeface(denseFont, Typeface.BOLD);

		TextView textViewHeading = (TextView) findViewById(R.id.textViewResultHeader);
		textViewHeading.setTypeface(denseFont, Typeface.BOLD);

	}

}
