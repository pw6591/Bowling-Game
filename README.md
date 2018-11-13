# Bowling-Game

This a bowling game simulated using Java and the scorecard is generated accordingly. 

Run the game you need to use following command in terminal and follow the instructions that appears on terminal:

(Project Path)\bin>java bowling.main.MyBowlingGame 

Once the game is statrted by pressing enter you toss the bowl.

Rules of the Game

1.  Every game consists of 10 rounds 
2.  In every round, the player has two tosses
3.  In the first toss, the player can randomly bowl at most 10 pins
4.  In the second toss, the player can bowl randomly another (10 – number of bowled pins from the first toss) pins
5.  The score per round is calculated based on the number of bowled pins + additional bonuses if a strike or spare was achieved.
6.  A strike is accomplished when all 10 pins were bowled in the first toss already.
7.  A spare is accomplished when all 10 pins were bowled in two tosses.
8.  The bonus for a spare round is calculated based on the bowled pins of the next toss.
9.  The bonus for a strike round is calculated based on the bowled pins of the next two tosses.
10. In the very last round (i.e., round 10) a player may have an additional third toss, if he again achieved a strike or spare within   this round.

After finishing all 10 rounds you will see the final output as following:


 ROUND 1   ROUND 2   ROUND 3   ROUND 4   ROUND 5   ROUND 6   ROUND 7   ROUND 8   ROUND 9   ROUND 10  
+-------+ +-------+ +-------+ +-------+ +-------+ +-------+ +-------+ +-------+ +-------+ +-------+ 
| 6 | 1 | | 6 | 1 | | 4 | 2 | | 4 | 5 | | 1 | 6 | |   | X | |   | X | | 7 | 2 | | 7 | 0 | | X|6|/ | 
+-------+ +-------+ +-------+ +-------+ +-------+ +-------+ +-------+ +-------+ +-------+ +-------+ 
|  7    | |  14   | |  20   | |  29   | |  36   | |  63   | |  82   | |  91   | |  98   | |  118  | 
+-------+ +-------+ +-------+ +-------+ +-------+ +-------+ +-------+ +-------+ +-------+ +-------+ 

************************! Game Finished Your Final Score is Shown Below 10th Round !**********************************


ENJOY THE GAME !!!




