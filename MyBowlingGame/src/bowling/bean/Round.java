package bowling.bean;

import java.util.List;

/**
 * This class is a POJO Bean for Round
 * @author prasanna.warunkar
 *
 */
public class Round {
	List<Toss> tosses;
	int roundScore;
	boolean spare;
	boolean strike;
	boolean updatedResult;
	public List<Toss> getTosses() {
		return tosses;
	}

	public void setTosses(List<Toss> tosses) {
		this.tosses = tosses;
	}

	public int getRoundScore() {
		return roundScore;
	}

	public void setRoundScore(int roundScore) {
		this.roundScore = roundScore;
	}

	public boolean isSpare() {
		return spare;
	}

	public void setSpare(boolean spare) {
		this.spare = spare;
	}

	public boolean isStrike() {
		return strike;
	}

	public void setStrike(boolean strike) {
		this.strike = strike;
	}

	public boolean isUpdatedResult() {
		return updatedResult;
	}

	public void setUpdatedResult(boolean updatedResult) {
		this.updatedResult = updatedResult;
	}
	
	
}
