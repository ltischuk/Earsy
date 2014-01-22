package com.rockwood.earsy.view;

import com.rockwood.earsy.model.MusicNote;

import android.graphics.Rect;

public class PianoKey {

    private Rect rect;
    private int xText;
    private int yText;
    private static int xScale = 2;
    private static int yScale = 4;
    private MusicNote note;
    
    
    
    public PianoKey(MusicNote note)
    {
	this.note = note;
	rect = new Rect(0,0,0,0);
    }
    
    public void resizeKey(int left, int top, int right, int bottom) {
	rect.set(left,top,right,bottom);
	xText = right - ((right - left) /xScale);
	yText = bottom -((bottom - top)/yScale);	
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
    
    public Rect getRect() {
	return rect;
    }
    
}
