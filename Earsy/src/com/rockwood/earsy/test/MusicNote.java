package com.rockwood.earsy.test;

public enum MusicNote {
	A(),
	B(),
	C(),
	D(),
	E(),
	F(),
	G(),
	AFLAT(G,MusicAccidental.Sharp),
	BFLAT(A,MusicAccidental.Sharp),
	DFLAT(C,MusicAccidental.Sharp),
	EFLAT(D,MusicAccidental.Sharp),
	GFLAT(F,MusicAccidental.Sharp);
	
	private MusicNote altNote;
	private MusicAccidental accidental;
	
	MusicNote()
	{
	    
	}

	MusicNote(MusicNote altNote, MusicAccidental accidental)
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
	
	
	public int getOrdinal()
	{
	    return this.ordinal();
	}
	
}
