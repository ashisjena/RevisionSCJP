package scjp.com.java.algorithm.old.companies.snapwiz;

/*
 Write a program to print out a multiplication matrix, from 1x1 to 12x12. This should look like:

   1   2   3   4   5   6   7   8   9  10  11  12
   2   4   6   8  10  12  14  16  18  20  22  24
   3   6   9  12  15  18  21  24  27  30  33  36
   4   8  12  16  20  24  28  32  36  40  44  48
   5  10  15  20  25  30  35  40  45  50  55  60
   6  12  18  24  30  36  42  48  54  60  66  72
   7  14  21  28  35  42  49  56  63  70  77  84
   8  16  24  32  40  48  56  64  72  80  88  96
   9  18  27  36  45  54  63  72  81  90  99 108
  10  20  30  40  50  60  70  80  90 100 110 120
  11  22  33  44  55  66  77  88  99 110 121 132
  12  24  36  48  60  72  84  96 108 120 132 144
 */

public class MatrixMultiplication
{
	public static Integer n = 12;

	public static void main( String[] args )
	{
		displayResult( multiMatrix( n ) );
	}

	private static int[][] multiMatrix( int n )
	{
		int[][] result = new int[n][n];

		for ( int i = 0; i < result.length; i++ )
			for ( int j = 0; j < result[i].length; j++ )
				result[i][j] = ( i + 1 ) * ( j + 1 );

		return result;
	}

	private static void displayResult( int[][] result )
	{
		for ( int i = 0; i < result.length; i++ )
		{
			for ( int j = 0; j < result[i].length; j++ )
				System.out.print( String.format("%1$4s", result[i][j]) );
			System.out.println();
		}
	}
}