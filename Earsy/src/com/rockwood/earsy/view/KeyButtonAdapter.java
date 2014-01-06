package com.rockwood.earsy.view;

import com.rockwood.earsy.R;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;


public class KeyButtonAdapter extends BaseAdapter {
    private Context context;
    private final String[] notes;

    public KeyButtonAdapter(Context context, String[] notes) {
	this.context = context;
	this.notes = notes;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

	LayoutInflater inflater = (LayoutInflater) context
		.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

	View gridView;

	if (convertView == null) {

	    gridView = new View(context);
	    gridView = inflater.inflate(R.layout.keybuttons, null);
	    Button button = (Button) gridView.findViewById(R.id.keybutton);
	    button.setText(notes[position]);
	    String note = notes[position];
	    Drawable drawableTop = null;

	    if (note.contains("#")) {
		drawableTop = parent.getResources().getDrawable(R.drawable.ic_blackkeybutton);
		
	    } else if (note.equals("C") || note.equals("F")) {
		drawableTop = parent.getResources().getDrawable(R.drawable.ic_whitekeybuttoncf);
	    } else if (note.equals("D")|| note.equals("G") || note.equals("A")) {
		drawableTop = parent.getResources().getDrawable(R.drawable.ic_whitekeybuttondga);
	    } else {
		drawableTop = parent.getResources().getDrawable(R.drawable.ic_whitekeybuttoneb);
	    }
	    drawableTop.setBounds(0, 0, 50, 50);
	    button.setCompoundDrawables(null, drawableTop, null, null);

	} else {
	    gridView = (View) convertView;
	}

	return gridView;
    }

    @Override
    public int getCount() {
	return notes.length;
    }

    @Override
    public Object getItem(int position) {
	return null;
    }

    @Override
    public long getItemId(int position) {
	return 0;
    }

}
