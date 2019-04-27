package scjp.com.java.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
The king of ghosts is really disappointed when he sees that all the human beings on Planet Earth have stopped fearing the ghost race. He knows the reason for this. The existing ghost race has become really lazy and has stopped visiting Planet Earth to scare the human race. Hence, he decides to encourage the entire ghost race into scaring the humans by holding a competition. The king, however, never visits Planet Earth.

This competition will go on for N days. Currently, there are a total of M ghosts (apart from the king) existing in the ghost race such that :
- The youngest ghost is 1 year old.
- The oldest ghost is M years old.
- No two ghosts have the same age.
- The age of each and every ghost is a positive integer.

On each day of the competition, ghosts have to visit Planet Earth to scare people. At the end of each day, a "Ghost of the Day" title is awarded to the ghost who scares the most number of humans on that particular day. However, the king of ghosts believes in consistency. Once this title has been given, the ghost who has won the most number of such titles until that particular moment is presented with a "Consistency Trophy". If there are many such ghosts, the oldest among them is given the trophy. Note that this "Title Giving" and "Trophy Giving" happens at the end of each day of the competition.

You will be given the age of the ghost who won the "Ghost of the Day" title on each day of the competition. Your job is to find out the age of the ghost who was awarded with the "Consistency Trophy" on each day of the competition.

Input
The first line consists of 2 space separated integers N and M. The next line consists of N space separated integers such that the ith integer denotes the age of the ghost who was awarded with the "Ghost of the Day" title on the ith day of the competition.

Output
Print N lines. The ith line should contain 2 space separated integers such that the first integer denotes the age of the ghost who was awarded with the "Consistency Trophy" on the ith day and the second integer denotes the number of "Ghost of the Day" titles won by this ghost until the end of the ith day of the competition.

Constraints
1 <= N <= 105
1 <= M <= 109
Sample Input (Plaintext Link)
7 5
1 3 1 3 2 2 2
Sample Output (Plaintext Link)
1 1
3 1 
1 2
3 2
3 2
3 2
2 3
*/

public class Haunted
{
	public static void main( String[] args ) throws Exception
	{
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		String line1 = br.readLine();
		String line2 = br.readLine();

		String[] line1Values = line1.split( "\\s" );

		int noOfDays = Integer.parseInt( line1Values[0] );
		int noOfGhosts = Integer.parseInt( line1Values[1] );

		Value winner = null;
		Map<Integer, Value> valuesMap = new HashMap<Integer, Value>();
		for ( String ageAsString : line2.split( "\\s" ) )
		{
			int age = Integer.parseInt( ageAsString );

			Value prev = valuesMap.get( age );

			if ( prev != null )
			{
				int noOfTrophies = prev.increaseNGetNoOfTrophies();
				if ( ( winner.getNoOfTrophies() == noOfTrophies && winner.getAgeOfGhost() < age ) || winner.getNoOfTrophies() < noOfTrophies )
					winner = prev;
			}
			else
			{
				Value value = new Value( age );
				if ( winner == null || ( winner.getNoOfTrophies() == 1 && winner.getAgeOfGhost() < age ) )
					winner = value;

				valuesMap.put( age, value );
			}

			System.out.println( winner.getAgeOfGhost() + " " + winner.getNoOfTrophies() );
		}
	}
}

class Value
{
	private int ageOfGhost;
	private int noOfTrophies;
	private Value winner;

	public Value( int ageOfGhost )
	{
		this.ageOfGhost = ageOfGhost;
		this.noOfTrophies = 1;
	}

	public int getAgeOfGhost()
	{
		return ageOfGhost;
	}

	public void setAgeOfGhost( int ageOfGhost )
	{
		this.ageOfGhost = ageOfGhost;
	}

	public int getNoOfTrophies()
	{
		return noOfTrophies;
	}

	public int increaseNGetNoOfTrophies()
	{
		return this.noOfTrophies += 1;
	}

	public Value getWinner()
	{
		return winner;
	}

	public void setWinner( Value winner )
	{
		this.winner = winner;
	}
}