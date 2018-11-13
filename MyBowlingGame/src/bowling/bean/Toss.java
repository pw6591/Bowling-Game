package bowling.bean;

/**
 * This class is a POJO Bean for Toss
 * @author prasanna.warunkar
 *
 */
public class Toss {
	int numPins;
	boolean strike;
	boolean spare;

	public int getNumPins() {
		return numPins;
	}

	public void setNumPins(int numPins) {
		this.numPins = numPins;
	}

	public boolean isStrike() {
		return strike;
	}

	public void setStrike(boolean strike) {
		this.strike = strike;
	}

	public boolean isSpare() {
		return spare;
	}

	public void setSpare(boolean spare) {
		this.spare = spare;
	}
}
