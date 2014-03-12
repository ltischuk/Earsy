package com.rockwood.earsy.controller.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
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
		textViewResults.setTypeface(denseFont, Typeface.BOLD_ITALIC);

		TextView textViewHeading = (TextView) findViewById(R.id.textViewResultHeader);
		textViewHeading.setTypeface(denseFont, Typeface.BOLD);

		Button homeBtn = (Button) findViewById(R.id.buttonGoHome);
		homeBtn.setTypeface(denseFont, Typeface.BOLD);
		homeBtn.setOnTouchListener(new View.OnTouchListener()
		{

			@Override
			public boolean onTouch(final View v, final MotionEvent event)
			{
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					displayHomeScreen(v);
				}
				return true;
			}
		});

	}

	private void displayHomeScreen(View v)
	{
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

}
