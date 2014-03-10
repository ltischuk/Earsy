package com.rockwood.earsy.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PitchTest
{

	// Total number of notes to test on
	private int totalNotes = 0;
	// source folder for all audio files
	public static final String AUDIOSUFFIX = ".mp3";
	// score on test
	private int correctGuesses = 0;
	// current question the user is currently on, starts at 0
	private int questionNumber = 0;
	// List to hold the randomized ordering of questions
	private List<Integer> questionList;
	// Map to hold guess attempts
	private Map<MusicNote, Integer> noteGuessAttempts;
	private static final int MAXNOTES = 36;
	private static final int MAXBASSNUM = 11;
	private static final int MAXMIDDLENUM = 23;
	private static final int MAXTREBLENUM = 35;
	private boolean includeBassOctave;
	private boolean includeMiddleOctave;
	private boolean includeTrebleOctave;

	/**
	 * Constructor for a new Pitch Test
	 */
	public PitchTest(boolean includeBassOctave, boolean includeMiddleOctave,
			boolean includeTrebleOctave)
	{
		this.includeMiddleOctave = includeBassOctave;
		this.includeMiddleOctave = includeMiddleOctave;
		this.includeTrebleOctave = includeTrebleOctave;
		noteGuessAttempts = new HashMap<MusicNote, Integer>();
		fillAndShuffleList();
	}

	public int getTotalNotes()
	{
		return totalNotes;
	}

	public int getNoteGuessAttempts(MusicNote note)
	{
		return noteGuessAttempts.get(note);
	}

	/**
	 * Create the list of randomized question numbers
	 */
	private void fillAndShuffleList()
	{
		questionList = new ArrayList<Integer>();
		for (int i = 0; i < MAXNOTES; i++) {
			if (verifyAddToQuestionList(i)) {
				questionList.add(Integer.valueOf(i));
				totalNotes++;
			}

		}
		Collections.shuffle(questionList);
	}

	private boolean verifyAddToQuestionList(int num)
	{
		if ((num <= MAXBASSNUM && includeBassOctave)
				|| (num > MAXBASSNUM && num <= MAXMIDDLENUM && includeMiddleOctave)
				|| (num > MAXBASSNUM && num > MAXMIDDLENUM
						&& num <= MAXTREBLENUM && includeTrebleOctave)) {
			return true;
		}
		return false;
	}

	public int getCurrentQuestionNum()
	{
		return questionNumber + 1;
	}

	public String getQuestionNumberInfo()
	{
		return (questionNumber + 1) + " out of " + totalNotes;
	};

	/**
	 * Get the score of the test
	 * 
	 * @return score
	 */
	public int getScore()
	{
		return correctGuesses;
	}

	public MusicNote getNoteToPlay()
	{
		return MusicNote.values()[questionList.get(questionNumber)];
	}

	public boolean guessNote(MusicNote note)
	{
		int attempts = 0;
		if (noteGuessAttempts.get(note) != null) {
			attempts = noteGuessAttempts.get(note);
		}
		noteGuessAttempts.put(note, attempts + 1);
		if (note.name() == MusicNote.values()[questionList.get(questionNumber)]
				.name()) {
			if (attempts == 0) {
				++correctGuesses;
			}

			return true;
		} else {
			return false;
		}
	}

	public void incQuestionNum()
	{
		if (questionNumber < questionList.size()) {
			++questionNumber;
		}

	}

}
