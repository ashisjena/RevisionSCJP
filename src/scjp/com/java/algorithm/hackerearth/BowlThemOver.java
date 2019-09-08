package scjp.com.java.algorithm.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*Harvey and Mike decided to go for bowling one day. Mike, being himself, continuously kept on boasting about his photographic memory and awesome 
 * brainy powers. Harvey ignored him for sometime but then he got annoyed. Halfway through the game Harvey went up to the bowling arena manager 
 * and told him to turn off the score display. He then came back and challenged Mike to keep a track of all the scores of all the games going on 
 * in the arena and if he had the skills then he needed to prove them by telling Harvey the correct scores for all games.

Rules :
A game consists of ten frames, which start with a full rack of ten pins. In each frame, you have two deliveries of your ball, in which to knock down as 
many of the ten pins as you can.

If you knock down all the pins on your first ball, it is called a strike. The score doesn't get added on straight away because for a strike, 
you get the values of your next two balls as a bonus. For example, if you score a strike in the first frame, then a 7 and 1 in the second frame, 
you would score 18 (10+7+1) for the first frame, and 8 for the second frame, making a total of 26 after two frames. 
If you knock down some of the pins on the first ball, and knocked down the remainder of the pins in the second ball, it is known as a spare. 
Again, the score doesn't get added on straight away because for a spare, you get the values of your next ball as a bonus. For example, 
you if score a spare in the first frame, say an 6 and a 4, then got an 8 and a 1 in the second frame, you would score 18 (6+4+8) for the first frame, 
and 9 for the second frame, making a total of 27 after two frames.

When it comes to the final frame, it is slightly different. In the final frame, you get bonus balls if you strike or spare, 
to a maximum of three deliveries. If you strike in the first delivery you have the opportunity to strike in the remaining two and have three 
deliveries in total. If you scored strikes in each of your final three deliveries, the score for the final frame would be 30 (10+10+10). 
If you spare the final frame, you get the third delivery as a bonus. So, a spare, 9 and 1, followed by a strike would equal 20 (9+1+10).

You play the part of Mike�s awesome brain here. Write a program to help Mike�s brain calculate the final score for given N games.

Input
The first line of the input contains number of games N <= 10. Then the description of each of N games follows one per line. 
Each line consists of several integers 0 <= a <= 10 � the amount of pins knocked down after each delivery of the ball. 
Each test case describes a full game for one player. All the games in the input file are correct.

Output
For each test case output the number of points the player gets in a game on a separate line.
Sample Input (Plaintext Link)
1
3 5 1 5 7 1 10 1 6 10 6 2 1 2 0 5 8 1
Sample Output (Plaintext Link)
89
Explanation
For Given Case
The scores for each set are as follows:
8,6,8,17,7,18,8,3,5,9 which sums up to 89.
*/

public class BowlThemOver
{
	private static int noOfFrames = 10;
	private static int noOfPins = 10;
	private static int noOfDeliveries = 2;
	private static int maxFinalFrameDeliveries = 3;

	public static void main( String[] args ) throws IOException
	{
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		String line1 = br.readLine();

		Integer noOfGames = Integer.parseInt( line1 );

		List<String[]> scores = new ArrayList<String[]>();

		for ( int i = 0; i < noOfGames; i++ )
		{
			String line2 = br.readLine();
			String[] splitString = line2.split( "\\s" );
			scores.add( splitString );
		}

		for ( String[] strings : scores )
		{
			System.out.println( getScoreForGame( strings ) );
		}
	}

	private static int getScoreForGame( String[] strings )
	{
		int[][] scoreBoardArr = new int[noOfFrames - 1][noOfDeliveries];
		int[] finalFrameScore = new int[maxFinalFrameDeliveries];

		boolean isFirstDelivery = true;
		int index = 0;
		for ( int frameNo = 0; index < strings.length && frameNo < 9; index++ )
		{
			int score = Integer.parseInt( strings[index] );

			if ( isFirstDelivery )
			{
				scoreBoardArr[frameNo][0] = score;
				if ( score == 10 )
				{
					frameNo++;
					continue;
				}
				isFirstDelivery = false;
			}
			else
			{
				scoreBoardArr[frameNo][1] = score;
				isFirstDelivery = true;
				frameNo++;
			}
		}

		for ( int i = 0; index < strings.length && i < 3; i++, index++ )
		{
			int score = Integer.parseInt( strings[index] );
			finalFrameScore[i] = score;
		}

		return calculateScores( scoreBoardArr, finalFrameScore );
	}

	private static int calculateScores( int[][] scoreBoardArr, int[] finalFrameScore )
	{
		int totalScore = 0;
		boolean isPrevStrike = false;
		boolean isPrevSpare = false;
		for ( int[] scorePerFrame : scoreBoardArr )
		{
			int firstDeliveryScore = scorePerFrame[0];
			int secondDeliveryScore = scorePerFrame[1];

			if ( isPrevStrike )
				totalScore += firstDeliveryScore + secondDeliveryScore;

			if ( isPrevSpare )
				totalScore += firstDeliveryScore;

			if ( firstDeliveryScore == noOfPins )
			{
				if ( isPrevStrike )
					isPrevSpare = true;
				else
				{
					isPrevSpare = false;
					isPrevStrike = true;
				}

				totalScore += noOfPins;
			}
			else if ( firstDeliveryScore + secondDeliveryScore == noOfPins )
			{
				isPrevSpare = true;
				isPrevStrike = false;
				totalScore += noOfPins;
			}
			else
			{
				totalScore += firstDeliveryScore + secondDeliveryScore;
				isPrevSpare = false;
				isPrevStrike = false;
			}
		}

		if ( isPrevStrike )
			totalScore += finalFrameScore[0] + finalFrameScore[1];
		if ( isPrevSpare )
			totalScore += finalFrameScore[0];

		for ( int score : finalFrameScore )
			totalScore += score;

		return totalScore;
	}
}