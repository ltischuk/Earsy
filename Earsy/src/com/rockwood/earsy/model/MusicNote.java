package com.rockwood.earsy.model;

public enum MusicNote {
	
	C(),	
	D(),	
	E(),
	F(),		
	G(),	
	A(),
	B(),
	Db("C#Db"),
	Eb("D#Eb"),
	Gb("F#Gb"),
	Ab("G#Ab"),
	Bb("A#Bb"),
	;
	
	private String display;
	
	MusicNote()
	{
	    this.display = name();
	}

	MusicNote(String display)
	{
	    this.display = display;
	}
	
	public String getDisplay()
	{
	    return display;
	}
	
}
