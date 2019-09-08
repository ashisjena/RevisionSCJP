package scjp.com.java.algorithm.dynamicProgramming;

public class ToweOfHanoi
{
	public static void main( String[] args )
	{
		int noOfDiscs = 3;
		towerOfHanoi( noOfDiscs, 'A', 'C', 'B' );
	}

	public static void towerOfHanoi( int topN, char from, char to, char inter )
	{
		if ( topN == 1 )
			System.out.println( "Disk 1 is from " + from + " to " + to );
		else
		{
			towerOfHanoi( topN - 1, from, inter, to );
			System.out.println( "Disk " + topN + " is from " + from + " to " + to );
			towerOfHanoi( topN - 1, inter, to, from );
		}
	}
}