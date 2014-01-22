package com.rockwood.earsy.utils;

import com.rockwood.earsy.model.MusicNote;


public class Utils {

    public static final String FLAT = "b";
    
    public static int getIndexOfFlatNotes()
    {
	for (MusicNote note: MusicNote.values())
	{
	   if(note.name().endsWith(FLAT)) 
	   {
	       return note.ordinal();
	   }
	}
	return 0;
    }
}
