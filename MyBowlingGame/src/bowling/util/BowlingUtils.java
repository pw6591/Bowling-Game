package bowling.util;

import java.util.Random;
import java.util.Scanner;

import bowling.bean.Toss;

/**
 * This class provides utilities for bowling game
 * @author prasanna.warunkar
 *
 */
public class BowlingUtils {

	//This method creates the toss
	public Toss createToss(Toss toss) {
		boolean firstToss = false;
		Toss toss1 = new Toss();
		Toss toss2 = new Toss();
		//Check for first or second Toss
		if (toss == null) {
			firstToss = true;
		}
		//Check for first toss is strike. If yes then set second toss to -1 and skip the second Toss
		if (toss != null && toss.isStrike()) {
			toss2.setNumPins(-1);
			return toss2;
		}

		// Generate the Toss
		hitEnter();

		// Check for bowled pins

		//int bowledPins = getRandomNumberInRange(0, firstToss ? 10 : 10 - toss.getNumPins());

		if (firstToss) {
			int bowledPins1 = getRandomNumberInRange(0, 10 ); //Change here 0 to 8 to test more spare and strikes
			System.out.println("\n--------------Toss : 1 You got "+bowledPins1 +" pins !");
			if (bowledPins1 == 10)
				toss1.setStrike(true);
			toss1.setNumPins(bowledPins1);
			return toss1;
		}
		else {
			int bowledPins2 = getRandomNumberInRange(0, 10 - toss.getNumPins());
			System.out.println("\n--------------Toss : 2 You got "+bowledPins2 +" pins !");
			toss2.setNumPins(bowledPins2);
			if (bowledPins2 + toss.getNumPins() == 10)
				toss2.setSpare(true);
			return toss2;
		}

	}

	//This method generates random within mentioned range inclusive of min and max
	public static int getRandomNumberInRange(int min, int max) {
		
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		int num = r.nextInt((max - min) + 1) + min;
	//	System.out.println("Min : " + min + "     Max : " + max + "   You got :" + num + " pins !");
		return num;
	}

	//This method detects the enter button is pressed
	public boolean hitEnter() {
		System.out.println("\nHit Enter to Roll the Bowl ------");
		Scanner scanner = new Scanner(System.in);
		String s1 = null;
		s1 = scanner.nextLine();
		if ((s1 == null) || (s1.length() == 0) || (s1.trim().equals(""))) {
			return true;
		}
		return false;
	}
}
