package bowling.calculate;

import java.util.Map;

import bowling.bean.Round;
import bowling.bean.Toss;
import bowling.display.DisplayScore;
import bowling.util.BowlingUtils;

public class BowlingScore {

	public static void calculateScore(Map<Integer, Round> score) {

		// Update Results
		for (int k = 1; score.size() > 0 && k <= score.size(); k++) {
			// Check if the result is updated or not
			if (!score.get(k).isUpdatedResult()) {
				// Check if the round has spare. If yes add next two toss in the round score
				if (score.get(k).isSpare()) {
					if (score.get(k + 1) != null) {
						score.get(k).setRoundScore(
								score.get(k).getRoundScore() + score.get(k + 1).getTosses().get(0).getNumPins());
						score.get(k).setUpdatedResult(true);
					}
				}
				// Check if the round has strike. If yes add next two toss in the round score
				else if (score.get(k).isStrike()) {
					if (score.get(k + 1) != null && !score.get(k + 1).isStrike()) {
						score.get(k).setRoundScore(
								score.get(k).getRoundScore() + score.get(k + 1).getTosses().get(0).getNumPins()
										+ score.get(k + 1).getTosses().get(1).getNumPins());
						score.get(k).setUpdatedResult(true);
					} else if (score.get(k + 1) != null && score.get(k + 2) != null && score.get(k + 1).isStrike()) {
						score.get(k).setRoundScore(
								score.get(k).getRoundScore() + score.get(k + 1).getTosses().get(0).getNumPins()
										+ score.get(k + 2).getTosses().get(0).getNumPins());
						score.get(k).setUpdatedResult(true);
					}
				}
				// Otherwise score is already updated
				else {
					score.get(k).setUpdatedResult(true);
				}
			}
		}
	}

	public static void bonusRound(Map<Integer, Round> score) {
	
		if (score.get(10).isStrike()) {
			new BowlingUtils().hitEnter();
			int bowledPins = BowlingUtils.getRandomNumberInRange(0, 10);
			System.out.println("\n--------------Toss : 2 You got "+bowledPins +" pins  !");
			score.get(10).getTosses().get(1).setNumPins(bowledPins);
			if (bowledPins == 10) {
				score.get(10).getTosses().get(1).setStrike(true);
			} 
			
			new BowlingUtils().hitEnter();
			int bowledPins2 = BowlingUtils.getRandomNumberInRange(0,bowledPins == 10 ? 10 : 10 - bowledPins);
			System.out.println("\n--------------Toss : 3 You got "+bowledPins2 +" pins !");
			Toss t = new Toss();
			t.setNumPins(bowledPins2);
			if (bowledPins2 == 10) {
				t.setStrike(true);
			} 
			score.get(10).getTosses().add(t);
			score.get(10).setRoundScore(score.get(10).getTosses().get(0).getNumPins() + bowledPins + bowledPins2);
			if(bowledPins + bowledPins2 == 10) {
				score.get(10).getTosses().get(2).setSpare(true);
			}
			if (score.get(9).isStrike()) {
				score.get(9).setRoundScore(score.get(9).getTosses().get(0).getNumPins() + bowledPins
						+ score.get(10).getTosses().get(0).getNumPins());
			}
		} else if (score.get(10).isSpare()) {
			new BowlingUtils().hitEnter();
			int bowledPins2 = BowlingUtils.getRandomNumberInRange(0, 10);
			System.out.println("\n--------------Toss : 3 You got "+bowledPins2 +" pins !");
			Toss t = new Toss();
			t.setNumPins(bowledPins2);
			if (bowledPins2 == 10) {
				t.setStrike(true);
			} 
			t.setNumPins(bowledPins2);
			score.get(10).getTosses().add(t);
			score.get(10).setRoundScore(score.get(10).getTosses().get(0).getNumPins()
					+ score.get(10).getTosses().get(1).getNumPins() + bowledPins2);
			if (score.get(9).isStrike()) {
				score.get(9).setRoundScore(score.get(9).getTosses().get(0).getNumPins() +score.get(10).getTosses().get(0).getNumPins() + score.get(10).getTosses().get(1).getNumPins());
			}
		}
		DisplayScore.display(score);
	}

}
