package com.rockwood.earsy.model;

import com.rockwood.earsy.R;

public enum MusicNote {

	C0(R.raw.c_0_piano, "C"), D0(R.raw.d_0_piano, "D"), E0(R.raw.e_0_piano, "E"), F0(
			R.raw.f_0_piano, "F"), G0(R.raw.g_0_piano, "G"), A0(
			R.raw.a_0_piano, "A"), B0(R.raw.b_0_piano, "B"), D0b(
			R.raw.db_0_piano, "C#Db"), E0b(R.raw.eb_0_piano, "D#Eb"), G0b(
			R.raw.gb_0_piano, "F#Gb"), A0b(R.raw.ab_0_piano, "G#Ab"), B0b(
			R.raw.bb_0_piano, "A#Bb"), C1(R.raw.c_1_piano, "C"), D1(
			R.raw.d_1_piano, "D"), E1(R.raw.e_1_piano, "E"), F1(
			R.raw.f_1_piano, "F"), G1(R.raw.g_1_piano, "G"), A1(
			R.raw.a_1_piano, "A"), B1(R.raw.b_1_piano, "B"), D1b(
			R.raw.db_1_piano, "C#Db"), E1b(R.raw.eb_1_piano, "D#Eb"), G1b(
			R.raw.gb_1_piano, "F#Gb"), A1b(R.raw.ab_1_piano, "G#Ab"), B1b(
			R.raw.bb_1_piano, "A#Bb"), C2(R.raw.c_2_piano, "C"), D2(
			R.raw.d_2_piano, "D"), E2(R.raw.e_2_piano, "E"), F2(
			R.raw.f_2_piano, "F"), G2(R.raw.g_2_piano, "G"), A2(
			R.raw.a_2_piano, "A"), B2(R.raw.b_2_piano, "B"), D2b(
			R.raw.db_2_piano, "C#Db"), E2b(R.raw.eb_2_piano, "D#Eb"), G2b(
			R.raw.gb_2_piano, "F#Gb"), A2b(R.raw.ab_2_piano, "G#Ab"), B2b(
			R.raw.bb_2_piano, "A#Bb");

	private String display;
	private int rawFileId;

	MusicNote(int rawFileId, String display)
	{
		this.rawFileId = rawFileId;
		this.display = display;
	}

	public String getDisplay()
	{
		return display;
	}

	public int getFile()
	{
		return rawFileId;
	}

}
