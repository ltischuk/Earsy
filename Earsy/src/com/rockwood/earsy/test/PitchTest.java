package com.rockwood.earsy.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.media.MediaPlayer;

public class PitchTest 
{

    // Total number of notes to test on
    public static final int TOTALNOTES = 12;
    //source folder for all audio files
    public static final String AUDIOPATH = "/audio/Piano.";
    public static final String AUDIOSUFFIX = ".mp3";
    //score on test
    private int score = 0;
    // current question the user is currently on, starts at 0
    private int questionNumber = 0;    
    //List to hold the randomized ordering of questions
    List<Integer> questionList;
    // set up MediaPlayer
    MediaPlayer audioPlayer = new MediaPlayer();

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
	for (int i=0; i<TOTALNOTES; i++)
	{
	    questionList.add(Integer.valueOf(i));
	}
	 Collections.shuffle(questionList);
    }
    
    public String getQuestionNumberInfo()
    {
	return (questionNumber +1) + " out of " + TOTALNOTES;
    }

    /**
     * Get the score of the test
     * 
     * @return score
     */
    public int getScore() 
    {
	return score;
    }
    
    /**
     * Play the audio file 
     * @param fileName
     */
    public void playAudio() {

	String fileName = MusicNote.values()[questionList.get(questionNumber)].name();

	try {
	    audioPlayer.setDataSource(AUDIOPATH + fileName);
	    audioPlayer.prepare();
	    audioPlayer.start();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
    
    /**
     * Stop the audio from playing
     */
    public void stopAudio()
    {
	if(audioPlayer.isPlaying())
	{
	    audioPlayer.stop();
	}	
    }
    
    

    

}
