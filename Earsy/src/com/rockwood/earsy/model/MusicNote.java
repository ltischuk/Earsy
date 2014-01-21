package com.rockwood.earsy.model;

public enum MusicNote {
	
	C(),
	DFLAT("C#Db",C,MusicAccidental.Sharp),
	D(),
	EFLAT("D#Eb",D,MusicAccidental.Sharp),
	E(),
	F(),
	GFLAT("F#Gb",F,MusicAccidental.Sharp),	
	G(),
	AFLAT("G#Ab",G,MusicAccidental.Sharp),
	A(),	
	BFLAT("A#Bb",A,MusicAccidental.Sharp),
	B();
	
	
	
	private MusicNote altNote;
	private MusicAccidental accidental;
	private String display;
	
	MusicNote()
	{
	    this.display = name();
	}

	MusicNote(String display, MusicNote altNote, MusicAccidental accidental)
	{
	    this.altNote = altNote;
	    this.accidental = accidental;
	}
	
	public MusicNote getAltNote()
	{
	    return altNote;
	}
	
	public MusicAccidental getAccidental()
	{
	    return accidental;
	}
	
	public String getDisplay()
	{
	    return display;
	}
	
}
