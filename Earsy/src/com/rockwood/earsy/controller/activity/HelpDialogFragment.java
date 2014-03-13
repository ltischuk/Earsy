package com.rockwood.earsy.controller.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.rockwood.earsy.R;

public class HelpDialogFragment extends DialogFragment
{
	public static android.app.DialogFragment newInstance(int title)
	{
		HelpDialogFragment frag = new HelpDialogFragment();
		Bundle args = new Bundle();
		args.putInt("title", title);
		frag.setArguments(args);
		return frag;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		// Get the layout inflater
		LayoutInflater inflater = getActivity().getLayoutInflater();

		View view = inflater.inflate(R.layout.help_fragment, null);
		TextView txtView = (TextView) view.findViewById(R.id.text_view_instruc);
		txtView.setTypeface(MainActivity.denseFont, Typeface.BOLD);
		// Inflate and set the layout for the dialog
		// Pass null as the parent view because its going in the dialog layout
		builder.setView(view)
		// Add action buttons
				.setPositiveButton(R.string.button_back_text,
						new DialogInterface.OnClickListener()
						{
							@Override
							public void onClick(DialogInterface dialog, int id)
							{
								HelpDialogFragment.this.getDialog().cancel();
							}
						});

		return builder.create();
	}
}
