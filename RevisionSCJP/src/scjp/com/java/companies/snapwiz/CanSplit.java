package scjp.com.java.companies.snapwiz;

public class CanSplit
{
	public static void main( String[] args )
	{
		System.out.println( canSplit( new int[]
		{ 1, 1 } ) );
		System.out.println( canSplit( new int[]
		{ 1, 1, 1 } ) );
		System.out.println( canSplit( new int[]
		{ 2, 4, 2 } ) );
	}

	public static boolean canSplit( final int[] nums )
	{
		final int sumOfArr = findSum( nums );
		if ( sumOfArr % 2 != 0 )
			return false;

		final int length = nums.length;

		final boolean[][] booleanArr = new boolean[sumOfArr / 2 + 1][length + 1];

		for ( int i = 0; i < length + 1; i++ )
			booleanArr[0][i] = true;

		for ( int i = 1; i <= sumOfArr / 2; i++ )
			for ( int j = 1; j <= length; j++ )
				if ( nums[j - 1] <= i )
					booleanArr[i][j] = booleanArr[i][j - 1] || booleanArr[i - nums[j - 1]][j - 1];
				else
					booleanArr[i][j] = booleanArr[i][j - 1];

		return booleanArr[sumOfArr / 2][length];
	}

	private static int findSum( int[] nums )
	{
		int sum = 0;
		for ( int i : nums )
			sum += i;
		return sum;
	}
}
