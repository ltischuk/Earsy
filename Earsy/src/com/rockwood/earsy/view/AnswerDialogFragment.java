package com.rockwood.earsy.view;

import com.rockwood.earsy.R;
import com.rockwood.earsy.controller.activity.PitchTestActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class AnswerDialogFragment extends DialogFragment
{
	
	    @Override
	    public Dialog onCreateDialog(Bundle savedInstanceState) {
	        // Use the Builder class for convenient dialog construction
	        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
	        final PitchTestActivity pitchTest = (PitchTestActivity) getActivity();
	        builder.setMessage(R.string.correct_answer)
	               .setPositiveButton(R.string.next_question, new DialogInterface.OnClickListener() {
	                   public void onClick(DialogInterface dialog, int id) {
	                	   pitchTest.setNextQuestion();
	                   }
	               })
	               .setNegativeButton(R.string.quit, new DialogInterface.OnClickListener() {
	                   public void onClick(DialogInterface dialog, int id) {
	                       // User cancelled the dialog
	                   }
	               });
	        // Create the AlertDialog object and return it
	        return builder.create();
	    }
	
}
