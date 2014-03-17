package com.rockwood.earsy.view;

import android.graphics.Rect;

import com.rockwood.earsy.model.MusicNote;

public class PianoKey
{

	private Rect rect;
	private int xText;
	private int yText;
	// the x coordinate for the text will always be in the middle of the key
	private static final int xPoint = 2;
	private MusicNote note;

	public PianoKey(MusicNote note)
	{
		this.note = note;
		rect = new Rect(0, 0, 0, 0);
	}

	public void resizeKey(int left, int top, int right, int bottom, int yPoint)
	{
		rect.set(left, top, right, bottom);
		xText = right - ((right - left) / xPoint);
		yText = bottom - ((bottom - top) / yPoint);
	}

	public MusicNote getNote()
	{
		return note;
	}

	public int getXText()
	{
		return xText;
	}

	public int getYText()
	{
		return yText;
	}

	public Rect getRect()
	{
		return rect;
	}

}
