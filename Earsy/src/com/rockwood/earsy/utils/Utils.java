package com.rockwood.earsy.utils;

import com.rockwood.earsy.model.MusicNote;

public class Utils
{

	public static final String FLAT = "b";
	public static final int NOTEHELPTEXTSIZE = 14;
	public static final String CORRECTTOAST = "That is correct!";
	public static final String WRONGTOAST = "Sorry, that is not right!";
	public static final int TOPPRIORITY = 1;
	public static final String SCOREEXTRA = "score";

	public static int getIndexOfFlatNotes()
	{
		for (MusicNote note : MusicNote.values()) {
			if (note.name().endsWith(FLAT)) {
				return note.ordinal();
			}
		}
		return 0;
	}
}
