package scjp.com.java.algorithm.old.companies.snapwiz;

/*
In a "lucky lottery", two numbers are picked and the player is rewarded according to the following rules. 
The player is rewarded 0 if the difference between the numbers is 10. 
If both the numbers are the same then the player is rewarded 10 
and if the numbers are different he is rewarded 1.
 */

public class LuckyLottery
{
	public static int luckyLottery( int x, int y )
	{
		if ( x == y )
			return 10;
		else if ( Math.abs( x - y ) == 10 )
			return 0;
		else
			return 1;
	}

	public static void main( String[] args )
	{
		System.out.println( luckyLottery( 2, 2 ) );
		System.out.println( luckyLottery( 0, 10 ) );
		System.out.println( luckyLottery( 25, 15 ) );
		System.out.println( luckyLottery( 2, 3 ) );
	}
}