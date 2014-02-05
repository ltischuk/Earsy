package com.rockwood.earsy.utils;

import com.rockwood.earsy.R;
import com.rockwood.earsy.model.MusicNote;


public class Utils {

    public static final String FLAT = "b";
    public static final int NOTEHELPTEXTSIZE = 14;
    public static final String CORRECTTOAST = "That is correct!";
    public static final String WRONGTOAST = "Sorry, that is not right!";
    
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
    
    public static int getMp3FromMusicNote(MusicNote note)
    {
	switch(note)
	{
	case A:
	{
	    return R.raw.a_piano;
	}
	case Ab:
	{
	    return R.raw.ab_piano;
	}
	case B:
	{
	    return R.raw.b_piano;
	}
	case Bb:
	{
	    return R.raw.bb_piano;
	}
	case C:
	{
	    return R.raw.c_piano;
	}
	case D:
	{
	    return R.raw.d_piano;
	}
	case Db:
	{
	    return R.raw.db_piano;
	}
	case E:
	{
	    return R.raw.e_piano;
	}
	case Eb:
	{
	    return R.raw.eb_piano;
	}
	case F:
	{
	    return R.raw.f_piano;
	}
	case G:
	{
	    return R.raw.g_piano;
	}	
	default: 
	    return R.raw.gb_piano;
	}
	
    }
}
