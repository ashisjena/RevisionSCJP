package scjp.com.java.projecteuler;

public class Problem3
{
	public static void main( String[] args )
	{
		final long number = 2873;
		long newnumm = number;
		long largestFact = 0;

		int counter = 2;
		while ( counter * counter <= newnumm )
		{
			if ( newnumm % counter == 0 )
			{
				newnumm = newnumm / counter;
				largestFact = counter;
			}
			else
				counter++;
		}

		if ( newnumm > largestFact )
			largestFact = newnumm;
		
		System.out.println(largestFact);
	}
}