package scjp.com.java.stackoverflow;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomIntegers
{
    public static final Random random = new Random();
    public static final int maxLimit = 6;
    public static final int minLimit = 0;
    public static final int noOfItems = 7;
    public static void main( String[] args )
    {
        Set<Integer> uniqueRandomIntegerSet = new HashSet< Integer >(); 
        
        while(uniqueRandomIntegerSet.size() < noOfItems)
            uniqueRandomIntegerSet.add( random.nextInt( maxLimit - minLimit + 1 ) + minLimit );  
        
        Integer[] randomUniqueIntegers = uniqueRandomIntegerSet.toArray( new Integer[0] );
    }
}
