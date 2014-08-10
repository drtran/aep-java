package com.bemach.bdd.bowling;

public class SuperScorer {

	private String bowlerMessage;
	private String score;
	private int firstBallScore;
	private int totalScore;
	private int frame;
	private String songToPlay;

	public int getFrame() {
		return 1;
	}

	public void scoreFirstBall(int pinsKnockedDown) {
		if (pinsKnockedDown == 10) {
			bowlerMessage = "Good Job";
			score = "X";
			songToPlay = "Green Day";
		} else if (pinsKnockedDown == 0) {
			bowlerMessage = "You'll do better next time";
			score = "0";
		}
		firstBallScore = pinsKnockedDown;
		totalScore += pinsKnockedDown;
	}

	public String getScore() {
		return score;
	}

	public String getSongToPlay() {
		return songToPlay;
	}

	public String getBowlerMessage() {
		return bowlerMessage;
	}


	public void scoreSecondBall(int pinsKnockedDown) {
		if (frame < 10) {
			frame++;
		}
			
		if (firstBallScore == 0 && pinsKnockedDown == 0) {
			bowlerMessage = "You need lessons";
			score = "0";
		}
		
		if (frame == 10 && totalScore == 0) {
			bowlerMessage = "You need the gutter bumpers";
			score = "0";
			songToPlay = "Sad Trombone";
		}
	}

}
