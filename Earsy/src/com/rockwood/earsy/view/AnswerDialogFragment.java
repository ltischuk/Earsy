package com.rockwood.earsy.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import com.rockwood.earsy.R;
import com.rockwood.earsy.controller.activity.PitchTestActivity;
import com.rockwood.earsy.model.PitchTest;

public final class AnswerDialogFragment extends DialogFragment
{
	private static final String nextQuestionStr = "Next Question";
	private static final String viewResultsStr = "View My Results";
	
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
		String resultMsg = nextQuestionStr;
		// Use the Builder class for convenient dialog construction
		final AlertDialog.Builder builder = new AlertDialog.Builder(
				getActivity());
		final PitchTestActivity activity = (PitchTestActivity) getActivity();
		if(activity.getCurrentTest().getCurrentQuestionNum()== PitchTest.TOTALNOTES)
		{
			resultMsg = viewResultsStr;
		}
		builder.setMessage(R.string.correct_answer)
				.setPositiveButton(resultMsg,
						new DialogInterface.OnClickListener()
						{
							@Override
							public void onClick(final DialogInterface dialog,
									final int id)
							{
								activity.doPositiveClick();
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
								activity.doNegativeClick();
								dialog.dismiss();
							}
						});
		// Create the AlertDialog object and return it
		return builder.create();
	}

}
