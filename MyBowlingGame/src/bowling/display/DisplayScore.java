package bowling.display;

import java.util.Map;
import java.util.Map.Entry;

import bowling.bean.Round;
import bowling.bean.Toss;

/**
 * This class displays the score card
 * 
 * @author prasanna.warunkar
 *
 */
public class DisplayScore {

	// This method displays the score card of rounds that has been already finished
	public static void display(Map<Integer, Round> score) {
		int points = 0;
		System.out.print("\n");
		printRoundNumber(score);
		System.out.println();
		printSeperation(score);
		System.out.println();
		for (Entry<Integer, Round> round : score.entrySet()) {
			if (round.getValue().getTosses().get(0).isStrike() && round.getValue().getTosses().size() != 3) {
				System.out.print("|   " + "|" + " X | ");
			} else {
				if (round.getValue().getTosses().size() != 3)
					System.out.print("| " + convertToSymbol(round.getValue().getTosses().get(0)) + " | "
							+ (round.getValue().getTosses().get(1).isSpare() == true ? "/"
									: convertToSymbol(round.getValue().getTosses().get(1)))
							+ " | ");
				else
					System.out.print("| " + convertToSymbol(round.getValue().getTosses().get(0)) + "|"
							+ convertToSymbol(round.getValue().getTosses().get(1)) + "|"
							+ convertToSymbol(round.getValue().getTosses().get(2)) + " | ");
			}
		}
		System.out.println();
		printSeperation(score);
		System.out.println();
		for (Entry<Integer, Round> round : score.entrySet()) {
			points += round.getValue().getRoundScore();
			if (points < 10) {
				System.out.print("|  " + points + "    | ");
			} else if (points >= 10 && points < 100) {
				System.out.print("|  " + points + "   | ");
			} else {
				System.out.print("|  " + points + "  | ");
			}

		}
		System.out.println();
		printSeperation(score);

	}

	private static void printRoundNumber(Map<Integer, Round> score) {
		for (Entry<Integer, Round> round : score.entrySet()) {
			System.out.print(" ROUND " + round.getKey().intValue() + "  ");
		}

	}

	private static void printSeperation(Map<Integer, Round> score) {
		for (int i = 0; i < score.size(); i++) {
			System.out.print("+-------+ ");
		}
	}

	// This method converts strike or spare to its Symbol
	private static String convertToSymbol(Toss toss) {
		if (toss.isSpare()) {
			return "/";
		} else if (toss.isStrike()) {
			return "X";
		} else if (toss.getNumPins() == -1) {
			return "-";
		} else {
			return String.valueOf(toss.getNumPins());
		}
	}
}
