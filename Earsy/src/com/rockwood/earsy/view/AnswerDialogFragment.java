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
	private static final String nextQuestionStr = "Next Question";
	private static final String viewResultsStr = "View My Results";

	/**
	 * New Static Instance of AnswerDialogFragment
	 * 
	 * @param title
	 * @param isCorrect
	 * @return
	 */
	public static AnswerDialogFragment newInstance(final int title,
			boolean isCorrect)
	{
		final AnswerDialogFragment frag = new AnswerDialogFragment();
		final Bundle args = new Bundle();
		args.putInt("title", title);
		args.putBoolean("answer", isCorrect);
		frag.setArguments(args);
		return frag;
	}

	@Override
	public Dialog onCreateDialog(final Bundle savedInstanceState)
	{
		String resultMsg = nextQuestionStr;
		int messageId = R.string.correct_answer;
		// Use the Builder class for convenient dialog construction
		final AlertDialog.Builder builder = new AlertDialog.Builder(
				getActivity());
		final PitchTestActivity pitchTestActivity = (PitchTestActivity) getActivity();
		if (pitchTestActivity.getCurrentTest().getCurrentQuestionNum() == pitchTestActivity
				.getCurrentTest().getTotalNotes()) {
			resultMsg = viewResultsStr;
		}
		if (getArguments().getBoolean("answer") == false) {
			messageId = R.string.wrong_answer;
		}
		builder.setMessage(messageId)
				.setPositiveButton(resultMsg,
						new DialogInterface.OnClickListener()
						{
							@Override
							public void onClick(final DialogInterface dialog,
									final int id)
							{
								pitchTestActivity.doPositiveClick();
								dialog.dismiss();
							}
						})
				.setNegativeButton(R.string.quit,
						new DialogInterface.OnClickListener()
						{
							@Override
							public void onClick(final DialogInterface dialog,
									final int id)
							{
								pitchTestActivity.doNegativeClick();
								dialog.dismiss();
							}
						});
		// Create the AlertDialog object and return it
		return builder.create();
	}

}
