package com.rockwood.earsy.controller.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.rockwood.earsy.R;

public class MainActivity extends Activity
{

	Typeface denseFont;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		denseFont = Typeface.createFromAsset(getAssets(), "Dense-Regular.otf");
		setContentView(R.layout.activity_main);
		Button quizBtn = (Button) findViewById(R.id.button);
		quizBtn.setTypeface(denseFont, Typeface.BOLD);

		quizBtn.setOnTouchListener(new View.OnTouchListener()
		{

			@Override
			public boolean onTouch(final View v, final MotionEvent event)
			{
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					initPitchTest(v);
				}
				return true;
			}
		});
		PreferenceManager.setDefaultValues(this, R.layout.preferences, false);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle item selection
		switch (item.getItemId())
		{
		case R.id.action_settings:
			showPreferences();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void showPreferences()
	{
		// Display the fragment as the main content.
		startActivity(new Intent(this, SettingsActivity.class));

	}

	/** Called when the user clicks the Start Pitch Test button */
	public void initPitchTest(View view)
	{
		Intent intent = new Intent(this, PitchTestActivity.class);
		startActivity(intent);
	}

}
