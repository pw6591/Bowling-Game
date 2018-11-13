package bowling.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bowling.bean.Round;
import bowling.bean.Toss;
import bowling.calculate.BowlingScore;
import bowling.display.DisplayScore;
import bowling.util.BowlingUtils;

/**
 * This program simulates bowling game with random number generation as a Toss 
 * and shows the bowling score card accordingly.
 * @author prasanna.warunkar
 *
 */
public class MyBowlingGame {

	//This map stores the round tosses and its results
	static Map<Integer, Round> score = new HashMap<Integer, Round>();
		
	public static void main(String[] args) {

		System.out.print("---------------- Bowling Game Started ---------------------\n");
		
		// This loop represents Rounds
		for (int i = 1; i <= 10; i++) {
			System.out.println("\n\n************************************Round : " + i + "**********************************");
			Toss toss = null;
			Round round = new Round();
			List<Toss> tosses = new ArrayList<>();
			int roundScore = 0;
			// This loop represents Tosses
			for (int j = 1; j <= 2; j++) {
				
				toss = new BowlingUtils().createToss(toss);
				tosses.add(toss);
				if (toss.isStrike()) {
					round.setStrike(true);
					roundScore = 10;
				} else if (toss.isSpare()) {
					round.setSpare(true);
					roundScore = 10;
				} else {
					roundScore = roundScore + (toss.getNumPins() == -1 ? 0 : toss.getNumPins());
				}
			}

			round.setRoundScore(roundScore);
			round.setTosses(tosses);
			//put round into the score map
			score.put(i, round);

			//Calculate and Update Round Scores
			BowlingScore.calculateScore(score);
			
			// Tenth Bonus Round
			if (score.get(10) != null && (score.get(10).isStrike() || score.get(10).isSpare())) {
				BowlingScore.bonusRound(score);
			} else {
				DisplayScore.display(score);
			}
		}
		System.out.println("\n\n************************! Game Finished Your Final Score is Shown Below 10th Round !**********************************");

	}

}