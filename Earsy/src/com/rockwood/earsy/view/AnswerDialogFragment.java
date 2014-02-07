package com.rockwood.earsy.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import com.rockwood.earsy.R;
import com.rockwood.earsy.controller.activity.PitchTestActivity;

public final class AnswerDialogFragment extends DialogFragment
{
	public static AnswerDialogFragment newInstance(final int title)
	{
		final AnswerDialogFragment frag = new AnswerDialogFragment();
		final Bundle args = new Bundle();
		args.putInt("title", title);
		frag.setArguments(args);
		return frag;
	}

	@Override
	public Dialog onCreateDialog(final Bundle savedInstanceState)
	{
		// Use the Builder class for convenient dialog construction
		final AlertDialog.Builder builder = new AlertDialog.Builder(
				getActivity());
		final PitchTestActivity pitchTest = (PitchTestActivity) getActivity();
		builder.setMessage(R.string.correct_answer)
				.setPositiveButton(R.string.next_question,
						new DialogInterface.OnClickListener()
						{
							@Override
							public void onClick(final DialogInterface dialog,
									final int id)
							{
								pitchTest.setNextQuestion();
							}
						})
				.setNegativeButton(R.string.quit,
						new DialogInterface.OnClickListener()
						{
							@Override
							public void onClick(final DialogInterface dialog,
									final int id)
							{
								// User cancelled the dialog
							}
						});
		// Create the AlertDialog object and return it
		return builder.create();
	}
	
	void showDialog() {
	    DialogFragment newFragment = AnswerDialogFragment.newInstance(
	            R.string.result);
	    newFragment.show(getFragmentManager(), "dialog");
	}

	public void doPositiveClick() {
	    // Do stuff here.
	    
	}

	public void doNegativeClick() {
	    // Do stuff here.
	   
	}

}
