package com.rockwood.earsy.model;

import com.rockwood.earsy.R;

public enum MusicNote {

	C0(R.raw.c_0_piano, "C", 0), D0(R.raw.d_0_piano, "D", 0), E0(
			R.raw.e_0_piano, "E", 0), F0(R.raw.f_0_piano, "F", 0), G0(
			R.raw.g_0_piano, "G", 0), A0(R.raw.a_0_piano, "A", 0), B0(
			R.raw.b_0_piano, "B", 0), D0b(R.raw.db_0_piano, "C#Db", 0), E0b(
			R.raw.eb_0_piano, "D#Eb", 0), G0b(R.raw.gb_0_piano, "F#Gb", 0), A0b(
			R.raw.ab_0_piano, "G#Ab", 0), B0b(R.raw.bb_0_piano, "A#Bb", 0), C1(
			R.raw.c_1_piano, "C", 1), D1(R.raw.d_1_piano, "D", 1), E1(
			R.raw.e_1_piano, "E", 1), F1(R.raw.f_1_piano, "F", 1), G1(
			R.raw.g_1_piano, "G", 1), A1(R.raw.a_1_piano, "A", 1), B1(
			R.raw.b_1_piano, "B", 1), D1b(R.raw.db_1_piano, "C#Db", 1), E1b(
			R.raw.eb_1_piano, "D#Eb", 1), G1b(R.raw.gb_1_piano, "F#Gb", 1), A1b(
			R.raw.ab_1_piano, "G#Ab", 1), B1b(R.raw.bb_1_piano, "A#Bb", 1), C2(
			R.raw.c_2_piano, "C", 2), D2(R.raw.d_2_piano, "D", 2), E2(
			R.raw.e_2_piano, "E", 2), F2(R.raw.f_2_piano, "F", 2), G2(
			R.raw.g_2_piano, "G", 2), A2(R.raw.a_2_piano, "A", 2), B2(
			R.raw.b_2_piano, "B", 2), D2b(R.raw.db_2_piano, "C#Db", 2), E2b(
			R.raw.eb_2_piano, "D#Eb", 2), G2b(R.raw.gb_2_piano, "F#Gb", 2), A2b(
			R.raw.ab_2_piano, "G#Ab", 2), B2b(R.raw.bb_2_piano, "A#Bb", 2);

	private String display;
	private int rawFileId;
	private int octave;

	MusicNote(int rawFileId, String display, int octave)
	{
		this.rawFileId = rawFileId;
		this.display = display;
		this.octave = octave;
	}

	public String getDisplay()
	{
		return display;
	}

	public int getFile()
	{
		return rawFileId;
	}

	public int getOctave()
	{
		return octave;
	}

}
