package com.rockwood.earsy.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PitchTest
{

	// Total number of notes to test on
	public static final int TOTALNOTES = 12;
	// source folder for all audio files
	public static final String AUDIOSUFFIX = ".mp3";
	// score on test
	private int score = 0;
	// current question the user is currently on, starts at 0
	private int questionNumber = 0;
	// List to hold the randomized ordering of questions
	List<Integer> questionList;

	/**
	 * Constructor for a new Pitch Test
	 */
	public PitchTest()
	{
		fillAndShuffleList();
	}

	/**
	 * Create the list of randomized question numbers
	 */
	private void fillAndShuffleList()
	{
		questionList = new ArrayList<Integer>();
		for (int i = 0; i < TOTALNOTES; i++) {
			questionList.add(Integer.valueOf(i));
		}
		Collections.shuffle(questionList);
	}

	public String getQuestionNumberInfo()
	{
		return (questionNumber + 1) + " out of " + TOTALNOTES;
	};

	/**
	 * Get the score of the test
	 * 
	 * @return score
	 */
	public int getScore()
	{
		return score;
	}

	public MusicNote getNoteToPlay()
	{
		return MusicNote.values()[questionList.get(questionNumber)];
	}

	public boolean guessNote(MusicNote note)
	{
		if (note.name() == MusicNote.values()[questionList.get(questionNumber)]
				.name()) {
			return true;
		} else {
			return false;
		}
	}
	
	public void incQuestionNum()
	{
		if(questionNumber< questionList.size())
		{
			++questionNumber;
		}
			
	}

}
